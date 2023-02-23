<template>
  <el-dialog
    :title="!dataForm.uuId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="uuUserId">
      <el-input v-model="dataForm.uuUserId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uuPromotionCode">
      <el-input v-model="dataForm.uuPromotionCode" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uuUpline">
      <el-input v-model="dataForm.uuUpline" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uuDatetime">
      <el-input v-model="dataForm.uuDatetime" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          uuId: 0,
          uuUserId: '',
          uuPromotionCode: '',
          uuUpline: '',
          uuDatetime: ''
        },
        dataRule: {
          uuUserId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uuPromotionCode: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uuUpline: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uuDatetime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.uuId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.uuId) {
            this.$http({
              url: this.$http.adornUrl(`/product/useruplinetbl/info/${this.dataForm.uuId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uuUserId = data.userUplineTbl.uuUserId
                this.dataForm.uuPromotionCode = data.userUplineTbl.uuPromotionCode
                this.dataForm.uuUpline = data.userUplineTbl.uuUpline
                this.dataForm.uuDatetime = data.userUplineTbl.uuDatetime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/useruplinetbl/${!this.dataForm.uuId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'uuId': this.dataForm.uuId || undefined,
                'uuUserId': this.dataForm.uuUserId,
                'uuPromotionCode': this.dataForm.uuPromotionCode,
                'uuUpline': this.dataForm.uuUpline,
                'uuDatetime': this.dataForm.uuDatetime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>

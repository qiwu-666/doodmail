<template>
  <el-dialog
    :title="!dataForm.btId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="btName">
      <el-input v-model="dataForm.btName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="btValue">
      <el-input v-model="dataForm.btValue" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="btModifiedDatetime">
      <el-input v-model="dataForm.btModifiedDatetime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="btRemarks">
      <el-input v-model="dataForm.btRemarks" placeholder=""></el-input>
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
          btId: 0,
          btName: '',
          btValue: '',
          btModifiedDatetime: '',
          btRemarks: ''
        },
        dataRule: {
          btName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          btValue: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          btModifiedDatetime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          btRemarks: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.btId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.btId) {
            this.$http({
              url: this.$http.adornUrl(`/product/bonustbl/info/${this.dataForm.btId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.btName = data.bonusTbl.btName
                this.dataForm.btValue = data.bonusTbl.btValue
                this.dataForm.btModifiedDatetime = data.bonusTbl.btModifiedDatetime
                this.dataForm.btRemarks = data.bonusTbl.btRemarks
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
              url: this.$http.adornUrl(`/product/bonustbl/${!this.dataForm.btId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'btId': this.dataForm.btId || undefined,
                'btName': this.dataForm.btName,
                'btValue': this.dataForm.btValue,
                'btModifiedDatetime': this.dataForm.btModifiedDatetime,
                'btRemarks': this.dataForm.btRemarks
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

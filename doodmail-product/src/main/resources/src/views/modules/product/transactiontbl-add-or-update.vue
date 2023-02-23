<template>
  <el-dialog
    :title="!dataForm.ttId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="ttRtId">
      <el-input v-model="dataForm.ttRtId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="ttUtId">
      <el-input v-model="dataForm.ttUtId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="ttAmount">
      <el-input v-model="dataForm.ttAmount" placeholder=""></el-input>
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
          ttId: 0,
          ttRtId: '',
          ttUtId: '',
          ttAmount: ''
        },
        dataRule: {
          ttRtId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          ttUtId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          ttAmount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.ttId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.ttId) {
            this.$http({
              url: this.$http.adornUrl(`/product/transactiontbl/info/${this.dataForm.ttId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.ttRtId = data.transactionTbl.ttRtId
                this.dataForm.ttUtId = data.transactionTbl.ttUtId
                this.dataForm.ttAmount = data.transactionTbl.ttAmount
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
              url: this.$http.adornUrl(`/product/transactiontbl/${!this.dataForm.ttId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'ttId': this.dataForm.ttId || undefined,
                'ttRtId': this.dataForm.ttRtId,
                'ttUtId': this.dataForm.ttUtId,
                'ttAmount': this.dataForm.ttAmount
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

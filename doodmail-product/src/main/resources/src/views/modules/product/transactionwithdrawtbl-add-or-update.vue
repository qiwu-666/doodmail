<template>
  <el-dialog
    :title="!dataForm.twtId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="twtAdminId">
      <el-input v-model="dataForm.twtAdminId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="twtDistributorId">
      <el-input v-model="dataForm.twtDistributorId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="twtAmount">
      <el-input v-model="dataForm.twtAmount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="twtDatetime">
      <el-input v-model="dataForm.twtDatetime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="twtRemarks">
      <el-input v-model="dataForm.twtRemarks" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="twtReferenceno">
      <el-input v-model="dataForm.twtReferenceno" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="twtAttachment">
      <el-input v-model="dataForm.twtAttachment" placeholder=""></el-input>
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
          twtId: 0,
          twtAdminId: '',
          twtDistributorId: '',
          twtAmount: '',
          twtDatetime: '',
          twtRemarks: '',
          twtReferenceno: '',
          twtAttachment: ''
        },
        dataRule: {
          twtAdminId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          twtDistributorId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          twtAmount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          twtDatetime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          twtRemarks: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          twtReferenceno: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          twtAttachment: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.twtId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.twtId) {
            this.$http({
              url: this.$http.adornUrl(`/product/transactionwithdrawtbl/info/${this.dataForm.twtId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.twtAdminId = data.transactionWithdrawTbl.twtAdminId
                this.dataForm.twtDistributorId = data.transactionWithdrawTbl.twtDistributorId
                this.dataForm.twtAmount = data.transactionWithdrawTbl.twtAmount
                this.dataForm.twtDatetime = data.transactionWithdrawTbl.twtDatetime
                this.dataForm.twtRemarks = data.transactionWithdrawTbl.twtRemarks
                this.dataForm.twtReferenceno = data.transactionWithdrawTbl.twtReferenceno
                this.dataForm.twtAttachment = data.transactionWithdrawTbl.twtAttachment
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
              url: this.$http.adornUrl(`/product/transactionwithdrawtbl/${!this.dataForm.twtId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'twtId': this.dataForm.twtId || undefined,
                'twtAdminId': this.dataForm.twtAdminId,
                'twtDistributorId': this.dataForm.twtDistributorId,
                'twtAmount': this.dataForm.twtAmount,
                'twtDatetime': this.dataForm.twtDatetime,
                'twtRemarks': this.dataForm.twtRemarks,
                'twtReferenceno': this.dataForm.twtReferenceno,
                'twtAttachment': this.dataForm.twtAttachment
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

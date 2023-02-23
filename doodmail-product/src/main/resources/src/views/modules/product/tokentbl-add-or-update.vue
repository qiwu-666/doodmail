<template>
  <el-dialog
    :title="!dataForm.tTokenId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="tUserId">
      <el-input v-model="dataForm.tUserId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="tTokenKey">
      <el-input v-model="dataForm.tTokenKey" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="tTokenStatus">
      <el-input v-model="dataForm.tTokenStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="tTokenExpireDate">
      <el-input v-model="dataForm.tTokenExpireDate" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="tTokenAccessType">
      <el-input v-model="dataForm.tTokenAccessType" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="tAppRandomKey">
      <el-input v-model="dataForm.tAppRandomKey" placeholder=""></el-input>
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
          tTokenId: 0,
          tUserId: '',
          tTokenKey: '',
          tTokenStatus: '',
          tTokenExpireDate: '',
          tTokenAccessType: '',
          tAppRandomKey: ''
        },
        dataRule: {
          tUserId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          tTokenKey: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          tTokenStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          tTokenExpireDate: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          tTokenAccessType: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          tAppRandomKey: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.tTokenId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.tTokenId) {
            this.$http({
              url: this.$http.adornUrl(`/product/tokentbl/info/${this.dataForm.tTokenId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tUserId = data.tokenTbl.tUserId
                this.dataForm.tTokenKey = data.tokenTbl.tTokenKey
                this.dataForm.tTokenStatus = data.tokenTbl.tTokenStatus
                this.dataForm.tTokenExpireDate = data.tokenTbl.tTokenExpireDate
                this.dataForm.tTokenAccessType = data.tokenTbl.tTokenAccessType
                this.dataForm.tAppRandomKey = data.tokenTbl.tAppRandomKey
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
              url: this.$http.adornUrl(`/product/tokentbl/${!this.dataForm.tTokenId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tTokenId': this.dataForm.tTokenId || undefined,
                'tUserId': this.dataForm.tUserId,
                'tTokenKey': this.dataForm.tTokenKey,
                'tTokenStatus': this.dataForm.tTokenStatus,
                'tTokenExpireDate': this.dataForm.tTokenExpireDate,
                'tTokenAccessType': this.dataForm.tTokenAccessType,
                'tAppRandomKey': this.dataForm.tAppRandomKey
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

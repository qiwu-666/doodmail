<template>
  <el-dialog
    :title="!dataForm.uUserId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="uLinkdoodId">
      <el-input v-model="dataForm.uLinkdoodId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uUserSecret">
      <el-input v-model="dataForm.uUserSecret" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uFirstName">
      <el-input v-model="dataForm.uFirstName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uLastName">
      <el-input v-model="dataForm.uLastName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uCountryCode">
      <el-input v-model="dataForm.uCountryCode" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uContactNo">
      <el-input v-model="dataForm.uContactNo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uDob">
      <el-input v-model="dataForm.uDob" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uLanguageKnown">
      <el-input v-model="dataForm.uLanguageKnown" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uGender">
      <el-input v-model="dataForm.uGender" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uEmailAddress">
      <el-input v-model="dataForm.uEmailAddress" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uLastLocation">
      <el-input v-model="dataForm.uLastLocation" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uLastLocationDatetime">
      <el-input v-model="dataForm.uLastLocationDatetime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uMoney">
      <el-input v-model="dataForm.uMoney" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uStatus">
      <el-input v-model="dataForm.uStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uNId">
      <el-input v-model="dataForm.uNId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uEnergy">
      <el-input v-model="dataForm.uEnergy" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uLevel">
      <el-input v-model="dataForm.uLevel" placeholder=""></el-input>
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
          uUserId: 0,
          uLinkdoodId: '',
          uUserSecret: '',
          uFirstName: '',
          uLastName: '',
          uCountryCode: '',
          uContactNo: '',
          uDob: '',
          uLanguageKnown: '',
          uGender: '',
          uEmailAddress: '',
          uLastLocation: '',
          uLastLocationDatetime: '',
          uMoney: '',
          uStatus: '',
          uNId: '',
          uEnergy: '',
          uLevel: ''
        },
        dataRule: {
          uLinkdoodId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uUserSecret: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uFirstName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uLastName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uCountryCode: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uContactNo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uDob: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uLanguageKnown: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uGender: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uEmailAddress: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uLastLocation: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uLastLocationDatetime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uMoney: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uNId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uEnergy: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uLevel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.uUserId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.uUserId) {
            this.$http({
              url: this.$http.adornUrl(`/product/usertbl/info/${this.dataForm.uUserId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uLinkdoodId = data.userTbl.uLinkdoodId
                this.dataForm.uUserSecret = data.userTbl.uUserSecret
                this.dataForm.uFirstName = data.userTbl.uFirstName
                this.dataForm.uLastName = data.userTbl.uLastName
                this.dataForm.uCountryCode = data.userTbl.uCountryCode
                this.dataForm.uContactNo = data.userTbl.uContactNo
                this.dataForm.uDob = data.userTbl.uDob
                this.dataForm.uLanguageKnown = data.userTbl.uLanguageKnown
                this.dataForm.uGender = data.userTbl.uGender
                this.dataForm.uEmailAddress = data.userTbl.uEmailAddress
                this.dataForm.uLastLocation = data.userTbl.uLastLocation
                this.dataForm.uLastLocationDatetime = data.userTbl.uLastLocationDatetime
                this.dataForm.uMoney = data.userTbl.uMoney
                this.dataForm.uStatus = data.userTbl.uStatus
                this.dataForm.uNId = data.userTbl.uNId
                this.dataForm.uEnergy = data.userTbl.uEnergy
                this.dataForm.uLevel = data.userTbl.uLevel
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
              url: this.$http.adornUrl(`/product/usertbl/${!this.dataForm.uUserId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'uUserId': this.dataForm.uUserId || undefined,
                'uLinkdoodId': this.dataForm.uLinkdoodId,
                'uUserSecret': this.dataForm.uUserSecret,
                'uFirstName': this.dataForm.uFirstName,
                'uLastName': this.dataForm.uLastName,
                'uCountryCode': this.dataForm.uCountryCode,
                'uContactNo': this.dataForm.uContactNo,
                'uDob': this.dataForm.uDob,
                'uLanguageKnown': this.dataForm.uLanguageKnown,
                'uGender': this.dataForm.uGender,
                'uEmailAddress': this.dataForm.uEmailAddress,
                'uLastLocation': this.dataForm.uLastLocation,
                'uLastLocationDatetime': this.dataForm.uLastLocationDatetime,
                'uMoney': this.dataForm.uMoney,
                'uStatus': this.dataForm.uStatus,
                'uNId': this.dataForm.uNId,
                'uEnergy': this.dataForm.uEnergy,
                'uLevel': this.dataForm.uLevel
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

<template>
  <el-dialog
    :title="!dataForm.rtId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="rtPromotionCode">
      <el-input v-model="dataForm.rtPromotionCode" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtOtn">
      <el-input v-model="dataForm.rtOtn" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtOriPrice">
      <el-input v-model="dataForm.rtOriPrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtFinalPrice">
      <el-input v-model="dataForm.rtFinalPrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtVmType">
      <el-input v-model="dataForm.rtVmType" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtDatetime">
      <el-input v-model="dataForm.rtDatetime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtInsertedDatetime">
      <el-input v-model="dataForm.rtInsertedDatetime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtProfit">
      <el-input v-model="dataForm.rtProfit" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtCurrency">
      <el-input v-model="dataForm.rtCurrency" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtHash">
      <el-input v-model="dataForm.rtHash" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rtInout">
      <el-input v-model="dataForm.rtInout" placeholder=""></el-input>
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
          rtId: 0,
          rtPromotionCode: '',
          rtOtn: '',
          rtOriPrice: '',
          rtFinalPrice: '',
          rtVmType: '',
          rtDatetime: '',
          rtInsertedDatetime: '',
          rtProfit: '',
          rtCurrency: '',
          rtHash: '',
          rtInout: ''
        },
        dataRule: {
          rtPromotionCode: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtOtn: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtOriPrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtFinalPrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtVmType: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtDatetime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtInsertedDatetime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtProfit: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtCurrency: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtHash: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rtInout: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.rtId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.rtId) {
            this.$http({
              url: this.$http.adornUrl(`/product/recordpendingtbl/info/${this.dataForm.rtId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.rtPromotionCode = data.recordPendingTbl.rtPromotionCode
                this.dataForm.rtOtn = data.recordPendingTbl.rtOtn
                this.dataForm.rtOriPrice = data.recordPendingTbl.rtOriPrice
                this.dataForm.rtFinalPrice = data.recordPendingTbl.rtFinalPrice
                this.dataForm.rtVmType = data.recordPendingTbl.rtVmType
                this.dataForm.rtDatetime = data.recordPendingTbl.rtDatetime
                this.dataForm.rtInsertedDatetime = data.recordPendingTbl.rtInsertedDatetime
                this.dataForm.rtProfit = data.recordPendingTbl.rtProfit
                this.dataForm.rtCurrency = data.recordPendingTbl.rtCurrency
                this.dataForm.rtHash = data.recordPendingTbl.rtHash
                this.dataForm.rtInout = data.recordPendingTbl.rtInout
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
              url: this.$http.adornUrl(`/product/recordpendingtbl/${!this.dataForm.rtId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'rtId': this.dataForm.rtId || undefined,
                'rtPromotionCode': this.dataForm.rtPromotionCode,
                'rtOtn': this.dataForm.rtOtn,
                'rtOriPrice': this.dataForm.rtOriPrice,
                'rtFinalPrice': this.dataForm.rtFinalPrice,
                'rtVmType': this.dataForm.rtVmType,
                'rtDatetime': this.dataForm.rtDatetime,
                'rtInsertedDatetime': this.dataForm.rtInsertedDatetime,
                'rtProfit': this.dataForm.rtProfit,
                'rtCurrency': this.dataForm.rtCurrency,
                'rtHash': this.dataForm.rtHash,
                'rtInout': this.dataForm.rtInout
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

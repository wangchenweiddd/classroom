<template>
  <div>
    <div style="display: flex;flex-direction: row;justify-content: space-between;margin-bottom: 10px">
      <h2>日志管理</h2>
      <el-date-picker
        v-model="timeRange"
        type="datetimerange"
        range-separator="-"
        format="yyyy-MM-dd HH:mm:ss"
        value-format="yyyy-MM-dd HH:mm:ss"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        @change="selectTime">
      </el-date-picker>
    </div>
    <div>
      <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%">
        <el-table-column
          prop="userId"
          label="用户id"
          align="center">
        </el-table-column>
        <el-table-column
          prop="property"
          label="控制类型"
          align="center">
        </el-table-column>
        <el-table-column
          prop="createTimeStr"
          label="创建时间"
          align="center">
        </el-table-column>
        <el-table-column
          prop="id"
          label="操作id"
          align="center">
        </el-table-column>
        <el-table-column
          label="查看详情"
          align="center">
          <template slot-scope="scope">
            <el-button
              type="text"
              size="mini"
              @click="handleClick(scope.row)">查看详情</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <Modal
      width="900px"
      v-model="modal1"
      title="查看日志详情"
      :mask-closable="false">
      <Table border :columns="columns1" :data="data1"></Table>
      <div slot="footer">
        <Button type="primary" @click="ok" >确定</Button>
      </div>
    </Modal>
  </div>


</template>

<script>
    import moment from "moment";

    export default {
      name: "DailyRecord",
      mounted() {
        this.allDaily()
      },
      data() {
          return {
            modal1: false,
            tableData: [],
            timeRange: [],
            startTime: '',
            endTime: '',
            detail: [],
            data1: [],
            columns1: [
              {
                title: '更新时间',
                key: 'updateTime',
                width: 150
              },
              {
                title: '所属教室',
                key: 'regionFullName'
              },
              {
                title: '空调编号',
                key: 'deviceId'
              },
              {
                title: '空调名称',
                key: 'fullName'
              },
              {
                title: '操作编号',
                key: 'operateId'
              },
              {
                title: '操作结果',
                key: 'status'
              },
            ]
          }
      },
      methods:{
        transformTime(data) {
          return moment(data).format('YYYY-MM-DD HH:MM:SS')
        },
        handleClick(row) {
          this.modal1 = true
          this.data1 = []
          this.$api.getDailyDetail(row.id, '总数').then(res => {
            console.log('res',res)
            this.detail = res.data.data
            this.detail.forEach(item => {
              item.airConControlLogEntity.regionFullName = item.airConRegionEntity.regionFullName
              item.airConControlLogEntity.fullName = item.airConInfoEntity.fullName
              item.airConControlLogEntity.updateTime = moment(item.airConControlLogEntity.updateTime).format('YYYY-MM-DD HH:MM:SS')
              this.data1.push(item.airConControlLogEntity)
            })
            console.log('data1', this.data1)
          })
        },
        ok() {
          this.modal1 = false
        },
        allDaily() {
          this.$api.getDailyData('160', '2020-05-28 00:00:00', '2020-12-31 00:00:00').then(res => {
            console.log('res',res)
            res.data.data.forEach(item => {
              this.tableData.push(item.userOperateVo)
            })
            console.log('tableData',this.tableData)
          })
        },
        selectTime(){
          if (!this.timeRange) {
            this.startTime = ''
            this.endTime = ''
          } else {
            this.startTime = this.timeRange[0]
            this.endTime = this.timeRange[1]
          }
          this.getServerList()
        },
        getServerList() {
          this.tableData=[]
          this.$api.getDailyData('160', this.startTime, this.endTime).then(res => {
            console.log('res',res)
            res.data.data.forEach(item => {
              this.tableData.push(item.userOperateVo)
            })
            console.log('tableData',this.tableData)
          })
        }
      }
    }
</script>

<style scoped>

</style>

<template>
  <div>
    <Row>
      <Col span="4">
        <div class="tree-container">
          <Tree @on-select-change="selectNode" @node-contextmenu="nodeContext" :data="treeDataShow"
                v-loading="!treeDataShow.length"></Tree>
        </div>
      </Col>
      <Col span="20">
        <div class="content" v-loading="loading">
          <div style="width: 100%; display: flex;flex-direction: row;justify-content: center;align-items: center">
            <el-button type="primary" @click="showTotal" style="width: 90px" ghost>总数 {{total}}</el-button>
            <el-button type="primary" @click="showOnline" style="width: 90px" ghost>在线 {{online}}</el-button>
            <el-button type="primary" @click="showOffline" style="width: 90px" ghost>离线 {{offline}}</el-button>
          </div>
          <div class="content-item" @click.stop="selectThisSet(item)" v-for="(item, index) in pduInfoList">
            <Card v-loading="!pduInfoList.length">
              <div class="title-con" slot="title">
                <div style="display: flex;flex-direction: row;justify-content: flex-start;line-height: 22px">
                  <Icon type="ios-home" size="22"/>
                  <span>{{item.name}}<i v-if="item.selected" class="el-icon-circle-check time-selected"></i></span>
                </div>
                <span style="color: #409EFF" @click.stop="openDetail(item)">详情</span>
              </div>
              <div class="card-container">
                <div class="card-left">
                  <span>功率{{item.p}}W</span>
                </div>
                <div class="card-mid">
                  <span>电压{{item.u}}V</span>
                </div>
                <div class="card-right">
                  <span>电流{{item.i}}A</span>
                </div>
              </div>
              <div class="card-bottom"><span>{{item.ip}}</span><span>{{transformTime(item.lastUpdateTime)}}</span></div>
            </Card>
          </div>
          <div v-if="!pduInfoList.length && !loading">暂无数据</div>
          <Modal
            v-model="modal1"
            title="pdu控制"
            :mask-closable="false"
          >
            <Form :model="formItem" label-position="left" :label-width="100">
              <FormItem label="选择端口:">
                <RadioGroup v-model="formItem.num">
                  <Radio label="1" border></Radio>
                  <Radio label="2" border></Radio>
                  <Radio label="3" border></Radio>
                  <Radio label="4" border></Radio>
                  <Radio label="5" border></Radio>
                  <Radio label="6" border></Radio>
                  <Radio label="7" border></Radio>
                  <Radio label="8" border></Radio>
                </RadioGroup>
              </FormItem>
              <FormItem label="操作:">
                <RadioGroup v-model="formItem.port">
                  <Radio label="1">重启</Radio>
                  <Radio label="2">延时开</Radio>
                  <Radio label="3">延时关</Radio>
                  <Radio label="4">延时重启</Radio>
                  <Radio label="5">打开</Radio>
                  <Radio label="6">关闭</Radio>
                </RadioGroup>
              </FormItem>
            </Form>
            <div slot="footer">
              <Button type="primary" @click="ok1">确定</Button>
            </div>
          </Modal>
          <Modal
            v-model="modal2"
            title="PDU详情"
            :mask-closable="false"
            width="1200px"
          >
            <div style="display: flex;flex-direction: row;flex-wrap: wrap;justify-content: space-between">
              <Card dis-hover style="width: 180px">
                <p slot="title">PDU名称</p>
                <p>{{pduname}}</p>
              </Card>
              <Card dis-hover style="width: 180px">
                <p slot="title">IP地址</p>
                <p>{{ip}}</p>
              </Card>
              <Card dis-hover style="width: 180px">
                <p slot="title">最后通信时间</p>
                <p>{{transformTime(latetime)}}</p>
              </Card>
              <Card dis-hover style="width: 180px">
                <p slot="title">最小功率限制</p>
                <p>0W</p>
              </Card>
              <Card dis-hover style="width: 180px">
                <p slot="title">最大功率限制</p>
                <p>3000W</p>
              </Card>
              <Card dis-hover style="width: 180px">
                <p slot="title">功率报警线</p>
                <p>2200W</p>
              </Card>
              <Card dis-hover style="width: 180px;margin-top: 5px">
                <p slot="title">最小电流限制</p>
                <p>0A</p>
              </Card>
              <Card dis-hover style="width: 180px;margin-top: 5px">
                <p slot="title">最大电流限制</p>
                <p>12A</p>
              </Card>
              <Card dis-hover style="width: 180px;margin-top: 5px">
                <p slot="title">电流报警线</p>
                <p>10A</p>
              </Card>
              <Card dis-hover style="width: 180px;margin-top: 5px">
                <p slot="title">最小电压限制</p>
                <p>200V</p>
              </Card>
              <Card dis-hover style="width: 180px;margin-top: 5px">
                <p slot="title">最大电压限制</p>
                <p>245V</p>
              </Card>
              <Card dis-hover style="width: 180px;margin-top: 5px">
                <p slot="title">电压报警线</p>
                <p>230V</p>
              </Card>
            </div>
            <div style="margin-top: 50px;display: flex;flex-direction: row;justify-content: space-between" v-show="judge">
              <div id="dianliu" style="width: 500px;height:400px;"></div>
              <div id="dianya" style="width: 500px;height:400px;"></div>
            </div>
            <div slot="footer">
              <Button type="primary" @click="ok2">确定</Button>
            </div>
          </Modal>
        </div>
      </Col>
    </Row>
  </div>
</template>

<script>
  import echarts from 'echarts'
  import moment from 'moment'
  export default {
    name: "HomePage",
    mounted() {
      this.getTree()
      this.getPduList()
      this.getpduStatus()
    },
    data() {
      return {
        current: '',
        voltage: '',
        judge: false,
        pduname: '',
        ip: '',
        getId: '',
        latetime: '',
        formItem: {
          num: '',
          port: ''
        },
        currentId: '',
        total: 100,
        online: 50,
        offline: 50,
        modal1: false,
        modal2: false,
        currentRegionCode: '01',
        treeDataShow: [],
        loading: false,
        currentTreeType: 'campus',
        currentType: 'school',
        currentTreeId: '5',
        pduStatus: '总数',
        pduInfoList: [],
        pduAllList: []
      }
    },
    methods: {
      ok1() {
        let json = {
          equId: this.currentId,
          port: this.formItem.port,
          mark: '1'
        }
        this.$api.getPduSwitch(json).then(res => {
          console.log(res)
          this.$Message.info(res.data.msg)
        })
        this.modal1 = false
      },
      ok2() {
        this.modal2 = false
      },
      selectThisSet(item) {
        console.log('item', item)
        this.currentId = item.equId
        this.modal1 = true
      },
      showTotal() {
        this.pduInfoList = []
        let json = {
          type: this.currentTreeType,
          id: this.currentTreeId,
          select: '总数'
        }
        this.$api.getPduList(json).then(res => {
          res.data.data.forEach(item => {
            // this.pduAllList.push({...item.pduBaseInfo, ...item.pduUpdateInfoCur})
            if (item.pduUpdateInfoCur) {
              item.pduBaseInfo.i = item.pduUpdateInfoCur.i
              item.pduBaseInfo.u = item.pduUpdateInfoCur.u
              item.pduBaseInfo.p = item.pduUpdateInfoCur.p
              item.pduBaseInfo.equId = item.pduUpdateInfoCur.equId
            }
            this.pduInfoList.push(item.pduBaseInfo)
          })
        })
      },
      showOnline() {
        this.pduInfoList = []
        let json = {
          type: this.currentTreeType,
          id: this.currentTreeId,
          select: '在线数'
        }
        this.$api.getPduList(json).then(res => {
          res.data.data.forEach(item => {
            // this.pduAllList.push({...item.pduBaseInfo, ...item.pduUpdateInfoCur})
            if (item.pduUpdateInfoCur) {
              item.pduBaseInfo.i = item.pduUpdateInfoCur.i
              item.pduBaseInfo.u = item.pduUpdateInfoCur.u
              item.pduBaseInfo.p = item.pduUpdateInfoCur.p
              item.pduBaseInfo.equId = item.pduUpdateInfoCur.equId
            }
            this.pduInfoList.push(item.pduBaseInfo)
          })
        })
      },
      showOffline() {
        this.pduInfoList = []
        let json = {
          type: this.currentTreeType,
          id: this.currentTreeId,
          select: '离线数'
        }
        this.$api.getPduList(json).then(res => {
          res.data.data.forEach(item => {
            // this.pduAllList.push({...item.pduBaseInfo, ...item.pduUpdateInfoCur})
            if (item.pduUpdateInfoCur) {
              item.pduBaseInfo.i = item.pduUpdateInfoCur.i
              item.pduBaseInfo.u = item.pduUpdateInfoCur.u
              item.pduBaseInfo.p = item.pduUpdateInfoCur.p
              item.pduBaseInfo.equId = item.pduUpdateInfoCur.equId
            }
            this.pduInfoList.push(item.pduBaseInfo)
          })
        })
      },
      getpduStatus() {
        let json = {
          type: this.currentType,
          id: this.currentTreeId
        }
        this.$api.getPduStatus(json).then(res => {
          console.log('status',res)
          this.total = res.data.data.all
          this.offline = res.data.data.offline
          this.online = res.data.data.online
        })
      },
      transformTime(data) {
        return moment(data).format('YYYY-MM-DD HH:MM:SS')
      },
      showdianliu() {
        var myChart = this.$echarts.init(document.getElementById("dianliu"));
        myChart.setOption({
          title: {
            text: "72h电流展示图(A)",
            x: 'center',
            y: 'top'
          },
          //图例-每一条数据的名字
          // legend:{
          //   data:['安培']
          // },
          tooltip : {
            show: true,
            trigger: 'axis'
          },
          //x轴
          xAxis:{
            type : 'category',
            boundaryGap: false,
            data:["9h","18h","27h","36h","45h","54h","63h","72h"]
          },
          //y轴没有显式设置，根据值自动生成y轴
          yAxis:{
            type: 'value'
          },
          //数据-data是最终要显示的数据
          series:[{
            name:'电流',
            type:'line',
            data: this.current
            // data:[5,6,7,8,5,6,9,8]
          }]
        })
      },
      showdianya() {
        var myChart = this.$echarts.init(document.getElementById("dianya"));
        myChart.setOption({
          title: {
            text: "72h电压展示图(V)",
            x: 'center',
            y: 'top'
          },
          //图例-每一条数据的名字
          // legend:{
          //   data:['安培']
          // },
          tooltip : {
            show: true,
            trigger: 'axis'
          },
          //x轴
          xAxis:{
            type : 'category',
            boundaryGap: false,
            data:["9h","18h","27h","36h","45h","54h","63h","72h"]
          },
          //y轴没有显式设置，根据值自动生成y轴
          yAxis:{
            type: 'value'
          },
          //数据-data是最终要显示的数据
          series:[{
            name:'电压',
            type:'line',
            data: this.voltage
            // data:[5.565,6,7,8,5,6,9,8]
          }]
        })
      },
      // async await
      async getdata() {
        let json = {
          equId: this.getId
        }
        await this.$api.getdianliu(json).then(res => {
          // console.log('dianliu',res)
          this.current = res.data.data.yvalue
          // console.log('current',this.current)
        })
        await this.$api.getdianya(json).then(res => {
          // console.log('dainya',res)
          this.voltage = res.data.data.yvalue
          // console.log('voltage', this.voltage)
        })
        this.judge = true
        this.showdianliu()
        this.showdianya()
      },
      // getdianliu() {
      //   let json = {
      //     equId: this.getId
      //   }
      //   this.$api.getdianliu(json).then(res => {
      //     console.log('dianliu',res)
      //     this.current = res.data.data.yvalue
      //     console.log('current',this.current)
      //   })
      // },
      // getdianya() {
      //   let json = {
      //     equId: this.getId
      //   }
      //   this.$api.getdianya(json).then(res => {
      //     console.log('dainya',res)
      //     this.voltage = res.data.data.yvalue
      //     console.log('voltage', this.voltage)
      //   })
      // },
      openDetail(data) {
        console.log('data', data)
        this.modal2 = true
        this.getId = data.equId
        this.pduname = data.name
        this.ip = data.ip
        this.latetime = data.lastUpdateTime

        // this.getdianliu()
        // this.getdianya()
        this.getdata()
        // this.showdianliu()
        // this.showdianya()

        // 获取详情接口，可从data中获取数据，接口暂时不用
        // let json = {
        //   equId: data.equId
        // }
        // this.$api.getPduDetail(json).then(res => {
        //   console.log('detail',res)
        // })
      },
      getTree() {
        // let json = {
        //   type: this.currentTreeType,
        //   // id: ''
        //   id: this.currentTreeId
        // }
        // this.$api.getPduTree(json).then(res => {
        //   res.data.forEach(item => {
        //     item.title = item.name
        //   })
        //   this.treeDataShow = res.data
        // })
        this.treeDataShow = [
          {
            id: 5,
            isParent: true,
            name: '磬苑校区',
            nodekey: 0,
            pid: "school_0",
            title: "磬苑校区",
            type: "campus",
            expand: true,
            children: [
              {
                id: 3,
                isParent: true,
                name: '博学南楼',
                nodekey: 0,
                pid: "campus_5",
                title: "博学南楼",
                type: "group"
              },
              {
                id: 4,
                isParent: true,
                name: '博学北楼',
                nodekey: 1,
                pid: "campus_5",
                title: "博学北楼",
                type: "group"
              },
              {
                id: 5,
                isParent: true,
                name: '笃行南楼',
                nodekey: 2,
                pid: "campus_5",
                title: "笃行南楼",
                type: "group"
              },
              {
                id: 6,
                isParent: true,
                name: '笃行北楼',
                nodekey: 3,
                pid: "campus_5",
                title: "笃行北楼",
                type: "group"
              },
            ]
          },
        ]
      },
      selectNode(data, item) {
        this.pduAllList = []
        this.currentTreeType = item.type
        this.currentType = item.type
        this.currentTreeId = item.id
        // if (this.currentTreeType === 'build') {
        //   return
        // }
        // let json = {
        //   type: this.currentTreeType,
        //   id: this.currentTreeId
        // }
        // this.$api.getPduTree(json).then(res => {
        //   res.data.forEach(item => {
        //     if (!item.title) {
        //       item.title = item.name
        //     }
        //   })
        //   this.$set(item, 'children', res.data)
        // })
        // console.log('type', this.currentTreeType)
        // console.log('id', this.currentTreeId)
        this.getpduStatus()
        let json = {
          type: this.currentTreeType,
          id: this.currentTreeId,
          select: this.pduStatus
        }
        this.$api.getPduList(json).then(res => {
          res.data.data.forEach(item => {
            // this.pduAllList.push({...item.pduBaseInfo, ...item.pduUpdateInfoCur})
            if(item.pduUpdateInfoCur) {
              item.pduBaseInfo.i = item.pduUpdateInfoCur.i
              item.pduBaseInfo.u = item.pduUpdateInfoCur.u
              item.pduBaseInfo.p = item.pduUpdateInfoCur.p
              item.pduBaseInfo.equId = item.pduUpdateInfoCur.equId
            }
            this.pduAllList.push(item.pduBaseInfo)
          })
          console.log('this.pduAllList', this.pduAllList)
        })
        this.pduInfoList = this.pduAllList
      },
      nodeContext(data) {
        console.log(data)
      },
      getPduList() {
        this.loading = true
        let json = {
          type: this.currentTreeType,
          id: this.currentTreeId,
          select: this.pduStatus
        }
        this.$api.getPduList(json).then(res => {
          console.log('rrreeeessssss', res)
          this.loading = false
          res.data.data.forEach(item => {
            // this.pduInfoList.push({...item.pduBaseInfo, ...item.pduUpdateInfoCur})
            if(item.pduUpdateInfoCur) {
              item.pduBaseInfo.i = item.pduUpdateInfoCur.i
              item.pduBaseInfo.u = item.pduUpdateInfoCur.u
              item.pduBaseInfo.p = item.pduUpdateInfoCur.p
              item.pduBaseInfo.equId = item.pduUpdateInfoCur.equId
            }
            this.pduInfoList.push(item.pduBaseInfo)
          })
          console.log('this.pduInfoList', this.pduInfoList)
        })

      },

    }
  }
</script>

<style scoped>
  .tree-container {
    overflow: auto;
    height: calc(100vh - 100px);
    border: 1px solid #e8eaec;
    border-radius: 5px;
    padding: 10px;

    /*&::-webkit-scrollbar {*/
    /*  width: 3px;*/
    /*}*/

    /*&::-webkit-scrollbar-thumb {*/
    /*  background: #d8d8d8;*/
    /*  border-radius: 10px;*/
    /*}*/

    /*&::-webkit-scrollbar-track-piece {*/
    /*  background: transparent;*/
    /*}*/
  }

  .content {
    display: flex;
    padding: 10px 10px 10px 20px;
    flex-wrap: wrap;
    height: calc(100vh - 100px);
    overflow: auto;
  }

  .content-item {
    flex: 0 0 300px;
    height: 175px;
    margin-left: 50px;
    margin-top: 20px;
  }

  .card-container {
    display: flex;
  }

  .title-con {
    justify-content: space-between;
    display: flex;
    line-height: 22px;
  }

  .card-left {
    flex: 1;
    text-align: center;
    line-height: 66px;
    display: flex;
  }

  .card-mid {
    flex: 1;
    text-align: center;
    line-height: 66px;
  }

  .card-right {
    flex: 1;
    text-align: center;
    line-height: 66px;

  }

  .room-light {
    font-size: 25px;
    margin-right: 5px;
  }

  .set-active {
    color: #409EFF;
  }

  @font-face {
    font-family: "iconfont";
    src: url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.eot?t=1591014838214'); /* IE9 */
    src: url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.eot?t=1591014838214#iefix') format('embedded-opentype'), /* IE6-IE8 */ url('data:application/x-font-woff2;charset=utf-8;base64,d09GMgABAAAAAAXUAAsAAAAACuwAAAWHAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHEIGVgCDHAqJKIdNATYCJAMQCwoABCAFhG0HSBs/CRFVpJmR/Shwd3K+lRvnzcu6X49LsRxk8HTaz1uk27dF4lK84mBtjgyKIxDch5mt6VhDVpgI1SVrWX76/zbf7vylKeM8TqMUCg0WRQIEEPz/+82KWITTxW6j0YvJ+x/VJqaREEmweV1IZhbK8lbqcpuB7ArWbeUXjwcCgMIPMSAlZTUtEMDBWY0AIONGjxwMoWQF18MiEAyylm05P7IBPARmJfMEwPr498k3SCICwIBn4azbMKJ0GAo+9/08m5UcEvqFBCincwOQdgJYADEAOICMavUOAZvqYmJE27I5pAEQXDcDTDXL//NshyNVHQUJvA9gqP95RAYHubDUFD17xpS+GBjgc39FG5bNqq4A4sJtBABagKwHyIdwcJ94MREsBF9K2UCOvQei9lTK5S4u/v5+TTMtlhbJ2grpaCikg6K4+rA32X/cP4zd3maz9aOrTISIkAxtdN+h9IJdBzr7iK1qUGLWtZkPhdE9BzStRg0o0dpsfQgOYLW2WiwTRNC2PtGtrm2RLa2mbgS/MJnI77KV3bEEcBcsAGSYW29rJ3i47fZoM9ETfvv11VfBGTUXrb4WSx9Wf2jVATB7jmDry9Vv/55jc+V0z8XstJYq7tuD2V22DulKiHzfNS+293q4Yu9VtMhXGSSjqFht1ptylkZh/vMm9VzSmvaoiaFbQ1bv1XTHWKyhRqPZbNIS06nk20O7mNR0i91n2yW6jPmgZ3eCxaoxribc+Fabfai5V6s17VNTAzKI7gDuQ1q6YR2WdaOqZ0pzV/fQg+gyM0xqQ5cGxr060exdDYPhNJtWH2artCRT0hj39w77bgZ1VrbRqGNOT2V6epipjY368uCZnvs7PLXvaSO0T3nPDrMwsyy4UY8GdmpPz6DvIvgZMmWRUjZCLK2RL1fG744nMzM8I6qbkvftycqbkhSaMXI8xRTQ8RmjQoon52WdKfStmoJyZuiSJUOJKw3XJUNRXj1lyk8jI0Y++7Si4rKHnrDmEVdq7nmnIthKzPuT58vLGgv9dXi+f2RLImmbNrUP08awLtKWWD7HnqBC0t5GipyCi3/b7woocanwUqDSxcyL9+lEitrbNN9tcrrCVqg2jT3s5VTa0Ork3It8VhojVVc7ZXtUVenH6KurhFQaLCh/7J2yYcmGENpAQ+J5UrzH7c2i76nfo2Hkqfqp8yDxa9/VvLsh2vBE8+RR6rPZBYs9MhA5aTFI/4m9q0OrQvu93/Thw/wBw6D//XF8fML7ows2e0Qgc9JmkNqJvXN7CUWE+nXJZNk78ccUL64MF+kyETGYmXfSoGM74oaUDNjQ5H5R+Lih2JTjXxBa8i+zd0Qn6Zy+l3ypfCsNXypccYO4BLoQum1xZh3enO3utu2bKh/699+/P/b16WTGQId6C7UZi7dRV4WXwlX5Z9rb8q/2XQDGj0NurH6chkkAAEcv+5IdDjiWMc/Y+YBD4may0kt9OSyTLUoY6J7zmyA+1UNv/6M9F6swDK9XJax8YbdxMwCH45my2rFxnK70sRl4Azigz4nwamkDRQEONqj0nQLXGMUAIdDkwHDiCyxBCJGjxgBPlAIygnygou12FqmwIbIzgCgPBgi5JzDcXAeW3IvIUT/A0/qDjLwhUH1y9ikKK1+sGJVgAvoOeUyN8RyySEr3mHaV4qI65p2R2zwEgetXUztskKfYoL2koYgBw1TDljkZVhWBZSowFjcTsZHnmbYncmOqewvFGFIESgDtDuRipGHCwWJR+/k9lOpUFO7paUieIdbK5w4CLh8g7lAD9dxKdesiFRIuagAjFZMa2HJuVLlxAmz7UgUUE66MImpFPK6fQZG7PF7fwhMAKGchLoawhCM8+P+f3EyWgrU97Zt0jLOSmlRyRb0eAA==') format('woff2'),
    url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.woff?t=1591014838214') format('woff'),
    url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.ttf?t=1591014838214') format('truetype'), /* chrome, firefox, opera, Safari, Android, iOS 4.2+ */ url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.svg?t=1591014838214#iconfont') format('svg'); /* iOS 4.1- */
  }

  .iconfont {
    font-family: "iconfont" !important;
    font-size: 25px;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }

  .icon-light:before {
    content: "\e63b";
  }

  .icon-temperature:before {
    content: "\e61d";
  }

  .icon-kongtiao:before {
    content: "\e61f";
    font-size: 18px;
  }

  .card-bottom {
    display: flex;
    justify-content: space-between;
  }

  .time-selected {
    color: #409EFF;
  }


</style>

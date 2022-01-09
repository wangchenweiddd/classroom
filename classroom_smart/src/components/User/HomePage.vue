<template>
  <div>
    <Row>
      <Col span="4">
        <div class="tree-container">
          <Tree @on-select-change="selectNode" @node-contextmenu="nodeContext" :data="treeDataShow" v-loading="!treeDataShow.length"></Tree>
        </div>
      </Col>
      <Col span="20">
        <div class="content">
          <Card v-loading="!classRoomList.length" class="content-item" v-for="(item, index) in classRoomList">
            <p class="title-con" slot="title">{{item.regionFullName}}
              <span>{{item.numCount}}人</span>
            </p>
            <div class="card-container">
              <div class="card-left">
                <i class="iconfont icon-temperature"></i>
                <div class="air-tem">{{item.etemp}}℃</div>
              </div>
              <div class="card-mid">
                <i class="icon-kongtiao iconfont" :class="{'set-active': item.aoc === '开机'}"></i>
              </div>
              <div class="card-right">
                <i class="iconfont icon-light room-light" :class="{'set-active': item.lightFront === '开'}"></i>
                <i class="iconfont icon-light room-light" :class="{'set-active': item.lightBehind === '开'}"></i>
              </div>
            </div>
          </Card>
          <div v-if="!classRoomList.length">暂无数据</div>
        </div>
      </Col>
    </Row>
  </div>
</template>

<script>
  export default {
    name: "HomePage",
    mounted() {
      this.getTree()
      this.getClassroomDataFunc()
    },
    data() {
      return {
        currentRegionCode: '01',
        treeData: [],
        treeDataShow: [],
        classRoomList: []
      }
    },
    methods: {
      getTree() {
        // this.$api.getTree("160").then(res => {
        //   this.treeData = res.data.data;
        //   this.treeData.unshift({
        //     id: "school.0",
        //     name: '安徽大学',
        //     title: "安徽大学",
        //     regionCode: "0",
        //     open: false,
        //     pid: ""
        //   });
        //   this.treeData.forEach(item => {
        //     item.title = item.name
        //   })
        //   this.startTrans()
        // })
        this.treeDataShow = [
          {
            id: "school.0",
            name: '安徽大学',
            title: "安徽大学",
            regionCode: "0",
            open: false,
            pid: "",
            expand: true,
            children: [
              {
                id: "campus.1",
                name: '磬苑校区',
                pid: "school.0",
                open: 'false',
                regionCode: "01",
                title: "磬苑校区",
                expand: true,
                children: [
                  {
                    id: "group.1",
                    name: '博学南楼',
                    pid: "campus.1",
                    open: 'false',
                    regionCode: "0101",
                    title: "博学南楼",
                    expand: true,
                    children: [
                      {
                        id: "build.1",
                        name: '博南A楼',
                        pid: "group.1",
                        open: 'false',
                        regionCode: "010101",
                        title: "博南A楼",
                        expand: true,
                        children: [
                          {
                            id: "floor.1",
                            name: '博南A楼1层',
                            pid: "build.1",
                            open: 'false',
                            regionCode: "01010101",
                            title: "博南A楼1层",
                          },
                          {
                            id: "floor.2",
                            name: '博南A楼2层',
                            pid: "build.1",
                            open: 'false',
                            regionCode: "01010102",
                            title: "博南A楼2层",
                          },
                          {
                            id: "floor.3",
                            name: '博南A楼3层',
                            pid: "build.1",
                            open: 'false',
                            regionCode: "01010103",
                            title: "博南A楼3层",
                          },
                          {
                            id: "floor.4",
                            name: '博南A楼4层',
                            pid: "build.1",
                            open: 'false',
                            regionCode: "01010104",
                            title: "博南A楼4层",
                          }
                        ]
                      }
                    ]
                  }
                ]
              }
            ]
          }
        ]
      },
      // startTrans() {
      //   //没有父节点的数据
      //   let parents = this.treeData.filter(
      //     value => value.pid == '' || value.pid == null
      //   )
      //
      //   //有父节点的数据
      //   let childrens = this.treeData.filter(
      //     value => value.pid !== "undefined" && value.pid != null
      //   )
      //   this.treeDataShow = this.translateTree(parents, childrens)
      // },
      // translateTree(parents, childrens) {
      //   parents.forEach(parent => {
      //     childrens.forEach((child, index) => {
      //       if (child.pid === parent.id) {
      //
      //         let temp = JSON.parse(JSON.stringify(childrens))
      //
      //         temp.splice(index, 1)
      //
      //         this.translateTree([child], temp)
      //
      //         typeof parent.children !== "undefined"
      //           ? parent.children.push(child)
      //           : (parent.children = [child])
      //       }
      //     })
      //   })
      //   return parents
      // },
      selectNode(data) {
        console.log('data', data)
        this.currentRegionCode = data[0].regionCode
        this.getClassroomDataFunc()
      },
      nodeContext(data) {
        console.log(data)
      },
      getClassroomDataFunc() {
        this.$api.getClassroomData('160', this.currentRegionCode).then(res => {
          console.log('res', res)
          this.classRoomList = res.data.data
          console.log(this.classRoomList)
        })
      }
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
    &::-webkit-scrollbar {
      width: 3px;
    }
    &::-webkit-scrollbar-thumb {
      background: #d8d8d8;
      border-radius: 10px;
    }
    &::-webkit-scrollbar-track-piece {
      background: transparent;
    }
  }
  .content {
    display: flex;
    justify-content: flex-start;
    padding: 10px 10px 10px 20px;
    flex-wrap: wrap;
    height: calc(100vh - 100px);
    overflow: auto;
  }
  .content-item {
    flex: 0 0 23%;
    height: 175px;
    margin-left: 20px;
    margin-top: 20px;
  }
  .card-container {
    display: flex;
  }
  .title-con {
    justify-content: space-between;
    display: flex;
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
  @font-face {font-family: "iconfont";
    src: url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.eot?t=1591014838214'); /* IE9 */
    src: url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.eot?t=1591014838214#iefix') format('embedded-opentype'), /* IE6-IE8 */
    url('data:application/x-font-woff2;charset=utf-8;base64,d09GMgABAAAAAAXUAAsAAAAACuwAAAWHAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHEIGVgCDHAqJKIdNATYCJAMQCwoABCAFhG0HSBs/CRFVpJmR/Shwd3K+lRvnzcu6X49LsRxk8HTaz1uk27dF4lK84mBtjgyKIxDch5mt6VhDVpgI1SVrWX76/zbf7vylKeM8TqMUCg0WRQIEEPz/+82KWITTxW6j0YvJ+x/VJqaREEmweV1IZhbK8lbqcpuB7ArWbeUXjwcCgMIPMSAlZTUtEMDBWY0AIONGjxwMoWQF18MiEAyylm05P7IBPARmJfMEwPr498k3SCICwIBn4azbMKJ0GAo+9/08m5UcEvqFBCincwOQdgJYADEAOICMavUOAZvqYmJE27I5pAEQXDcDTDXL//NshyNVHQUJvA9gqP95RAYHubDUFD17xpS+GBjgc39FG5bNqq4A4sJtBABagKwHyIdwcJ94MREsBF9K2UCOvQei9lTK5S4u/v5+TTMtlhbJ2grpaCikg6K4+rA32X/cP4zd3maz9aOrTISIkAxtdN+h9IJdBzr7iK1qUGLWtZkPhdE9BzStRg0o0dpsfQgOYLW2WiwTRNC2PtGtrm2RLa2mbgS/MJnI77KV3bEEcBcsAGSYW29rJ3i47fZoM9ETfvv11VfBGTUXrb4WSx9Wf2jVATB7jmDry9Vv/55jc+V0z8XstJYq7tuD2V22DulKiHzfNS+293q4Yu9VtMhXGSSjqFht1ptylkZh/vMm9VzSmvaoiaFbQ1bv1XTHWKyhRqPZbNIS06nk20O7mNR0i91n2yW6jPmgZ3eCxaoxribc+Fabfai5V6s17VNTAzKI7gDuQ1q6YR2WdaOqZ0pzV/fQg+gyM0xqQ5cGxr060exdDYPhNJtWH2artCRT0hj39w77bgZ1VrbRqGNOT2V6epipjY368uCZnvs7PLXvaSO0T3nPDrMwsyy4UY8GdmpPz6DvIvgZMmWRUjZCLK2RL1fG744nMzM8I6qbkvftycqbkhSaMXI8xRTQ8RmjQoon52WdKfStmoJyZuiSJUOJKw3XJUNRXj1lyk8jI0Y++7Si4rKHnrDmEVdq7nmnIthKzPuT58vLGgv9dXi+f2RLImmbNrUP08awLtKWWD7HnqBC0t5GipyCi3/b7woocanwUqDSxcyL9+lEitrbNN9tcrrCVqg2jT3s5VTa0Ork3It8VhojVVc7ZXtUVenH6KurhFQaLCh/7J2yYcmGENpAQ+J5UrzH7c2i76nfo2Hkqfqp8yDxa9/VvLsh2vBE8+RR6rPZBYs9MhA5aTFI/4m9q0OrQvu93/Thw/wBw6D//XF8fML7ows2e0Qgc9JmkNqJvXN7CUWE+nXJZNk78ccUL64MF+kyETGYmXfSoGM74oaUDNjQ5H5R+Lih2JTjXxBa8i+zd0Qn6Zy+l3ypfCsNXypccYO4BLoQum1xZh3enO3utu2bKh/699+/P/b16WTGQId6C7UZi7dRV4WXwlX5Z9rb8q/2XQDGj0NurH6chkkAAEcv+5IdDjiWMc/Y+YBD4may0kt9OSyTLUoY6J7zmyA+1UNv/6M9F6swDK9XJax8YbdxMwCH45my2rFxnK70sRl4Azigz4nwamkDRQEONqj0nQLXGMUAIdDkwHDiCyxBCJGjxgBPlAIygnygou12FqmwIbIzgCgPBgi5JzDcXAeW3IvIUT/A0/qDjLwhUH1y9ikKK1+sGJVgAvoOeUyN8RyySEr3mHaV4qI65p2R2zwEgetXUztskKfYoL2koYgBw1TDljkZVhWBZSowFjcTsZHnmbYncmOqewvFGFIESgDtDuRipGHCwWJR+/k9lOpUFO7paUieIdbK5w4CLh8g7lAD9dxKdesiFRIuagAjFZMa2HJuVLlxAmz7UgUUE66MImpFPK6fQZG7PF7fwhMAKGchLoawhCM8+P+f3EyWgrU97Zt0jLOSmlRyRb0eAA==') format('woff2'),
    url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.woff?t=1591014838214') format('woff'),
    url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.ttf?t=1591014838214') format('truetype'), /* chrome, firefox, opera, Safari, Android, iOS 4.2+ */
    url('//at.alicdn.com/t/font_1856307_k3n6r8aao3f.svg?t=1591014838214#iconfont') format('svg'); /* iOS 4.1- */
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
  }




</style>

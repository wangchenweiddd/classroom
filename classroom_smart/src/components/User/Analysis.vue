<template>
    <div>
      <h2 style="margin-bottom: 20px">信息统计</h2>
      <div style="display: flex;flex-direction: row;justify-content: center">
        <div id="building" style="width: 600px;height:400px;"></div>
        <div id="air" style="width: 600px;height:400px;"></div>
      </div>
    </div>
</template>

<script>
    export default {
      data() {
        return {
          test: 123456
        }
      },
      mounted() {
        this.getAnalysis()
        this.getbuild()
        this.getair()
      },
      methods: {
        getbuild() {
          // 基于准备好的dom，初始化echarts实例
          var myChart = this.$echarts.init(document.getElementById("building"));
          // 指定图表的配置项和数据
          myChart.setOption({
            itemStyle: {
              emphasis: {
                shadowBlur: 200,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            },
            title: {
              text: "建筑空调用时图(小时)",
              x: 'center',
              y: 'top'
            },
            series: [
              {
                type: "pie",
                radius: "40%",
                label: {
                  normal: {
                    formatter: "{b}:{c}({d}%)",
                    textStyle: {
                      fontWeight: "normal",
                      fontSize: 15
                    }
                  }
                },
                data: [
                  { value: 5413340, name: "博北A楼" },
                  // { value: this.test, name: "博北A楼" },
                  { value: 6470304, name: "博北B单" },
                  { value: 7397922, name: "博北B双" },
                  { value: 4235661, name: "博北C楼" },
                  { value: 2142251, name: "博南A楼" },
                  { value: 4722307, name: "博南B楼" },
                  { value: 2643846, name: "博南C楼" },
                  { value: 4388451, name: "博南D楼" }
                ]
              }
            ]
          });
        },
        getair() {
          var myChart = this.$echarts.init(document.getElementById("air"));
          // 指定图表的配置项和数据
          myChart.setOption({
            itemStyle: {
              emphasis: {
                shadowBlur: 200,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            },
            tooltip: {
              //提示框，可以在全局也可以在
              trigger: "item", //提示框的样式
              // formatter: "开机：100 <br/>{b}: {c} ({d}%)",
              formatter (params) {
                var index = params.dataIndex
                var res = ''
                if (index === 0) {
                  res = "总数：52<br>运行：0<br>关机：1<br>离线：51"
                } else if (index === 1) {
                  res = "总数：96<br>运行：0<br>关机：96<br>离线：0"
                } else if (index === 2) {
                  res = "总数：96<br>运行：1<br>关机：95<br>离线：0"
                } else if (index === 3) {
                  res += "总数：48<br>运行：0<br>关机：17<br>离线：31"
                } else if (index === 4) {
                  res += "总数：36<br>运行：1<br>关机：14<br>离线：21"
                } else if (index === 5) {
                  res += "总数：73<br>运行：0<br>关机：26<br>离线：47"
                } else if (index === 6) {
                  res += "总数：73<br>运行：0<br>关机：3<br>离线：70"
                } else if (index === 7) {
                  res += "总数：68<br>运行：0<br>关机：27<br>离线：41"
                }
                return res
              }
            },
            title: {
              text: "空调状态图",
              x: 'center',
              y: 'top'
            },
            series: [
              {
                type: "pie",
                radius: ["30%","40%"],
                label: {
                  normal: {
                    formatter: "{b}",
                    textStyle: {
                      fontWeight: "normal",
                      fontSize: 15
                    }
                  }
                },
                data: [
                  { value: 52, name: "博北A楼" },
                  { value: 96, name: "博北B单" },
                  { value: 96, name: "博北B双" },
                  { value: 48, name: "博北C楼" },
                  { value: 36, name: "博南A楼" },
                  { value: 73, name: "博南B楼" },
                  { value: 73, name: "博南C楼" },
                  { value: 68, name: "博南D楼" }
                ]
              }
            ]
          });
        },
        getAnalysis() {
          this.$api.getAnalysis().then(res => {
            console.log('res',res)
          })
        }
      }
    }
</script>

<style scoped>

</style>

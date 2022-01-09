<style lang="stylus" scoped>
.list-container
  position absolute
  top 60px
  bottom 0
  left 0
  right 0
  background #f1f1f1
  padding 11px
  .title
    height 30px
    line-height 30px
    margin-left 20px
    font-size 17px
    margin-bottom 11px
  .list
    background #ffffff
    padding 11px
    border-radius 5px
    position absolute
    left 10px
    bottom 10px
    right 10px
    top 10px
</style>
<template>
  <div class="list-container" ref="table">
    <div class="list" v-if="currentNav === '首页'">
      <Home></Home>
    </div>
    <div class="list" v-if="currentNav === '人员识别'">
      <DiscPeople></DiscPeople>
    </div>
    <div class="list" v-if="currentNav === '教室信息'">
      <HomePage></HomePage>
    </div>
    <div class="list" v-if="currentNav === '空调展示'">
      <AirPage></AirPage>
    </div>
    <div class="list" v-if="currentNav === '日志管理'">
      <DailyRecord></DailyRecord>
    </div>
    <div class="list" v-if="currentNav === '信息统计'">
      <Analysis></Analysis>
    </div>
    <div class="list" v-if="currentNav === '电源控制'">
      <PduPage></PduPage>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapMutations } from "vuex";
import Home from './Home'
import HomePage from './HomePage.vue'
import AirPage from "./AirPage.vue"
import PduPage from "./pduPage.vue"
import DailyRecord from "./DailyRecord"
import Analysis from './Analysis'
import DiscPeople from "./DiscPeople";
export default {
  components: {
    Home,
    HomePage,
    AirPage,
    PduPage,
    DailyRecord,
    Analysis,
    DiscPeople
  },
  computed: {
    ...mapGetters(["currentNav"])
  },
  methods: {

    ...mapMutations({
      setCurrentNav: "SET_CURRENTNAV"
    })
  }
};
</script>

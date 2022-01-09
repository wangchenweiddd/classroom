<style lang="stylus" scoped>
  .header-container
    position: absolute
    top 0
    bottom 0
    left 0
    right 0
    height 60px
    background #545c64
    display flex

    .logo
      flex 0 0 330px
      height 60px
      line-height 60px
      font-size 22px
      text-align center
      color #ffffff

    .menu
      flex 1

    .info
      display flex
      flex 0 0 220px
      color #ffffff
      height 60px
      line-height 60px
      cursor pointer

      .doc
        flex 0 0 100px
        font-size 14px
        transition all .2s

        &:hover
          color #409EFF

      .user
        flex 1
</style>
<template>
  <div class="header-container">
    <div class="logo">
      <span>智慧教室管控系统</span>
<!--      <span>人脸教室管控系统</span>-->
    </div>
    <div class="menu">
      <el-menu :default-active="currentNav"
               class="el-menu-demo" mode="horizontal"
               @select="handleSelect"
               background-color="#545c64"
               text-color="#fff"
               active-text-color="#409EFF">
        <el-menu-item index="首页">首页</el-menu-item>
        <el-menu-item index="教室信息">教室信息</el-menu-item>
        <el-menu-item index="人员识别">人员识别</el-menu-item>
        <el-submenu index="空调控制">
          <template slot="title">空调控制</template>
          <el-menu-item index="空调展示">空调展示</el-menu-item>
          <el-menu-item index="日志管理">日志管理</el-menu-item>
          <el-menu-item index="信息统计">信息统计</el-menu-item>
        </el-submenu>
        <el-menu-item index="电源控制">电源控制</el-menu-item>
      </el-menu>
    </div>
    <div class="info">
      <span class="doc">
        <i style="marginRight:5px" class="el-icon-document"></i>技术文档</span>
      <div class="user">
        <el-dropdown>
        <span style="color:#ffffff; fontSize:14px" class="el-dropdown-link">
          管理员<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="quit">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>
<script>
  import {mapGetters, mapMutations} from 'vuex'

  export default {
    data() {
      return {}
    },
    computed: {
      ...mapGetters([
        'currentNav'
      ])
    },
    methods: {
      handleSelect(e) {
        this.setCurrentNav(e)
      },
      ...mapMutations({
        setCurrentNav: 'SET_CURRENTNAV'
      }),
      quit() {
        this.$router.push('/')
      }
    }
  }
</script>

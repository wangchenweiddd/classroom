<style lang="stylus" rel="stylesheet/stylus" scoped>
  .container
    background-image: url('../assets/images/timg.jpeg');
    background-size: cover;
    height: 100%;
    position: absolute;
    width: 100%;
    animation: frams 3s infinite;
    .logo
      position relative
      .logoImg
        position absolute
        bottom -10px
        left 36%
        width 130px
        height 130px
      .logoImgInside
        position absolute
        bottom 12px
        left 44%
        width 100px
        height 100px
    .register
      position absolute
      width 500px
      left 50%
      top 50%
      margin-left -250px
      margin-top -350px
      border-radius 5px
      padding 20px 20px 20px 10px
      background #f8f8f9
    .login
      position absolute
      width 500px
      height 350px
      left 80%
      top 50%
      margin-left -250px
      margin-top -180px
      //border 1px solid #848484
      //border-radius 2px
      background: hsla(0,0%,100%,.25) border-box
      border-radius: 5px
      .title
        text-align center
        margin-bottom 15px
        font-size 34px
        margin-top 25px
      .loginType
        width 450px
        justify-content flex-end
        height 45px
        line-height 45px
        display flex
        color #666
        cursor pointer
        font-size 12px
        .loginItem
          margin-left 5px
        .active
          font-size 16px
          color rgb(112, 236, 87)
      .input
        text-align center
        .input-con
          //background-color black
          text-align left
          color black
          border-radius 10px
          border 1px solid #848484
          font-size 20px
          width 300px
          height 40px
          text-indent 10px
      .tip
        width 450px
        text-align right
        height 50px
        line-height 50px
        cursor pointer
        color black
        opacity .8
        &:hover
          opacity 1
      .s-footer
        margin-top 50px
        display flex
        width 500px
        justify-content space-around
        .s-button
          background hsla(0,0%,100%,.50) border-box
          //background #f8f8f9
          //border 1px solid #f8f8f9
          border-radius 10px
          color black
          height 50px
          line-height 50px
          width 150px
          text-align center
          font-size 26px
          padding 0 22px
          white-space normal
          cursor pointer
  //@keyframes frams
  //  0%
  //    background-image: url('../assets/images/timg.jpeg')
  //  100%
  //    background-image: url('../assets/images/ahu.png')
</style>
<template>
  <div class="container">
    <div class="login" v-if="!register">
      <div class="logo">
<!--        <img class="logoImg" src="../assets/images/ahu.png" alt=""/>-->
<!--        <img class="logoImgInside" src="../assets/images/ahu.png" alt=""/>-->
      </div>
      <div class="title">智慧教室管控系统</div>
      <div class="input">
        <input style="margin-bottom:20px" type="text" v-model="userId" class="input-con" placeholder="请输入账号"/>
        <input type="password" v-model="password" class="input-con" placeholder="请输入密码"/>
      </div>
<!--      <div class="tip">-->
<!--        <span>使用手册</span>-->
<!--        <i class="el-icon-document-copy"></i>-->
<!--      </div>-->
      <div class="s-footer">
        <div class="s-button" @click="login">登录</div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      register: false,
      loginType: 'user',
      userId:' ',
      password: ''
    }
  },
  methods: {
    changeLoginType (type) {
      this.loginType = type
    },
    login() {
      const loadingMsg = this.$Message.loading({
        content: '登录中...',
        duration: 1000
      })
      let data = {
        name: this.userId,
        password: this.password,
      }
      this.$api.userLogin(data).then(res => {
        console.log(res)
        if (res.data.status === 0) {
          this.$Message.destroy(loadingMsg)
          this.$router.push('/home')
        } else {
          this.$Message.destroy(loadingMsg)
          this.$Message.error(res.data.msg)
        }
      })
      // this.$api.userLogin(this.userId, this.password).then(res => {
      //   consoel.log(res)
      // })
      // this.$router.push('/home')
    }
  }
}
</script>

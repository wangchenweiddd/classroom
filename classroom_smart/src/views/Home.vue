<style lang="stylus" scoped>
  .container
    position absolute
    top 0
    bottom 0
    right 0
    left 0
</style>
<template>
  <div class='container'>
    <Header></Header>
    <HomeList></HomeList>
  </div>
</template>
<script>
import Header from '../components/User/Header'
import HomeList from '../components/User/HomeList'
export default {
  components: {
    Header,
    HomeList
  },
  data () {
    return {}
  },
  methods: {}
}
</script>

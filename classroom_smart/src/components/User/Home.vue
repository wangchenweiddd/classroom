<template>
  <div style="display: flex ; flex-direction: row">
      <img :src="img1" style="width: 50%" height="650px">
      <img :src="img2" style="width: 50%">
  </div>
</template>

<script>
    import IMG1 from '../../../public/qwe.png'
    import IMG2 from '../../../public/asd.png'
    export default {
        name: "Home",
      data() {
          return {
            img1: IMG1,
            img2: IMG2
          }
      }
    }
</script>

<style scoped>

</style>

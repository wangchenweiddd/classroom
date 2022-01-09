<template>
<div>
  <div>
    <Form ref="formInline" :model="formInline" :label-width="80" inline>
      <FormItem label="时间：">
        <Input v-model="formInline.time" ></Input>
      </FormItem>
      <FormItem label="区域：">
        <Input v-model="formInline.area" ></Input>
      </FormItem>
      <FormItem label="楼层：">
        <Input v-model="formInline.floor" ></Input>
      </FormItem>
      <FormItem label="教室：">
        <Input v-model="formInline.classroom" ></Input>
      </FormItem>
      <FormItem>
        <Button type="primary" size="large" @click="handleSubmit('formInline')">查询</Button>
      </FormItem>
    </Form>
  </div>
  <div>
    <Table size="large" border :columns="columns" :data="data"></Table>
  </div>
  <div style="display: flex;flex-direction: row;justify-content: flex-end;margin-top: 10px">
    <Button type="primary" size="large">导出</Button>
  </div>
</div>
</template>

<script>
export default {
name: "DiscPeople",
  data() {
    return {
      formInline: {
        time: '',
        area: '',
        floor: '',
        classroom: ''
      },
      columns: [
        {
          title: '姓名',
          key: 'name',
          align:"center",
        },
        {
          title: '学号',
          key: 'number',
          align:"center"
        },
        {
          title: '时间',
          key: 'creatTime',
          align:"center"
        },
        {
          title: '抓取图片',
          key: 'catchPhoto',
          align:"center",
          render: (h, params) => {
            console.log(params.row)
            return h('div', [
              h('img', {
                attrs: {
                  src: params.row.catchPhoto
                },
                style: {
                  width: '40px',
                  height: '40px'
                }
              }),
            ]);
          }
        },
        {
          title: '登记图片',
          key: 'registerPhoto',
          align:"center",
          render: (h, params) => {
            console.log(params.row)
            return h('div', [
              h('img', {
                attrs: {
                  src: params.row.registerPhoto
                },
                style: {
                  width: '40px',
                  height: '40px'
                }
              }),
            ]);
          }
        },
      ],
      data: [
        {
          name: '吕玲玲',
          number: 'Q19301207',
          creatTime: '2021/1/4 09:21:52',
          catchPhoto: require('../../assets/images/1zhua.png'),
          registerPhoto: require('../../assets/images/1den.png')
        },
        {
          name: '王仆',
          number: 'Q19301225',
          creatTime: '2021/1/4 09:21:53',
          catchPhoto: require('../../assets/images/2zhua.png'),
          registerPhoto: require('../../assets/images/2den.png')
        },
        {
          name: '方贤勇',
          number: 'Q19301248',
          creatTime: '2021/1/4 09:21:54',
          catchPhoto: require('../../assets/images/3zhua.png'),
          registerPhoto: require('../../assets/images/3den.png')
        },
        {
          name: '陈效',
          number: 'Q19301249',
          creatTime: '2021/1/4 09:21:55',
          catchPhoto: require('../../assets/images/4zhua.png'),
          registerPhoto: require('../../assets/images/4den.png')
        },
      ],
    }
  },
  methods: {
    handleSubmit() {}
  }
}
</script>

<style scoped>

</style>

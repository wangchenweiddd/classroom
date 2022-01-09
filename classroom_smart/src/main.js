import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import iView from 'iview'
import VCharts from 'v-charts'
import 'iview/dist/styles/iview.css'
import api from './http/index'
import echarts from 'echarts'

Vue.use(iView)
Vue.use(ElementUI)
Vue.use(api)
Vue.use(VCharts)

Vue.config.productionTip = false
Vue.prototype.$echarts = echarts

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

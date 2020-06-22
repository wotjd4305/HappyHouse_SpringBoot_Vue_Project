import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from "./store";

require('@/assets/bootstrap2/vendor/mdi-font/css/material-design-iconic-font.min.css')
require('@/assets/bootstrap2/vendor/font-awesome-4.7/css/font-awesome.min.css')
require('@/assets/bootstrap2/vendor/select2/select2.min.css')
require('@/assets/bootstrap2/vendor/datepicker/daterangepicker.css')
require('@/assets/bootstrap2/css/main.css')

Vue.config.productionTip = false

import VueSession from 'vue-session'

var sessionOptions = {
  persist: true
}
Vue.use(VueSession, sessionOptions)


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

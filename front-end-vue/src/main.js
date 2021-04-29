import VueSweetalert2 from 'vue-sweetalert2';
import Vuelidate from 'vuelidate';
import Vue from 'vue';
import App from './App.vue';
import router from './router';

Vue.config.productionTip = false;
Vue.use(VueSweetalert2);
Vue.use(Vuelidate);

new Vue({
  router,
  render: (h) => h(App),
}).$mount('#app');

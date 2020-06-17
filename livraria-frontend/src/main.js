import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import "bootstrap-vue/dist/bootstrap-vue.css";
import "bootstrap/dist/css/bootstrap.css";
import Vue from "vue";
import App from "./App.vue";
import router from "./router";

Vue.use(BootstrapVue);

Vue.use(IconsPlugin);

Vue.config.productionTip = false;

Vue.prototype.$eventHub = new Vue();

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");

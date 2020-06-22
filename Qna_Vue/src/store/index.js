import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)


export default new Vuex.Store({
  state: {
    logged: false,
    id :""
  },
  mutations: {
    login(state, id){
      state.logged = true,
      state.id = id 
    },
    logout(state){
      state.logged = false
    }

  }
});

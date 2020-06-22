import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import QnaList from '@/components/Qna/QnaList.vue'
import QnaWrite from '@/components/Qna/QnaWrite.vue'
import QnaRead from '@/components/Qna/QnaRead.vue'
import QnaModify from '@/components/Qna/QnaModify.vue'

import Dummy from '@/components/Dummy.vue'

import MemberModify from '@/components/member/MemberModify'
import MemberDelete from '@/components/member/MemberDelete'
import MemberSearch from '@/components/member/MemberSearch'


import MemberLogin from '@/components/member/MemberLogin'
import MemberFindPass from '@/components/member/MemberFindPass'
import MemberJoin from '@/components/member/MemberJoin'


import HouseDealSearch from '@/components/house/HouseDealSearch'
import HouseDealDetail from '@/components/house/HouseDealDetail'

import Result from '@/components/error/error'

Vue.use(VueRouter)
export default new VueRouter({
  mode: "history",
  routes:[
    {
      path: '/',
      name: 'Dummy',
      component: Dummy
    },
    {
      path: '/dummy',
      name: 'Dummy',
      component: Dummy
    },
    
    {
      path: '/memberModify',
      name: 'MemberModify',
      component: MemberModify
    },
    {
      path: '/memberDelete',
      name: 'MemberDelete',
      component: MemberDelete

    },
    {
      path: '/memberSearch',
      name: 'MemberSearch',
      component: MemberSearch
    },
    {
      path: '/houseDealSearch',
      name: 'HouseDealSearch',
      component: HouseDealSearch
    },
    {
      path: '/houseDealDetail/:no',
      name: 'HouseDealDetail',
      component: HouseDealDetail
    },
    {
      path: '/memberLogin',
      name: 'MemberLogin',
      component: MemberLogin
    },
    {
      path: '/memberJoin',
      name: 'MemberJoin',
      component: MemberJoin
    },
    {
      path: '/memberFindPass',
      name: 'MemberFindPass',
      component: MemberFindPass
    },
    {
      path: '/result',
      name: 'Result',
      component: Result
    },

    {
      path: '/qnalist',
      name: 'qnaList',
      component: QnaList
    },
    {
      path: '/qnawrite',
      name: 'QnaWrite',
      component: QnaWrite
    },
    {
      path: '/qnaread/:no',
      name: 'QnaRead',
      component: QnaRead
    },
    {
      path: '/qnamodify/:no',
      name: 'QnaModify',
      component: QnaModify
    },
    {
      path: '/about',
      name: 'About',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
]
});


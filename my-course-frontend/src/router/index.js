import { createRouter, createWebHistory } from 'vue-router'
import Login from '@/views/Login.vue'
import Home from '@/views/Home.vue'
import Layout from '@/components/Layout.vue'

const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/',
    component: Layout,
    children: [
      {
        path: '/home',
        component: Home
      }
      // 后续可以加更多子路由
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router

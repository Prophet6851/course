import { createRouter, createWebHistory } from 'vue-router'
import Login from '@/views/Login.vue'
import Home from '@/views/Home.vue'
import Layout from '@/components/Layout.vue'
import CourseList from '@/views/CourseList.vue'

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
  },
  {
    path: '/',
    component: Layout,
    children: [
      {
        path: '/home',
        component: Home
      },
      {
        path: '/courses', // ⬅️ 新增课程管理页
        component: CourseList
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  if (!token && to.path !== '/login') {
    next('/login')
  } else if (token && to.path === '/login') {
    next('/home')
  } else {
    next()
    }
  })

export default router

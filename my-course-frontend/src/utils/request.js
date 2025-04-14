// src/utils/request.js
import axios from 'axios'

const service = axios.create({
  baseURL: '/api', // 和 Vite 的 proxy 保持一致
  timeout: 5000
})

// 请求拦截器：在每次请求前附加 token
service.interceptors.request.use(config => {
  const token = localStorage.getItem('token')
  if (token) {
    config.headers.Authorization = `Bearer ${token}`
    console.log("✅ 当前登录 token:", token)
  } else {
    console.log("❌ 未找到 token")
  }
  return config
}, error => {
  return Promise.reject(error)
})

// 响应拦截器：可选
service.interceptors.response.use(
  res => res,
  error => {
    console.error('❌ 请求失败:', error)
    return Promise.reject(error)
  }
)

export default service

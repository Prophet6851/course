<template>
  <div class="home-wrapper">
    <el-card class="welcome-card">
      <h2>🎓 欢迎进入课程管理系统首页</h2>
      <p>您可以在这里管理课程、学生信息、成绩等模块。</p>
      <el-button type="danger" @click="logout">退出登录</el-button>
    </el-card>
  </div>
</template>

<script setup>
import router from '@/router'

const logout = () => {
  localStorage.removeItem('token')
  router.push('/login')
}
</script>

<style scoped>
.home-wrapper {
  height: 100vh;
  background: linear-gradient(to right, #fbc2eb, #a6c1ee);
  display: flex;
  justify-content: center;
  align-items: center;
}
.welcome-card {
  width: 500px;
  text-align: center;
  padding: 30px;
  background: #ffffffee;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
}
.welcome-card h2 {
  margin-bottom: 10px;
  font-size: 24px;
  color: #333;
}
</style>

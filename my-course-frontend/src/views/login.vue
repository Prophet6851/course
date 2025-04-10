<template>
  <div class="login-wrapper">
    <div class="login-box">
      <h2 class="title">课程管理系统登录</h2>
      <el-form :model="form" :rules="rules" ref="formRef" label-width="80px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入密码" type="password" show-password />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleLogin" class="login-btn" size="large">登 录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { ElMessage } from 'element-plus'
import router from '@/router'

const form = ref({
  username: '',
  password: ''
})
const formRef = ref()
const rules = {
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
}

const handleLogin = async () => {
  await formRef.value.validate()
  try {
    const res = await axios.post('http://localhost:8080/api/users/login', form.value)
    if (res.data.code === 200) {
      localStorage.setItem('token', res.data.token)
      ElMessage.success('登录成功')
      router.push('/home')
    } else {
      ElMessage.error(res.data.msg || '登录失败')
    }
  } catch (err) {
    ElMessage.error('服务器异常')
  }
}
</script>

<style scoped>
.login-wrapper {
  height: 100vh;
  background: linear-gradient(to right, #74ebd5, #acb6e5);
  display: flex;
  justify-content: center;
  align-items: center;
}
.login-box {
  width: 400px;
  padding: 40px;
  border-radius: 10px;
  background: #ffffffdd;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.title {
  text-align: center;
  margin-bottom: 30px;
  font-size: 22px;
  color: #333;
}
.login-btn {
  width: 100%;
}
</style>

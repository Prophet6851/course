<template>
  <el-container style="height: 100vh">
    <!-- 顶部导航栏 -->
    <el-header class="layout-header">
      <div class="title">课程管理系统</div>
      <el-button type="danger" @click="logout">退出登录</el-button>
    </el-header>

    <el-container>
      <!-- 左侧菜单栏 -->
      <el-aside width="200px" class="layout-aside">
        <el-menu
          router
          :default-active="$route.path"
          class="el-menu-vertical-demo"
          background-color="#ffffff"
          text-color="#333"
          active-text-color="#409eff"
        >
          <el-menu-item index="/home">
            <span>🏠 首页</span>
          </el-menu-item>
          <el-menu-item index="/courses">
            <span>📚 课程管理</span>
          </el-menu-item>
          <el-menu-item index="/students">
            <span>👨‍🎓 学生管理</span>
          </el-menu-item>
          <el-menu-item index="/scores">
            <span>📈 成绩统计</span>
          </el-menu-item>
        </el-menu>
      </el-aside>

      <!-- 页面内容区域 -->
      <el-main class="layout-main">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const logout = () => {
  localStorage.removeItem('token')
  router.push('/login')
}
</script>

<style scoped>
.layout-header {
  background-color: #409eff;
  color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 30px;
  font-size: 18px;
  font-family: "Segoe UI", "PingFang SC", "Microsoft YaHei", sans-serif;
}

.layout-aside {
  background-color: #ffffff;
  border-right: 1px solid #e0e0e0;
  font-family: "Segoe UI", "PingFang SC", "Microsoft YaHei", sans-serif;
}

.layout-main {
  padding: 20px;
  background-color: #f5f7fa;
  font-family: "Segoe UI", "PingFang SC", "Microsoft YaHei", sans-serif;
}

.el-menu {
  border-right: none;
}

.el-menu-item {
  font-size: 16px;
  color: #333;
  padding-left: 20px !important;
  transition: all 0.2s ease;
  font-weight: 500;
}

.el-menu-item:hover {
  background-color: #f0f2f5 !important;
  color: #409eff !important;
  border-right: 3px solid #409eff;
}
</style>

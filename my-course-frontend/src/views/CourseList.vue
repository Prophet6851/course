<template>
  <div class="course-list">
    <el-card shadow="never" header="📚 课程信息列表">
      <el-table :data="courses" style="width: 100%" border>
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="课程名称" />
        <el-table-column prop="teacher" label="授课老师" />
        <el-table-column prop="credit" label="学分" />
        <el-table-column prop="description" label="课程描述" />
      </el-table>
    </el-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const courses = ref([])

onMounted(async () => {
  const token = localStorage.getItem('token')
  console.log('当前登录 token:', token)  // ✅ 打印 token 到控制台
  try {
    const token = localStorage.getItem('token')
    const res = await axios.get('/api/courses', {
      headers: {
        Authorization: `Bearer ${token}`
      }
    })
    console.log('后端返回数据:', res.data)
    courses.value = Array.isArray(res.data) ? res.data : []
  } catch (error) {
    console.error('获取课程数据失败:', error)
  }
})
</script>



<style scoped>
.course-list {
  padding: 20px;
}
</style>

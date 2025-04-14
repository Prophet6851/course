<template>
  <div class="course-list">
    <el-card shadow="never" header="📚 课程信息列表">
      <el-button type="primary" @click="dialogVisible = true">➕ 添加课程</el-button>

      <el-table :data="courses" style="width: 100%" border>
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="课程名称" />
        <el-table-column prop="teacher" label="授课老师" />
        <el-table-column prop="credit" label="学分" />
        <el-table-column prop="description" label="课程描述" />
      </el-table>
    </el-card>

    <!-- 添加课程对话框 -->
    <el-dialog v-model="dialogVisible" title="新增课程" width="500px">
      <el-form :model="newCourse" label-width="100px">
        <el-form-item label="课程名称">
          <el-input v-model="newCourse.name" />
        </el-form-item>
        <el-form-item label="授课老师">
          <el-input v-model="newCourse.teacher" />
        </el-form-item>
        <el-form-item label="学分">
          <el-input v-model="newCourse.credit" type="number" />
        </el-form-item>
        <el-form-item label="课程描述">
          <el-input type="textarea" v-model="newCourse.description" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitCourse">提交</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import request from '@/utils/request'

const courses = ref([])
const dialogVisible = ref(false)
const newCourse = ref({
  name: '',
  teacher: '',
  credit: 0,
  description: ''
})

const fetchCourses = async () => {
  try {
    const res = await request.get('/courses')
    courses.value = res.data
  } catch (err) {
    console.error('❌ 获取课程失败:', err)
  }
}

onMounted(() => {
  fetchCourses()
})

const submitCourse = async () => {
  try {
    await request.post('/courses', newCourse.value)
    dialogVisible.value = false
    await fetchCourses()
  } catch (err) {
    console.error('❌ 添加课程失败:', err)
  }
}
</script>

<style scoped>
.course-list {
  padding: 20px;
}
</style>



<style scoped>
.course-list {
  padding: 20px;
}
</style>

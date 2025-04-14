# 🎓 Course Management System（课程管理系统）

这是一个使用 **Spring Boot + MyBatis + JWT + Vue 3 + Element Plus** 构建的前后端分离的课程管理系统。
---

## ✨ 已完成功能

### ✅ 后端功能（Spring Boot + MyBatis）

- [x] 用户注册与登录（基于 JWT 的认证）
- [x] 登录状态校验过滤器（`JwtAuthenticationFilter`）
- [x] 课程信息展示
- [x] 课程新增功能（POST）
- [x] 权限控制：注册/登录放行，其余接口需登录

### ✅ 前端功能（Vue 3 + Element Plus）

- [x] 登录页面（token 登录）
- [x] 主页面（Layout布局 + 菜单）
- [x] 课程管理页（课程表格 + 添加课程弹窗）
- [x] Axios 请求封装，自动附带 token
- [x] 登录拦截器 + 路由守卫

---

## 🛠 技术栈

| 技术       | 描述                         |
|------------|------------------------------|
| Spring Boot | 后端框架                     |
| MyBatis     | 数据持久层 ORM 框架          |
| Vue 3       | 前端框架                     |
| Element Plus| Vue 3 UI 组件库             |
| Axios       | HTTP 客户端（请求封装）      |
| JWT         | JSON Web Token 用户认证机制  |
| Vite        | Vue3 的构建工具              |
| MySQL       | 数据库                       |

---

## 🚀 启动方式

### 🔹 后端启动

1. 配置 MySQL 数据库（记得建表）
2. 执行 `CourseApplication.java`
3. 浏览器访问：`http://localhost:8080`

### 🔹 前端启动

```bash
cd my-course-frontend
npm install
npm run dev
访问：http://localhost:5173


🔒 默认拦截说明
✅ /api/users/login、/api/users/register 不拦截

❌ /api/courses 等接口需附带 Bearer token，否则 401

📷 示例截图
登录界面	课程页面
✅ 登录成功后跳转主页面	✅ 支持新增课程，课程列表展示
🧩 TODO 待办项
 编辑 / 删除课程功能

 分页查询

 用户权限角色区分

 成绩管理模块

 前端样式美化

📄 作者
项目作者：@Prophet6851

如有建议或问题欢迎提 issue 😄

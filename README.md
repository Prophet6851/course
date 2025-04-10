# 🎓 课程管理系统（Course Management System）

## 📘 项目简介

本项目为一套基于 **Spring Boot + Vue 3** 的前后端分离课程管理系统，包含用户注册、登录、权限验证与基础页面布局，适合用于教学后台、课程安排管理等系统场景。

---

## 🧰 技术栈

### 🔧 后端（Java + Spring Boot）

- Spring Boot 3.2.x
- Spring Security
- MyBatis
- MySQL 8+
- JWT（JSON Web Token）

### 💻 前端（Vue 3 + Element Plus）

- Vue 3（基于 Vite 构建）
- Element Plus（UI 组件库）
- Vue Router（前端路由管理）
- Axios（HTTP 请求）

---

## ✅ 已完成功能

- [x] 用户注册（数据库持久化）
- [x] 用户登录（JWT 认证返回 token）
- [x] Spring Security 登录鉴权保护接口
- [x] 前后端分离架构搭建
- [x] 顶部导航栏 + 侧边栏页面布局（美化）
- [x] 登录成功后跳转首页 + token 存储校验

### 🚀 项目结构

```# 项目结构
course/
├── my-course-frontend/      # 前端 Vue 3 项目目录
│   ├── src/
│   │   ├── views/           # 登录、首页等页面
│   │   ├── components/      # 公共组件（如 Layout）
│   │   └── router/          # 路由配置
│   └── package.json
│
├── src/                     # 后端 Java 源码
│   ├── controller/          # 控制器接口层
│   ├── entity/              # 实体类
│   ├── mapper/              # MyBatis 接口
│   ├── service/             # 业务逻辑实现
│   └── util/                # JWT 工具类等
│
├── resources/
│   └── application.properties
└── pom.xml

📌 TODO（下一阶段目标）
 课程信息管理（增删改查）

 表格数据展示（分页 + 搜索）

 用户信息管理模块

 登录角色权限动态菜单

 前端 token 自动刷新 + 路由拦截


# Course 在线课程管理系统

本项目为一套在线课程管理系统，采用前后端分离架构，适合校园类信息系统建设和学习型项目开发实践。系统以 Vue3 + Element Plus 为前端框架，后端使用 Spring Boot、MyBatis 与 MySQL 进行开发。

## 项目技术栈

### 前端

- Vue 3
- Element Plus
- Axios

### 后端

- Spring Boot 3.x
- MyBatis
- MySQL
- JWT（计划集成）

## 当前进度

- [x] 后端项目结构搭建
- [x] 本地 MySQL 数据库连接配置
- [x] Git 仓库初始化并上传至 GitHub
- [ ] 用户注册与登录模块开发
- [ ] JWT 鉴权与接口保护
- [ ] 教师讲座上传与管理功能
- [ ] 投票模块与评论模块设计
- [ ] 管理员后台功能设计

## 快速启动（后端）

1. 确保已创建名为 `course_db` 的本地 MySQL 数据库
2. 修改 `application.properties` 中的数据库连接信息
3. 使用 IDEA 或命令行运行 `CourseApplication.java`
4. 默认端口：8080

## 说明

本项目为学习和实验用途开发，欢迎基于本项目继续拓展模块，提升系统完整性。
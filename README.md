Spring AI + MCP 智能图书管理系统
基于 Spring AI、MCP 协议和 H2 数据库的实战项目，实现自然语言驱动的图书 CRUD 操作，展示 MCP 如何让传统系统快速具备 AI 对话能力。
项目简介
本项目通过 Spring AI 整合 MCP（Model Context Protocol）协议，将图书管理的数据库操作（查询 / 新增等）自动暴露为 AI 可调用的工具。用户只需输入自然语言（如 “查询张三写的编程书”），AI 会自动解析需求、调用对应方法并返回结果，无需手动开发接口适配层。
核心功能
自然语言交互：支持用日常语言完成图书查询、新增等操作
MCP 自动工具暴露：通过 @Tool 注解自动将服务方法转为 AI 可调用工具
内置 H2 数据库：无需额外配置，启动即运行，支持控制台可视化管理
零接口开发：AI 直接与业务逻辑交互，跳过传统 “前端→后端接口” 流程
环境要求
JDK 17+
Maven 3.8+
有效 Anthropic API Key（获取地址）
快速开始
1. 获取代码
bash
# 克隆或下载项目后解压
cd spring-ai-mcp-db-demo
2. 配置 AI 密钥
修改 src/main/resources/application.properties，替换 Anthropic API Key：
properties
spring.ai.anthropic.api-key=你的Anthropic密钥
3. 启动项目
bash
mvn spring-boot:run
服务将在 http://localhost:8080 启动，自动初始化 4 条测试图书数据。
4. 访问数据库控制台（可选）
打开浏览器访问：http://localhost:8080/h2-console
JDBC URL：jdbc:h2:mem:testdb
用户名：sa，密码：password
可查看 / 修改图书数据。
使用示例
通过 POST 请求调用对话接口，输入自然语言指令：
示例 1：查询图书
bash
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: text/plain" \
  -d "查询2023年出版的架构类图书"
响应：
plaintext
2023年出版的架构类图书有：
1. 《微服务架构设计》（作者：李四，2023-05-20出版）
示例 2：新增图书
bash
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: text/plain" \
  -d "新增一本《Spring AI实战》，作者王五，分类编程，2024年6月1日出版"

响应：
plaintext
已成功新增图书：
《Spring AI实战》（作者：王五，分类：编程，2024-06-01出版，ID：5）

项目结构
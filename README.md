# BrainStorming
**BrainStorming**译为头脑风暴，旨在通过每个人的独特想法，构筑出一个有价值的项目。

以开源的方式生产，遵循的生产许可证（开源协议）是 MIT License。

滴水成河，虽然我们现在力量微薄，但我们可以尽自己的努力推动 BrainStorming 项目。

有代码就该同享，有Bug必然同当。

欢迎大家通过PR和Issues，参与到BrainStorming项目中来。

BrainStorming by **everybody**.

If there is any intention to participate, please Pull Requests and Issues.

---

### 项目架构

| 依赖       | 版本          |
| ---------- | ------------- |
| JDK        | 8             |
| Maven      | 3.6.1         |
| SpringBoot | 2.3.4.RELEASE |

### 模块介绍

| 模块名       | 模块功能      |
| ------------ | ------------- |
| api-shorturl | 公共接口模块 |

### 公共接口列表

| 接口功能   | 接口地址                        | 请求方式 | 请求示例                                      | 接口描述 |
| ---------- | ------------------------------- | -------- | --------------------------------------------- | -------- |
| 短网址生成 | https://www.jxinx.tech/api/shorturl | GET/POST | https://www.jxinx.tech/api/shorturl/www.baidu.com | 将长网址缩短，支持t.cn,dwz.mk,suo.im等短网址生成 |
| 垃圾分类查询 | https://www.jxinx.tech/api/garbage | GET/POST | https://www.jxinx.tech/api/garbage/西瓜 | 通过关键字搜索物品属于哪种垃圾 |


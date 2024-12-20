# 图小姐——基于AIGC的图片云协同平台


## 项目简介
### 项目背景
随着人工智能技术的不断发展，越来越多的人开始关注图片的生成和管理。传统的图片管理方式往往需要人工干预，效率低下且容易出错。而基于AIGC的图片管理新方式，可以通过AI技术自动生成图片，提高效率和准确性。
### 项目目标
本项目的目标是开发一个基于AIGC的图片云协同平台，提供以下功能：

- [ ] 基于AIGC技术自动生成图片
- [ ] 图片分类和管理
- [ ] 图片搜索和推荐
- [ ] 图片分享和交流
- [ ] 图片收藏和标签
- [ ] 图片下载和分享
- [ ] 图片导出和导入
- [ ] 图片编辑和协同
以上功能都未开发，后续会陆续开发。请大家不要期待。

### 技术选型
本项目使用主流开发技术
- Java 17
- SpringBoot
- MybatisPlus
- Python 3（待支持）
- Flask（待支持）

使用中间件 
- MySQL
- Redis
- Nginx
- Elasticsearch
- RabbitMQ

待完成
- [ ] 如果系统图片频繁更新，设置一个手动更新缓存的功能 
- [ ] 对热点图片进行手动识别热点，设置一个自动更新的功能
- [ ] 对所有业务的缓存写一个通用的类，进行优化统一管理CacheManager
- [ ] 文件秒传实现，查询数据库的md5的值，如果没有则上传，如果有则直接返回
- [ ] 图片上传两次功能改成一次

# spring boot
---
集成 Mybatis，通用Mapper，PageHelp分页插件， war包独立部署，Swagger2 API

# 开发建议
---

- 表名，建议使用小写，多个单词使用下划线拼接。 如：sys_user
- 不是表中字段的属性必须加 @Transient 注解，建议使用dto
- 开发规范建议遵循阿里巴巴java开发手册
- 公司内部使用Swagger2来编写，管理api文档
- 需要工具类的话建议先从 hutool 工具类中找，尽量精简项目
- 日志，使用 private static final Log log = LogFactory.get(); 定义
- 字段验证：直接调用Validator.isXXX(String value)既可验证字段，返回是否通过验证。如：Validator.isChinese("字段验证器");


# 技术选型 & 文档
---

- [Spring Boot学习&使用指南](https://blog.csdn.net/NorRinInTheSky)
- [MyBatis官方文档](http://www.mybatis.org/mybatis-3/zh/index.html)
- [MyBatisb通用Mapper插件](https://mapperhelper.github.io/docs/)
- [MyBatis PageHelper分页插件](https://pagehelper.github.io/)
- [Fastjson](https://github.com/alibaba/fastjson/wiki/Quick-Start-CN)
- [spring-boot-starter-dao](https://github.com/halober/spring-boot-starter-dao)
- [spring-boot-starter-swagger](https://github.com/halober/spring-boot-starter-swagger)
- [Hutool工具类参考文档](http://hutool.mydoc.io/)
- 其他略
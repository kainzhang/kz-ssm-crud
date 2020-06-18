# SSM 实训：家政服务平台

基于 SpringBoot 的 SSM(Spring + SpringMVC + MyBatis) 实训项目


## 特别声明

**如果你是我的同学并且也在写这个实训，劝你善良。代码都是公开的，参考下载什么的当然没问题，但是直接复制走用来完成你自己的作业，那就很无耻了。希望你至少把注释和命名方式改改，或多或少添点删点也行，再说文件创建时间也不可能跟我同步到分吧？本来也不是什么高端代码，功能也就简单CRUD，说实话没一点技术含量，稍微学一学参考参考就会。我也是第一次接触SSM，有写错的、不合理的也请你们指教，希望能多交流，谢谢。**

## Database 创建及使用

+ 在数据库中导入根目录下的 `jz_crud.sql` 文件
+ 修改 `/src/main/resources/application.properties` 的数据库相关配置信息

## Swagger 使用

项目已经嵌入 Swagger 用于测试后端接口，启动项目后通过 Url `http://localhost:8888/swagger-ui.html#/` 访问。


## Mybatis-Generator 逆向工程

当前实体类及DAO类已全部生成，如需使用，修改 /src/main/resources/generatorConfig.xml 文件内 classPathEntry 及 jdbcConnection 的相关配置信息，或者在 /src/main/resources 添加配置文件 db.properties，并配置如下内容

``` text db.properties
jdbc.driverLocation=<驱动本地地址>
jdbc.driverClass=<驱动类>
jdbc.url=<连接地址>
jdbc.user=<用户名>
jdbc.password=<密码>
```
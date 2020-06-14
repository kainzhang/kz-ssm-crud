# SSM 实训：家政服务平台

基于 SpringBoot 的 SSM(Spring + SpringMVC + MyBatis) 实训项目


## Database 创建及使用

+ 导入根目录下的 `jz_crud.sql` 文件
+ 修改 `/src/main/resources/application.properties` 的数据库相关配置信息

## Mybatis-Generator 逆向工程

当前实体已生成完毕，如需使用，修改 `/src/main/resources/generatorConfig.xml` 文件内 classPathEntry 及 jdbcConnection 的相关配置信息，或者在 `/src/main/resources` 添加配置文件 `db.properties`，并配置如下内容

``` text db.properties
jdbc.driverLocation=<驱动本地地址>
jdbc.driverClass=<驱动类>
jdbc.url=<连接地址>
jdbc.user=<用户名>
jdbc.password=<密码>
```
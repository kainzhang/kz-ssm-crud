# SSM 实训：家政服务平台

基于 SpringBoot 的 SSM(Spring + SpringMVC + MyBatis) 实训项目


## Database 创建及使用

+ 导入根目录下的 `jz_crud.sql` 文件
+ 修改 `/src/main/resources/application.properties` 的数据库相关配置信息

## Mybatis-Generator 逆向工程

已经生成完毕，如需使用，修改 `/src/main/resources/generatorConfig.xml` 文件内 classPathEntry 及 jdbcConnection 的相关配置信息，或者在 `/src/main/resources` 添加配置文件，并配置如下内容

``` text db.properties
jdbc.driverLocation=
jdbc.driverClass=
jdbc.url=
jdbc.user=
jdbc.password=
```
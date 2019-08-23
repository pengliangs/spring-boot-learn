[官方文档](https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/production-ready-enabling.html)

# 什么是 actuator

官网摘要

```text
Spring Boot includes a number of additional features to help you monitor and manage your application when you push it to production. You can choose to manage and monitor your application by using HTTP endpoints or with JMX. Auditing, health, and metrics gathering can also be automatically applied to your application.
```
Spring Boot包含许多其他功能，可帮助您在将应用程序推送到生产环境时监视和管理应用程序。您可以选择使用HTTP端点或JMX来管理和监视应用程序。审核，运行状况和指标收集也可以自动应用于您的应用程序。

# actuator 可以做什么

actuator 提供了一系列 rest api 帮助我们获取系统运行时情况，如 监控检查，运行配置信息，地址映射等

# 怎么使用 actuator

[官方文档](https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/production-ready-enabling.html)

**1. 引入依赖**

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
</dependencies>
```
启动应用,actuator默认映射路径 `/actuator`

```yaml
#修改默认
management:
  endpoints:
    web:
      base-path: /
```

**2.使用下面暴露端点访问**

[官方文档](https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/production-ready-endpoints.html)

|ID	|描述|默认启用|
|:---|:---|:---|
|auditevents|	显示当前应用程序的审计事件信息	|Yes|
|beans	|显示一个应用中所有Spring Beans的完整列表|	Yes|
|conditions|	显示配置类和自动配置类(configuration and auto-configuration classes)的状态及它们被应用或未被应用的原因	|Yes|
|configprops	|显示一个所有@ConfigurationProperties的集合列表|	Yes|
|env|	显示来自Spring的 ConfigurableEnvironment的属性	|Yes|
|flyway	|显示数据库迁移路径，如果有的话|	Yes|
|health	|显示应用的健康信息（当使用一个未认证连接访问时显示一个简单的’status’，使用认证连接访问则显示全部信息详情）|	Yes|
|info	|显示任意的应用信息|	Yes|
|liquibase|	展示任何Liquibase数据库迁移路径，如果有的话	|Yes|
|metrics|	展示当前应用的metrics信息|	Yes|
|mappings	|显示一个所有@RequestMapping路径的集合列表	|Yes|
|scheduledtasks	|显示应用程序中的计划任务|	Yes|
|sessions	|允许从Spring会话支持的会话存储中检索和删除(retrieval and deletion)用户会话。使用Spring Session对反应性Web应用程序的支持时不可用。|	Yes|
|shutdown	|允许应用以优雅的方式关闭（默认情况下不启用）|	No|
|threaddump	|执行一个线程dump	|Yes|

如果您的应用程序是Web应用程序（Spring MVC，Spring WebFlux或Jersey），则可以使用以下附加端点：

|ID	|描述|默认启用|
|:---|:---|:---|
|heapdump	|返回一个GZip压缩的hprof堆dump文件|	Yes|
|jolokia	|通过HTTP暴露JMX beans（当Jolokia在类路径上时，WebFlux不可用）|	Yes|
|logfile	|返回日志文件内容（如果设置了logging.file或logging.path属性的话），支持使用HTTP Range头接收日志文件内容的部分信息|	Yes|
|prometheus	|以可以被Prometheus服务器抓取的格式显示metrics信息|	Yes|

**启用端点**

默认情况下，shutdown启用除除以外的所有端点。要配置端点的启用，请使用其`management.endpoint.<id>.enabled`属性。以下示例启用shutdown端点：
```yaml
management:
  endpoint:
    shutdown:
      enabled: true
```

通过 `management.endpoints.enabled-by-default` 来修改全局端点默认配置,以下示例启用info端点并禁用所有其他端点：

```yaml
management.endpoints.enabled-by-default: false
management.endpoint.info.enabled: true
```

[参考文章](https://blog.csdn.net/alinyua/article/details/80009435#1-%E5%BC%80%E5%90%AFactuator)
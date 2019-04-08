# d.furty.cn短网址服务


```
config: 
- application.properties
- /resources/static/config.js

You need to set your mysql url, username and password
```



```
run：
- mvn clean package
- cd target
- java -jar dwz-1.0.jar

浏览器访问 http://127.0.0.1:8082 (更改为在配置文件里配置的端口号)
```

```
sql:
新建数据库: dwz
执行dwz.sql文件
```


您可以直接访问 [d.furty.cn](http://d.furty.cn)

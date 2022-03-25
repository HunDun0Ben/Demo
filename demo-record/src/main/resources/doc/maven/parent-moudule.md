##父子 Maven 工程模块。
在父模块声明对应的子模块， 
在父模块中预先声明 dependencyManagement, pluginManagement

1. install 失败， 找不到对应的父包。
```text
[ERROR] [ERROR] Some problems were encountered while processing the POMs:
[FATAL] Non-resolvable parent POM for org.example:demo-facade:0.0.1-SNAPSHOT: Could not find artifact com.example:demo:pom:0.0.1-SNAPSHOT and 'parent.relativePath' points at no local POM @ line 7, column 13
 @ 
```
Cause By:
子模块下 <parent> 节点下的 <relativePath>，详情可以查看该节点描述
```xml
    <!-- 不填写的默认值，代表从本地路径中获取 parent 的 pom.xml -->
    <relativePath>../pom.xml</relativePath>
    
```
```xml
    <!-- 路径为空，相当于从本地仓库或远程仓库获取对应 parent -->
    <relativePath/>
```
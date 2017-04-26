# logs
 
注解已经充分测试
___
新增基于注解的配置


##项目说明:
1. demonApp和demonAppByAnnotation,demonRemoteApp三个是      独立的项目,都可以单独部署,其中demonApp是基于xml配置的,demonAppByAnnotation是基于注解的,而demonRemoteApp只作为发布dubbo远程服务
2. 部署前请自行开启相关的服务,包括zk,kafka,redis,mysql等
3. [查看地址](https://github.com/rensuperk/ssmdemon),[下载](https://github.com/rensuperk/ssmdemon/archive/master.zip)

## 功能
1.  这是一个spring+springmvc+mybaties的样板代码
2.  这是一个基于xml配置的项目
3.  这是一个maven管理的项目
4.  这是一个应用了企业业务分层的项目
5.  写这个项目的时候用了测试驱动的方法,感觉确实快了很多,正确性也能够有保证
6.  使用了logback做项目sl4g项目的整合
7. 使用了c3p0和druid数据库连接池
8. 能够切换数据库
9. 使用redis缓存,已经引入了
10. 使用dubbo治理远程服务SOA+zk进行任务调度
11. 使用shiro进行安全访问(没实现,配置在另外一个分支)
12. 前端用jsp(先用这个吧,还没开始写)
13. 基于注解的事务
14. 使用hibernate-validator进行参数验证
15. 根据环境切换配置文件
16. 新增kafka消息队列,新增书籍信息加入消息队列中
17. 新增基于注解的配置方式





#### 大概就这些功能,想到了继续添加,详情看代码
 
安装ubuntu 安装的是乌班图ubuntu-16.10-desktop-amd64.iso
安装mysql 5.7 创建库分配权限
安装zookeeper 配置和开启
安装kafka配置和启动
安装redis配置和启动
大多使用wget去官网下载压缩包,地址自行搜索
 ```
 cd /app/
 tar -zxvf 下载的包
 mv 解压的包名 zookeeper
 cd zookeeper
 cp conf/zoo_template.cfg conf/zoo.cfg
 vi cong/cfg 

配置像这样的 
tickTime=2000
initLimit=10
syncLimit=5
dataDir=/app/zookeeper/data
dataLogDir=/app/zookeeper/logs
clientPort=2181
server.1=192.168.42.129:2888:3888 #本地域名:与leader交换信息的端口:重新选举的端口


#配置环境变量
vi /etc/profile

export ZOOKEEPER_INSTALL=/app/zookeeper
export PATH=$PATH:$ZOOKEEPER_INSTALL/bin

#启动
bin/zkServer.sh start
#查看服务
bin/zkCli.sh -server 192.168.42.129:2181
 ```
 
 
 在数据库中执行
 ```
 
 修改mysql的配置
 
 打开mysql配置文件vi /etc/mysql/mysql.conf.d/mysqld.cnf
将bind-address = 127.0.0.1注销



 CREATE TABLE book
     (
         ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
         NAME VARCHAR(200),
         PRICE DOUBLE,
         BORROW_FLAG INT(11)
     );
     
     CREATE TABLE book_record
     (
         ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
         USER_ID BIGINT(20) NOT NULL,
         BOOK_ID BIGINT(20) NOT NULL,
         BORROW_TIME DATETIME NOT NULL COMMENT '借书时间
     ',
         BACK_TIME DATETIME COMMENT '归还日期
     '
     );
     
     CREATE TABLE user
     (
         ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
         NAME VARCHAR(20),
         SEX CHAR(1),
         PASSWORD VARCHAR(40),
         BIRTHDAY DATETIME
     );
 ```
 安装kafka
  ```
  过程略了,反正就装个单机的简单
  kafka的监控就不装了,实际需要的时候再说
  ```
 安装redis
 ```
apt-get install redis
```
启动略
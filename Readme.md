   ## 我的奋斗,从readme开始
   1. ### 这是一个spring+springmvc+mybaties的样板代码
   2. ### 这是一个基于xml配置的项目
   3. ### 这是一个maven管理的项目
   4. ### 这是一个应用了企业业务分层的项目
   5. ### 写这个项目的时候用了测试驱动的方法,感觉确实快了很多,正确性也能够有保证
   6. ### 使用了logback做项目sl4g项目的整合
   7. ### 使用了c3p0和druid数据库连接池
   8. ### 能够切换数据库(没实现) 
   9. ### 使用redis缓存(没实现)
   10. ### 使用dubbo治理远程服务SOA+zk进行任务调度(没实现)
   11. ### 使用shiro进行安全访问(没实现)
   12. ### 前端用jsp(先用这个吧,还没开始写)
   13. ### 基于注解的事务
   14. ### 使用hibernate-validator进行参数验证
   15. ### 根据环境切换配置文件

   ## 大概就这些,详情看代码
 
 
   #### 数据库代码
 
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
 
 

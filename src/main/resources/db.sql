# 建立项目数据库表

#Module  one   权限模块[RBAC设计模式去设计表，非常灵活，扩展性好]
#airsys_user 
#airsys_role 
#airsys_resource
create table if not exists account(
   id int primary  key auto_increment,
   
)
create table if not exists user(
  id int primary key auto_increment,
  name varchar(30) not null,
  age integer
);
insert into user(name.age) values('zhangsan',18);
insert into user(name,age) values('lisi',19);
insert into user(name,age) values('wangwu',19);
insert into user(name,age) values('zhaoliu',19);
insert into user(name,age) values('shunqi',19);


#Module  two   人资模块[没有统一的标准，就是根据实际情况设计表] 考勤管理 车辆管理 办公用品管理  

#....
#....

# 例子模块



#Module  three   行政模块
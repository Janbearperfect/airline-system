<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="util.*,entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/airsys3/assets/css/main.css">

<title>列出账号</title>
<style >
ul{
margin-left:500px;
}
ul li{
float:left;
margin-left:10px;
}

</style>
</head>
<body>
      <h3 align="center">账号信息</h3>
      <hr color="red">
      <center>
          <table border="1">
             <tr>
                 <th>ID</th>
                 <th>账号名</th>
                 <th>余额</th>
                 <th>操作</th>
             </tr>
             <c:forEach items="${acts}" var="act">
		             <tr>
		                 <td>${act.id}</td>
		                 <td>${act.name}</td>
		                 <td>${act.balance}</td>
		                 <td>
		                     <a href="user/${act.id} ">查看</a>
		                     <a href="#" onclick="updateUser(${act.id})">修改</a>
		                     <a href="#">删除</a>
		                 </td>
		             </tr>
             </c:forEach>
          </table>
        
          <span>总页数:${pager.total}，每页 5 条数据</span>
      </center>
      <script type="text/javascript" src="/airsys3/assets/js/user.js"></script>
      <!-- Spring MVC会造成文件路径找不到
      原因是dispatcher拦截 "/" 让Spring MVC不要拦截形如.js .css .jpg .png等静态资源
      怎么做呢？
            修改AppConfig类配置
       git:如何利用git开发项目，管理项目
            版本控制文件，只能监控文本文件（word image video 二进制文件）
         Git：GitHub   
         airsys
            .gitignore:用于配置你要忽略的文件
            .git
            .classpath
            .setting
            .target
            src
            pom.xml
            ReadMe.md
         
       -->
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
		
        <script language="javascript">
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form method="post" action="<%=path %>/userEdit.action" name="formPw">
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
				<tr bgcolor="#EEF4EA">
				    <td colspan="2" background="<%=path %>/img/wbg.gif" class='title'><span>个人信息</span></td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				         帐号：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="text" value="${sessionScope.user.userName }" name="userName" size="20" disabled="disabled"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        密码：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="password" name="userPw" value="${sessionScope.user.userPw }"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        姓名：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="text" name="userRealname" value="${sessionScope.user.userRealname }"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        住址：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="text" name="userAddress" value="${sessionScope.user.userAddress }"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        性别：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="radio" name="userSex" value="男" checked="checked"/>男
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="userSex" value="女"/>女
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        电话：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="text" name="userTel" value="${sessionScope.user.userTel }"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        &nbsp;
				    </td>
			        <td width="75%" bgcolor="#FFFFFF">
			             <input type="hidden" name="userId" value="${sessionScope.user.userId }"/>
			             <input type="submit" value="修改"/>
			        </td>
				</tr>
			</table>
			</form>
   </body>
</html>

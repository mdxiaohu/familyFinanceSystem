<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
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
        <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script> 
        <script language="javascript">
            function c()
            {
                if(document.formPw.shijian.value=="")
                {
                    alert("请输入时间");
                    return false;
                }
                
                if(document.formPw.jine.value=="")
                {
                    alert("请金额");
                    return false;
                }
                
                document.formPw.submit();
            }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
			<form method="post" action="<%=path %>/xiaofeiAdd.action" name="formPw">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/images/wbg.gif" class='title'><span>消费信息管理</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         时间：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input name="shijian" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" class="Wdate" readonly="readonly" type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
				            </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         金额：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="text" value="0.0" name="jine" size="22" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"/>
				            </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         成员：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="radio" name="chengyuan" value="本人" checked="checked" style="border: 0px;"/>本人&nbsp;&nbsp;&nbsp;&nbsp;
					           <input type="radio" name="chengyuan" value="配偶" style="border: 0px;"/>配偶&nbsp;&nbsp;&nbsp;&nbsp;
					           <input type="radio" name="chengyuan" value="爸爸" style="border: 0px;"/>爸爸&nbsp;&nbsp;&nbsp;&nbsp;
					           <input type="radio" name="chengyuan" value="妈妈" style="border: 0px;"/>妈妈&nbsp;&nbsp;&nbsp;&nbsp;
					           <input type="radio" name="chengyuan" value="子女" style="border: 0px;"/>子女&nbsp;&nbsp;&nbsp;&nbsp;
				            </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        类型：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="text" name="leixing" size="22"/>
				            </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        备注：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <textarea rows="4" cols="30" name="beizhu"></textarea>
				            </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="button" value="提交" onclick="c()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>

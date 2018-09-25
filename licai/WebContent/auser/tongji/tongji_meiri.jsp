<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="com.model.TShouru"/>
<jsp:directive.page import="com.model.TXiaofei"/>
<jsp:directive.page import="org.jfree.data.general.DefaultPieDataset"/>
<jsp:directive.page import="org.jfree.chart.JFreeChart"/>
<jsp:directive.page import="org.jfree.chart.ChartFactory"/>
<jsp:directive.page import="org.jfree.chart.title.TextTitle"/>
<jsp:directive.page import="org.jfree.chart.plot.PiePlot"/>
<jsp:directive.page import="java.awt.Font"/>
<jsp:directive.page import="org.jfree.chart.labels.StandardPieSectionLabelGenerator"/>
<jsp:directive.page import="org.jfree.chart.title.LegendTitle"/>
<jsp:directive.page import="java.io.OutputStream"/>
<jsp:directive.page import="org.jfree.chart.ChartUtilities"/>
<jsp:directive.page import="java.io.FileOutputStream"/>
<jsp:directive.page import="java.text.NumberFormat"/>
<jsp:directive.page import="java.text.DecimalFormat"/>
<jsp:directive.page import="java.io.File"/>
<jsp:directive.page import="java.util.Date"/>

<%
    String path = request.getContextPath();
    
    List shouruList=(List)request.getAttribute("shouruList");
    List xiaofeiList=(List)request.getAttribute("xiaofeiList");
    String shijian=(String)request.getAttribute("shijian");
    double shouru_1=0;
    double xiaofei_1=0;
    
    for(int i=0;i<shouruList.size();i++)
    {
        TShouru shouru=(TShouru)shouruList.get(i);
        shouru_1=shouru_1+shouru.getJine();
    }
    
    for(int i=0;i<xiaofeiList.size();i++)
    {
        TXiaofei xiaofei=(TXiaofei)xiaofeiList.get(i);
        xiaofei_1=xiaofei_1+xiaofei.getJine();
    }
    
    

  
    DefaultPieDataset defaultPieDataset=new DefaultPieDataset();//数据集
	defaultPieDataset.setValue("收入",shouru_1);
	defaultPieDataset.setValue("消费",xiaofei_1);
	
	JFreeChart freeChart=ChartFactory.createPieChart("每日统计分析饼图", defaultPieDataset,true,false,false);
	//JFreeChart freeChart=ChartFactory.createPieChart3D("某公司的人员组织结构图", defaultPieDataset,true,true,false);
	//共5个参数
	//第一个图的标题
	//第二个数据集
	//第三个
	//第四个鼠标指上是否有提示信息
	//第五个是否有超链接

	
	
	//为了防止乱码才这样写的
	TextTitle title=freeChart.getTitle();
	title.setFont(new Font("宋体", Font.BOLD, 25));
	
	PiePlot plot=(PiePlot)freeChart.getPlot();
	plot.setLabelFont(new Font("宋体", Font.BOLD, 15));
       plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}({2})", NumberFormat.getNumberInstance(),new DecimalFormat("0.0%")));
	
	LegendTitle legendTitle=freeChart.getLegend();
	legendTitle.setItemFont(new Font("宋体", Font.BOLD, 15));
       //为了防止乱码才这样写的
	
	
	String tu_mingzi=String.valueOf(new Date().getTime())+".jpg";
	String url = request.getSession().getServletContext().getRealPath("tutu")+"\\"+tu_mingzi;
	
	OutputStream os=new FileOutputStream(url);
	ChartUtilities.writeChartAsJPEG(os, freeChart, 500, 500);
	os.close();
    
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
                document.formPw.submit();
            }
            
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="25" background="<%=path %>/images/tbg.gif">&nbsp;每日统计分析&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="5%">序号</td>
					<td width="10%">时间</td>
					<td width="10%">收入</td>
					<td width="10%">消费</td>
					<td width="10%">结余</td>
		        </tr>	
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						1
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<%=shijian %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <%=shouru_1 %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <%=xiaofei_1 %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <%=shouru_1-xiaofei_1 %>
					</td>
				</tr>
			</table>
			
			<form action="<%=path %>/tongji_meiri.action" name="formPw" method="post">
			    <table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top:8px">
			        <tr>
			            <td>
			                <input name="shijian" value="<%=shijian %>" class="Wdate" readonly="readonly" type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
			                <input type="button" value="统计" style="width: 80px;" onclick="c()" />
			            </td>
			        </tr>
			    </table>
			</form>
			
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top:8px">
		        <tr>
		            <td>
		                <%
		                   String url11="/licai/tutu/"+tu_mingzi;
		                %>
		                <img src="<%=url11 %>" width="300" height="300" border="0" />
		            </td>
		        </tr>
			</table>
	</body>
</html>

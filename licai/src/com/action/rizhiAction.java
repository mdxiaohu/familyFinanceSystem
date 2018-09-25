package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TRizhiDAO;
import com.model.TAdmin;
import com.model.TRizhi;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class rizhiAction extends ActionSupport
{
	private Integer id;
	private String title;
	private String content;
	private String shijian;

	private Integer userId;
	
	private String message;
	private String path;
	
	private TRizhiDAO rizhiDAO;
	
	public String rizhiAdd()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TRizhi rizhi=new TRizhi();
		
		rizhi.setTitle(title);
		rizhi.setContent(content);
		rizhi.setShijian(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		rizhi.setUserId(user.getUserId());
		
		rizhiDAO.save(rizhi);
		this.setMessage("Ìí¼ÓÍê±Ï");
		this.setPath("rizhiMana.action");
		return "succeed";
	}
	
	
	public String rizhiMana()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TRizhi where userId="+user.getUserId();
		List rizhiList =rizhiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("rizhiList", rizhiList);
		return ActionSupport.SUCCESS;
	}
	
	public String rizhiDel()
	{
		TRizhi rizhi=rizhiDAO.findById(id);
		rizhiDAO.delete(rizhi);
		this.setMessage("É¾³ýÍê±Ï");
		this.setPath("rizhiMana.action");
		return "succeed";
	}


	public String getContent()
	{
		return content;
	}


	public void setContent(String content)
	{
		this.content = content;
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getMessage()
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}


	public TRizhiDAO getRizhiDAO()
	{
		return rizhiDAO;
	}


	public void setRizhiDAO(TRizhiDAO rizhiDAO)
	{
		this.rizhiDAO = rizhiDAO;
	}


	public String getShijian()
	{
		return shijian;
	}


	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}


	public String getTitle()
	{
		return title;
	}


	public void setTitle(String title)
	{
		this.title = title;
	}


	public Integer getUserId()
	{
		return userId;
	}


	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	
}

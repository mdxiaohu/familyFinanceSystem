package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShouruDAO;
import com.dao.TTouziDAO;
import com.model.TShouru;
import com.model.TTouzi;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class touziAction extends ActionSupport
{
	private Integer id;
	private String xangmu;
	private Double benjin;
	private String kaishi;

	private String jiehsu;
	private Double shouyi;
	private Integer userId;
	
    private String message;
	private String path;
	
	private TTouziDAO touziDAO;
	
	
	public String touziAdd()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TTouzi touzi=new TTouzi();
		
		touzi.setXangmu(xangmu);
		touzi.setBenjin(benjin);
		touzi.setKaishi(kaishi);
		touzi.setJiehsu(jiehsu);
		
		touzi.setShouyi(shouyi);
		touzi.setUserId(user.getUserId());
		
		touziDAO.save(touzi);
		this.setMessage("操作成功");
		this.setPath("touziMana.action");
		return "succeed";
	}
	
	public String touziMana()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql ="from TTouzi where userId="+user.getUserId();
		List touziList=touziDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("touziList", touziList);
		return ActionSupport.SUCCESS;
	}
	
	public String touziDel()
	{
		TTouzi touzi=touziDAO.findById(id);
		touziDAO.delete(touzi);
		this.setMessage("操作成功");
		this.setPath("touziMana.action");
		return "succeed";
	}

	public Double getBenjin()
	{
		return benjin;
	}

	public void setBenjin(Double benjin)
	{
		this.benjin = benjin;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getJiehsu()
	{
		return jiehsu;
	}

	public void setJiehsu(String jiehsu)
	{
		this.jiehsu = jiehsu;
	}

	public String getKaishi()
	{
		return kaishi;
	}

	public void setKaishi(String kaishi)
	{
		this.kaishi = kaishi;
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

	public Double getShouyi()
	{
		return shouyi;
	}

	public void setShouyi(Double shouyi)
	{
		this.shouyi = shouyi;
	}

	public TTouziDAO getTouziDAO()
	{
		return touziDAO;
	}

	public void setTouziDAO(TTouziDAO touziDAO)
	{
		this.touziDAO = touziDAO;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getXangmu()
	{
		return xangmu;
	}

	public void setXangmu(String xangmu)
	{
		this.xangmu = xangmu;
	}
	
}

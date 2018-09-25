package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShouruDAO;
import com.dao.TXiaofeiDAO;
import com.model.TShouru;
import com.model.TUser;
import com.model.TXiaofei;
import com.opensymphony.xwork2.ActionSupport;

public class xiaofeiAction extends ActionSupport
{
	private Integer id;
	private String shijian;
	private Double jine;
	private String chengyuan;

	private String leixing;
	private String beizhu;
	private Integer userId;
	
    private String message;
	private String path;
	
	private TXiaofeiDAO xiaofeiDAO;
	
	
	public String xiaofeiAdd()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TXiaofei xiaofei=new TXiaofei();
		
		xiaofei.setShijian(shijian);
		xiaofei.setJine(jine);
		xiaofei.setChengyuan(chengyuan);
		xiaofei.setLeixing(leixing);
		
		xiaofei.setBeizhu(beizhu);
		xiaofei.setUserId(user.getUserId());
		
		xiaofeiDAO.save(xiaofei);
		this.setMessage("操作成功");
		this.setPath("xiaofeiMana.action");
		return "succeed";
	}
	
	public String xiaofeiMana()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql ="from TXiaofei where userId="+user.getUserId();
		List xiaofeiList=xiaofeiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xiaofeiList", xiaofeiList);
		return ActionSupport.SUCCESS;
	}
	
	public String xiaofeiDel()
	{
		TXiaofei xiaofei=xiaofeiDAO.findById(id);
		xiaofeiDAO.delete(xiaofei);
		this.setMessage("操作成功");
		this.setPath("xiaofeiMana.action");
		return "succeed";
	}

	public String getBeizhu()
	{
		return beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public String getChengyuan()
	{
		return chengyuan;
	}

	public void setChengyuan(String chengyuan)
	{
		this.chengyuan = chengyuan;
	}

	public TXiaofeiDAO getXiaofeiDAO()
	{
		return xiaofeiDAO;
	}

	public void setXiaofeiDAO(TXiaofeiDAO xiaofeiDAO)
	{
		this.xiaofeiDAO = xiaofeiDAO;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Double getJine()
	{
		return jine;
	}

	public void setJine(Double jine)
	{
		this.jine = jine;
	}

	public String getLeixing()
	{
		return leixing;
	}

	public void setLeixing(String leixing)
	{
		this.leixing = leixing;
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


	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
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

package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShouruDAO;
import com.model.TShouru;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class shouruAction extends ActionSupport
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
	
	private TShouruDAO shouruDAO;
	
	
	public String shouruAdd()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TShouru shouru=new TShouru();
		
		shouru.setShijian(shijian);
		shouru.setJine(jine);
		shouru.setChengyuan(chengyuan);
		shouru.setLeixing(leixing);
		
		shouru.setBeizhu(beizhu);
		shouru.setUserId(user.getUserId());
		
		shouruDAO.save(shouru);
		this.setMessage("操作成功");
		this.setPath("shouruMana.action");
		return "succeed";
	}
	
	public String shouruMana()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql ="from TShouru where userId="+user.getUserId();
		List shouruList=shouruDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shouruList", shouruList);
		return ActionSupport.SUCCESS;
	}
	
	public String shouruDel()
	{
		TShouru shouru=shouruDAO.findById(id);
		shouruDAO.delete(shouru);
		this.setMessage("操作成功");
		this.setPath("shouruMana.action");
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

	public TShouruDAO getShouruDAO()
	{
		return shouruDAO;
	}

	public void setShouruDAO(TShouruDAO shouruDAO)
	{
		this.shouruDAO = shouruDAO;
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

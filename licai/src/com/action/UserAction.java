package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
	private Integer userId;
	private String userRealname;
	private String userSex;
	private String userTel;
	
	private String userAddress;
	private String userName;
	private String userPw;
	private String userDel;
	
   
	
	
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	
	
	public String userReg()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from TUser where userName=?";
		Object[] c={userName.trim()};
		List list=userDAO.getHibernateTemplate().find(sql,c);
		if(list.size()>0)
		{
			request.setAttribute("msg", "用户名已被占用,请重新注册");
		}
		else
		{
			TUser user=new TUser();
			
			user.setUserRealname(userRealname);
			user.setUserSex(userSex);
			user.setUserTel(userTel);
			user.setUserAddress(userAddress);
			
			user.setUserName(userName.trim());
			user.setUserPw(userPw);
			user.setUserDel("no");
			
			userDAO.save(user);
			
			request.setAttribute("msg", "注册成功，请登录");
		}
		
		return "msg";
	}
	
	
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.getHibernateTemplate().update(user);
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	public String userMana()
	{
		List userList=userDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	public String userEdit()
	{
		TUser user=userDAO.findById(userId);
		
		user.setUserPw(userPw);
		user.setUserRealname(userRealname);
		user.setUserSex(userSex);
		user.setUserTel(userTel);
		user.setUserAddress(userAddress);
		
		
		user.setUserDel("no");
		
		userDAO.attachDirty(user);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "修改成功，重新登录后生效");
		return "msg";
	}

	public String userLogout()
	{
		Map session= ServletActionContext.getContext().getSession();
		session.remove("user");
		return ActionSupport.SUCCESS;
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


	public String getUserAddress()
	{
		return userAddress;
	}


	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}


	public TUserDAO getUserDAO()
	{
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public String getUserDel()
	{
		return userDel;
	}


	public void setUserDel(String userDel)
	{
		this.userDel = userDel;
	}


	public Integer getUserId()
	{
		return userId;
	}


	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}


	public String getUserName()
	{
		return userName;
	}


	public void setUserName(String userName)
	{
		this.userName = userName;
	}


	public String getUserPw()
	{
		return userPw;
	}


	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}


	public String getUserRealname()
	{
		return userRealname;
	}


	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}


	public String getUserSex()
	{
		return userSex;
	}


	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}


	public String getUserTel()
	{
		return userTel;
	}


	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}
	
}

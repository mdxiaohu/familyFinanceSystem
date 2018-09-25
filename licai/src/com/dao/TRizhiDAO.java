package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TRizhi;

/**
 * Data access object (DAO) for domain model class TRizhi.
 * 
 * @see com.model.TRizhi
 * @author MyEclipse Persistence Tools
 */

public class TRizhiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TRizhiDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TRizhi transientInstance)
	{
		log.debug("saving TRizhi instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TRizhi persistentInstance)
	{
		log.debug("deleting TRizhi instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TRizhi findById(java.lang.Integer id)
	{
		log.debug("getting TRizhi instance with id: " + id);
		try
		{
			TRizhi instance = (TRizhi) getHibernateTemplate().get(
					"com.model.TRizhi", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TRizhi instance)
	{
		log.debug("finding TRizhi instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TRizhi instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TRizhi as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TRizhi instances");
		try
		{
			String queryString = "from TRizhi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TRizhi merge(TRizhi detachedInstance)
	{
		log.debug("merging TRizhi instance");
		try
		{
			TRizhi result = (TRizhi) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TRizhi instance)
	{
		log.debug("attaching dirty TRizhi instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TRizhi instance)
	{
		log.debug("attaching clean TRizhi instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TRizhiDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TRizhiDAO) ctx.getBean("TRizhiDAO");
	}
}
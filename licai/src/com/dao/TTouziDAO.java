package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TTouzi;

/**
 * Data access object (DAO) for domain model class TTouzi.
 * 
 * @see com.model.TTouzi
 * @author MyEclipse Persistence Tools
 */

public class TTouziDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TTouziDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TTouzi transientInstance)
	{
		log.debug("saving TTouzi instance");
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

	public void delete(TTouzi persistentInstance)
	{
		log.debug("deleting TTouzi instance");
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

	public TTouzi findById(java.lang.Integer id)
	{
		log.debug("getting TTouzi instance with id: " + id);
		try
		{
			TTouzi instance = (TTouzi) getHibernateTemplate().get(
					"com.model.TTouzi", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TTouzi instance)
	{
		log.debug("finding TTouzi instance by example");
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
		log.debug("finding TTouzi instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TTouzi as model where model."
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
		log.debug("finding all TTouzi instances");
		try
		{
			String queryString = "from TTouzi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTouzi merge(TTouzi detachedInstance)
	{
		log.debug("merging TTouzi instance");
		try
		{
			TTouzi result = (TTouzi) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTouzi instance)
	{
		log.debug("attaching dirty TTouzi instance");
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

	public void attachClean(TTouzi instance)
	{
		log.debug("attaching clean TTouzi instance");
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

	public static TTouziDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TTouziDAO) ctx.getBean("TTouziDAO");
	}
}
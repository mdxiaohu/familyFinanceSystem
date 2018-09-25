package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShouru;

/**
 * Data access object (DAO) for domain model class TShouru.
 * 
 * @see com.model.TShouru
 * @author MyEclipse Persistence Tools
 */

public class TShouruDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TShouruDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TShouru transientInstance)
	{
		log.debug("saving TShouru instance");
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

	public void delete(TShouru persistentInstance)
	{
		log.debug("deleting TShouru instance");
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

	public TShouru findById(java.lang.Integer id)
	{
		log.debug("getting TShouru instance with id: " + id);
		try
		{
			TShouru instance = (TShouru) getHibernateTemplate().get(
					"com.model.TShouru", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShouru instance)
	{
		log.debug("finding TShouru instance by example");
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
		log.debug("finding TShouru instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TShouru as model where model."
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
		log.debug("finding all TShouru instances");
		try
		{
			String queryString = "from TShouru";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShouru merge(TShouru detachedInstance)
	{
		log.debug("merging TShouru instance");
		try
		{
			TShouru result = (TShouru) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShouru instance)
	{
		log.debug("attaching dirty TShouru instance");
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

	public void attachClean(TShouru instance)
	{
		log.debug("attaching clean TShouru instance");
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

	public static TShouruDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TShouruDAO) ctx.getBean("TShouruDAO");
	}
}
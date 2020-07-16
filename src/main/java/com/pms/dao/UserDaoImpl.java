package com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.pms.entity.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	
	@Autowired 
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Integer saveOrUpdate(User user) {
		Integer result=0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(user);
			result=1; 
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public User getUser(Integer id) {
		User user=null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			user = (User)session.get(User.class, id);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return user;
	}

	@Override
	public List<User> view() {
		List<User> results=new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> createQuery = cb.createQuery(User.class);
			Root<User> root = createQuery.from(User.class);
			createQuery.orderBy(cb.desc(root.get("id")));
			createQuery.select(root);
			 
			Query<User> query = session.createQuery(createQuery);
			results = query.getResultList();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return results;
	}

	@Override
	public Integer delete(Integer id) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			User user = (User)session.get(User.class, id);
			session.delete(user);
			beginTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public User getUserByProjectId(Integer projectId) {
		User user = null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Criteria crit = session.createCriteria(User.class);
			crit.add(Restrictions.eq("project.id", projectId));
			List<User> results = crit.list();
			if(!CollectionUtils.isEmpty(results)) {
				user = results.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}

}

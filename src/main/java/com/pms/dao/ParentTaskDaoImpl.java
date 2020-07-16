package com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.entity.ParentTask;

@Repository("parentTaskDao")
public class ParentTaskDaoImpl implements IParentTaskDao {

	@Autowired 
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Integer saveOrUpdate(ParentTask parentTask) {
		Integer result=0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(parentTask);
			beginTransaction.commit();
			result = parentTask.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public ParentTask getParentTask(Integer id) {
		ParentTask parentTask=null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			parentTask = (ParentTask)session.get(ParentTask.class, id);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return parentTask;
	}

	@Override
	public List<ParentTask> view() {
		List<ParentTask> results=new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<ParentTask> createQuery = cb.createQuery(ParentTask.class);
			Root<ParentTask> root = createQuery.from(ParentTask.class);
			createQuery.select(root);
			 
			Query<ParentTask> query = session.createQuery(createQuery);
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
			ParentTask parentTask = (ParentTask)session.get(ParentTask.class, id);
			session.delete(parentTask);
			beginTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}

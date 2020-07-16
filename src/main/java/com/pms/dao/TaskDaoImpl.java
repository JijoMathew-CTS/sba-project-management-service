package com.pms.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.entity.Task;

@Repository("taskDao")
public class TaskDaoImpl implements ITaskDao {

	@Autowired 
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Integer saveOrUpdate(Task task) {
		Integer result=0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(task);
			beginTransaction.commit();
			result = task.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Task getTask(Integer id) {
		Task task=null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			task = (Task)session.get(Task.class, id);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return task;
	}

	@Override
	public List<Task> view() {
		List<Task> results=new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Task> createQuery = cb.createQuery(Task.class);
			Root<Task> root = createQuery.from(Task.class);
			createQuery.orderBy(cb.desc(root.get("id")));
			createQuery.select(root);
			 
			Query<Task> query = session.createQuery(createQuery);
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
			Task task = (Task)session.get(Task.class, id);
			session.delete(task);
			beginTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Integer getCompletedTaskByProjectId(Integer projectId) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		int result = 0 ;
		Session session=null;
		try {
			session=sessionFactory.openSession();
			NativeQuery query = session.createNativeQuery("select count(task_id) from task  where project_id = :project_id and status=:status");
			BigInteger countValue = (BigInteger) query.setParameter("project_id", projectId).setParameter("status", 1).uniqueResult();
			if(countValue != null) {
				result = countValue.intValue();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}

	@Override
	public Integer getTotalTaskByProjectId(Integer projectId) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		int result = 0 ;
		Session session=null;
		try {
			session=sessionFactory.openSession();
			NativeQuery query = session.createNativeQuery("select count(task_id) from task  where project_id = :project_id ");
			BigInteger countValue = (BigInteger)query.setParameter("project_id", projectId).uniqueResult();
			if(countValue != null) {
				result = countValue.intValue();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}

}

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

import com.pms.entity.Project;

@Repository("projectDao")
public class ProjectDaoImpl implements IProjectDao{
	
	@Autowired 
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Integer saveOrUpadte(Project project) {
		Integer result=0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			 result = (Integer) session.save(project);
			 beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	}
	
	@Override
	public Project getProject(Integer id) {
		Project project=null;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			project = (Project)session.get(Project.class, id);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return project;
	}

	@Override
	public List<Project> view() {
		List<Project> results=new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Project> createQuery = cb.createQuery(Project.class);
			Root<Project> root = createQuery.from(Project.class);
			createQuery.select(root);
			 
			Query<Project> query = session.createQuery(createQuery);
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
			Project project = (Project)session.get(Project.class, id);
			session.delete(project);
			beginTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}

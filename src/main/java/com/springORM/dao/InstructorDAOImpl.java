package com.springORM.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springORM.entity.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {


	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<Instructor> findAllInstructor() {
	
		//open session--begin transaction--create query--commit transaction 
		Session session = sessionFactory.getCurrentSession();
		Query<Instructor> query = session.createQuery(" from Instructor", Instructor.class);
		List<Instructor> listInstructor = query.list();
		return listInstructor;
	}

	
	@Override
	public void saveInstructor(Instructor instructor) {
		Session session = sessionFactory.getCurrentSession();		
		session.save(instructor);	
	}


	@Override
	public Instructor findInstructorById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Instructor instructorById = session.get(Instructor.class, id);
		return instructorById;
	}


	@Override
	public List<Instructor> findInstructorByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		//List<Instructor> list = session.createNamedQuery("nameIs", Instructor.class).setParameter("string", "name%").list();
		return null;
	}


	@Override
	public void deleteInstructor(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Instructor instructor = session.get(Instructor.class, id);
		session.delete(instructor);
	}

}

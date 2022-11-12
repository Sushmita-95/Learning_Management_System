package com.springORM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springORM.dao.InstructorDAO;
import com.springORM.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO instructorDAO;
	
	@Override
	@Transactional
	public List<Instructor> findAllInstructor() {
		List<Instructor> listInstructor = instructorDAO.findAllInstructor();
		return listInstructor;
	}

	@Override
	@Transactional
	public void saveInstructor(Instructor instructor) {
	 instructorDAO.saveInstructor(instructor);
	}

	@Override
	@Transactional
	public Instructor findInstructorById(int id) {
		Instructor findInstructorById = instructorDAO.findInstructorById(id);
		return findInstructorById;
	}

	@Override
	@Transactional
	public List<Instructor> findInstructorByName(String name) {
		instructorDAO.findInstructorByName(name);
		return  null;
	}

	@Override
	@Transactional
	public void deleteInstructor(int id) {
		instructorDAO.deleteInstructor(id);
		
	}

	
}

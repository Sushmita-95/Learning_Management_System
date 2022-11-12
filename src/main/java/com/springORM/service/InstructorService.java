package com.springORM.service;

import java.util.List;

import com.springORM.entity.Instructor;

public interface InstructorService {

	public List<Instructor> findAllInstructor();

	public void saveInstructor(Instructor instructor);

	public Instructor findInstructorById(int id);

	public List<Instructor> findInstructorByName(String name);

	public void deleteInstructor(int id);

}

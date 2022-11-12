package com.springORM.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springORM.DTO.SearchDTO;
import com.springORM.entity.Instructor;
import com.springORM.service.InstructorService;

@Controller
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	@RequestMapping("/instructor-info")
	public String showInstructorHomePage(Model model)
	{
		List<Instructor> instructorList = instructorService.findAllInstructor();
		System.out.println(instructorList);
		model.addAttribute("instructorList", instructorList);
		model.addAttribute("searchDTO", new SearchDTO());
		return "instructor-info";
		
	}
	
	@RequestMapping("/add-instructor")
	public String showAddInstructorPage(Model model) {
		
		model.addAttribute("instructor", new Instructor());  /* Instructor 
	   object being created here and sent via the model attribute to  add-instructor.jsp 
	   modelAttribute="instructor"*/
		return "add-instructor";
	}
	
	@PostMapping("/submit-instructor")
	public String addInstructor(Instructor instructor) {
		
		instructorService.saveInstructor(instructor);
		return "redirect:/instructor-info";
	}
	@RequestMapping("/process-search-id")
	public String searchById(@RequestParam("id") int id, Model model) {
		
		List<Instructor> instructorsList = new ArrayList<>();
		Instructor findInstructorById = instructorService.findInstructorById(id);
		instructorsList.add(findInstructorById);
		model.addAttribute("instructorList", instructorsList);
		model.addAttribute("searchDTO", new SearchDTO());
		return "instructor-info"; 
	}
	@RequestMapping("/process-search-name")
	public String searchByName(@RequestParam("name") String name, Model model) {
		
		List<Instructor> instructorByName = instructorService.findInstructorByName(name);
		model.addAttribute("instructorList", instructorByName);
		model.addAttribute("searchDTO", new SearchDTO());
		return "instructor-info";
	}
	@RequestMapping("/delete/{id}")
	public String deleteInstructor(@PathVariable("id") int id) {
		instructorService.deleteInstructor(id);
		return "redirect:/instructor-info";
		
	}
	
	
	
	
	
}

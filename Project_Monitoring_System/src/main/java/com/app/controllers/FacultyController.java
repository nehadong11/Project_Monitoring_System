package com.app.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Faculty;
import com.app.pojos.Project;
import com.app.pojos.Students;
import com.app.service.AdminServiceInterface;
import com.app.service.FacultyServiceInterface;

@Controller
@RequestMapping("/Faculty")
public class FacultyController {

	@Autowired
	private FacultyServiceInterface facultyService;
	
	@Autowired
	private AdminServiceInterface adminService;
	
	public FacultyController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/Dashboard")
	public String showDashboard(HttpSession hs) {
		Faculty fac=(Faculty) hs.getAttribute("userDetails");
		List<Project> list=facultyService.fetchMyProjects(fac);
		int count=0;
		for(Project p:list) {
			count=count+1;
		}
		hs.setAttribute("groupCount",count);
		List<Students> list1=adminService.fetchStudents();
		int count1=0;
		for(Students p:list1) {
			count1=count1+1;
		}
		hs.setAttribute("studentCount", count1);
		return "/Faculty/Dashboard";
	}
	@GetMapping("/myproject")
	public String showMyAssignedProjects(HttpSession hs) {
		Faculty fac=(Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("projectsList", facultyService.fetchMyProjects(fac));
		return "/Faculty/myproject";
	}
	
	@GetMapping("/groupDiscussion")
	public String showGroups(HttpSession hs) {
		Faculty fac=(Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("projectsList", facultyService.fetchMyProjects(fac));
		return "/Faculty/groupDiscussion";
	}
	@GetMapping("/addRemark")
	public String addRemark(HttpSession hs) {
		Faculty fac=(Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("projectsList", facultyService.fetchMyProjects(fac));
		return "/Faculty/addRemark";
	}
	
	
	@GetMapping("/viewDiscussion")
	public String viewDiscussion(@RequestParam int pid,HttpSession hs) {
		Faculty fac=(Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("chatList", facultyService.fetchChat(pid));
		return "/Faculty/viewDiscussion";
	}
	
	@GetMapping("/reportForm")
	public String showReportForm(@RequestParam int pid,HttpSession hs) {
		
		hs.setAttribute("report", facultyService.fetchReport(pid));
		return "/Faculty/reportForm";
	}
	
	@PostMapping("/updateReport")
	public String processReportUpdate(@RequestParam int rid,@RequestParam String description, @RequestParam String srs, @RequestParam String report, @RequestParam String ppt, @RequestParam String demo1, @RequestParam String demo2, @RequestParam String demo3,
			@RequestParam String marks,HttpSession hs,Model modelMap,RedirectAttributes flahMap) {
		flahMap.addFlashAttribute("message", facultyService.updateReport(rid,description,demo1,demo2,demo3,marks,srs,report,ppt));
		return "redirect:/Faculty/addRemark";
	}
}

package com.app.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Messages;
import com.app.pojos.Project;
import com.app.pojos.ProjectGroup;
import com.app.pojos.Students;
import com.app.service.AdminServiceInterface;
import com.app.service.LoginServiceInterface;
import com.app.service.StudentServiceInterface;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentServiceInterface studentService;
	
	@Autowired
	private LoginServiceInterface loginService;
	
	@Autowired
	private AdminServiceInterface adminService;

	public StudentController() {
		System.out.println("in const of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String showStudentDashboard(HttpSession hs) {
		Students std = (Students) hs.getAttribute("userDetails");
		hs.setAttribute("userDetails", loginService.verifyStudentLogin(std.getsEmail(),std.getPassword()));
		hs.setAttribute("groupMembers", studentService.fetchMyGroupMembers(std));
		return "/Student/Dashboard";
	}

	@GetMapping("/studentProfile")
	public String showStudentProfile(HttpSession hs) {
		Students std = (Students) hs.getAttribute("userDetails");

		hs.setAttribute("userDetails", loginService.verifyStudentLogin(std.getsEmail(), std.getPassword()));
		return "/Student/studentProfile";
	}

	@PostMapping("/updateProfile")
	public String processStudentProfileUpdate(@RequestParam String prn, @RequestParam String courseName,
			@RequestParam String courseBatchYear, @RequestParam String courseDuration, @RequestParam String name,
			@RequestParam String email, @RequestParam String locality, @RequestParam String address,
			@RequestParam String state, @RequestParam String zip, @RequestParam String country,
			@RequestParam String gender, @RequestParam String mobile, Model modelMap, RedirectAttributes flashMap,
			HttpSession hs) {
		try {
			Students std = (Students) hs.getAttribute("userDetails");
			flashMap.addFlashAttribute("success",
					studentService.updateStudentInfo(std, prn, courseName, courseBatchYear, courseDuration, name, email,
							locality, address, state, zip, country, gender, mobile));

			return "redirect:/Student/studentProfile";
		} catch (Exception e) {
			return "/Student/studentProfile";
		}
	}

	@GetMapping("/createProject")
	public String createProject(HttpSession hs) {
		Students std = (Students) hs.getAttribute("userDetails");
		hs.setAttribute("myproject", studentService.fetchMyProject(std));
		return "/Student/createProject";
	}

	@PostMapping("/createProject")
	public String processCreateProject(@RequestParam String title, @RequestParam String description, HttpSession hs,
			Model modelMap, RedirectAttributes flashMap) {
		Students std = (Students) hs.getAttribute("userDetails");
		Project project = new Project(title, description, std, "Waiting for Approval");
		flashMap.addFlashAttribute("message", studentService.createProject(project));
		return "redirect:/Student/createProject";
	}

	@GetMapping("/addtogroup")
	public String addtoGroup(@RequestParam int pid, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		Students std = (Students) hs.getAttribute("userDetails");
		Project proj=adminService.fetchProjectByID(pid);
		ProjectGroup group=studentService.fetchStudentGroup(std);
		int groupID=std.getProjectGroup().getId();
		flashMap.addFlashAttribute("message",studentService.addProjecttogroup(group,proj));
		return "redirect:/Student/createProject";
	}
	
	@GetMapping("/discussion")
	public String viewDiscussion(HttpSession hs) {
		Students std = (Students) hs.getAttribute("userDetails");
		hs.setAttribute("chatList", studentService.fetchChat(std));
		return "/Student/discussion";
	}
	
	@PostMapping("/saveMessage")
	public String saveMessage(@RequestParam String msg,Model modelMap,HttpSession hs) {
		Students std = (Students) hs.getAttribute("userDetails");
		ProjectGroup pg=std.getProjectGroup();
		 DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		    Date dateobj = new Date();
		    System.out.println(df.format(dateobj));
		    String date=df.format(dateobj).toString();
		Messages msg1=new Messages(std, pg, msg, date);
		modelMap.addAttribute("message", studentService.addChat(msg1));
		return "redirect:/Student/discussion";
	}
	@GetMapping("/report")
	public String myreport(HttpSession hs) {
		Students std = (Students) hs.getAttribute("userDetails");
		hs.setAttribute("userDetails", loginService.verifyStudentLogin(std.getsEmail(), std.getPassword()));
		return "/Student/Report";
	}
	@GetMapping("/Add_Git_link")
	public String showAddGitLink() {
		return "/Student/Add_Git_link";
	}
	@PostMapping("/Add_Git_link")
	public String saveLink(@RequestParam String link,Model modelMap,RedirectAttributes flashMap,HttpSession hs) {
		Students std = (Students) hs.getAttribute("userDetails");
		Project project=std.getProjectGroup().getProject();
		flashMap.addFlashAttribute("message", studentService.addLink(link,project));
		return "redirect:/Student/Add_Git_link";
	}
}

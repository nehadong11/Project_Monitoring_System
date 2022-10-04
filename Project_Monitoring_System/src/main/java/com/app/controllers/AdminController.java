package com.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.pojos.Faculty;
import com.app.pojos.Project;
import com.app.pojos.Students;
import com.app.service.AdminServiceInterface;
import com.app.service.FacultyServiceInterface;
import com.app.service.LoginServiceInterface;
import com.app.utility.PasswordSender;
import com.app.utility.ProjectARSender;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminServiceInterface adminService;
	@Autowired
	private LoginServiceInterface loginService;
	
	@Autowired
	private FacultyServiceInterface facultyService;

	public AdminController() {
		System.out.println("in Constr of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String showAdminDashboard(HttpSession hs) {
		List<Students> list1=adminService.fetchStudents();
		int count1=0;
		for(Students p:list1) {
			count1=count1+1;
		}
		hs.setAttribute("studentCount", count1);
		List<Faculty> list=adminService.fetchFaculty();
		int count=0;
		for(Faculty p:list) {
			count=count+1;
		}
		hs.setAttribute("facCount", count);
		return "/Admin/Dashboard";
	}

	@GetMapping("/adminProfile")
	public String showAdminProfile(HttpSession hs) {
		Admin admin = (Admin) hs.getAttribute("userDetails");
		hs.setAttribute("userDetails", loginService.verifyAdminLogin(admin.getEmail(), admin.getPassword()));
		return "/Admin/adminProfile";
	}

	@PostMapping("/updateProfile")
	public String processUpdateProfile(@RequestParam String name, @RequestParam String email,
			@RequestParam String mobile, Model modelMap, RedirectAttributes flashMap, HttpSession hs) {
		Admin admin = (Admin) hs.getAttribute("userDetails");
		flashMap.addFlashAttribute("success", adminService.updateprofileinfo(admin, name, email, mobile));
		return "redirect:/Admin/adminProfile";
	}

	@GetMapping("/registredStudent")
	public String showregistredStudent(HttpSession hs, Model modelMap) {
		hs.setAttribute("studentList", adminService.fetchStudents());
		return "/Admin/registredStudent";
	}

	@GetMapping("/registredFaculty")
	public String showRegistredFculty(HttpSession hs, Model modelMap) {
		hs.setAttribute("facultyList", adminService.fetchFaculty());
		return "/Admin/registredFaculty";
	}

	@GetMapping("/addFaculty")
	public String addFaculty() {
		return "/Admin/addFaculty";
	}

	@PostMapping("/addFaculty")
	public String registerFaculty(@RequestParam String fname, @RequestParam String lname, @RequestParam String email,
			@RequestParam String mobile, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		String password = fname.concat("#9860");
		Faculty faculty = new Faculty(fname + " "+lname, email, password, mobile, "new");
		PasswordSender ps = new PasswordSender();
		ps.sendEmail(email, email, password);
		flashMap.addFlashAttribute("success", loginService.registerFaculty(faculty));
		return "redirect:/Admin/registredFaculty";
	}

	@GetMapping("/projectRequests")
	public String showProjectRequests(HttpSession hs) {
		hs.setAttribute("projectRequest", adminService.fechProject());
		return "/Admin/projectRequests";
	}

	@GetMapping("/Accept_project")
	public String acceptProject(@RequestParam int rid, Model modelMap, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", adminService.toggleProject(rid));
		return "redirect:/Admin/projectRequests";
	}

	@GetMapping("/reject_project")
	public String rejectProject(@RequestParam int rid, Model modelMap, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", adminService.toggleRProject(rid));
		return "redirect:/Admin/projectRequests";
	}

	@GetMapping("/createGroup")
	public String createGroup(HttpSession hs) {
		hs.setAttribute("FacultyList", adminService.fetchFaculty());
		List<Students> stdList = adminService.fetchStudents();
		List<Students> list = new ArrayList<>();
		for (Students s : stdList) {
			if (s.getProjectGroup() != null) {
				continue;
			} else {
				list.add(s);
			}
		}
		hs.setAttribute("studentList", list);
		return "/Admin/CreateGroup";
	}

	@PostMapping("/createGroup")
	public String createForupM(@RequestParam String groupNo, @RequestParam int std1, @RequestParam int std2,
			@RequestParam int std3, @RequestParam int std4, Model modelMap, RedirectAttributes flashMap) {
		try {
			if (adminService.groupNoAvailabe(groupNo)) {
				System.out.println("step 1");
				flashMap.addFlashAttribute("message", adminService.createGroup(groupNo, std1, std2, std3, std4));
				System.out.println("step 2");
				return "redirect:/Admin/createGroup";
			} else {
				flashMap.addFlashAttribute("message", "Group No Already taken");
				return "redirect:/Admin/createGroup";
			}
		} catch (Exception e) {
			flashMap.addFlashAttribute("message", "Duplicate Student can not add into Same group");
			return "redirect:/Admin/createGroup";
		}

	}

	@GetMapping("/assignGuide")
	public String asssignguide(HttpSession hs) {
		List<Project> projList = adminService.fetchAllProjects();
		List<Project> list = new ArrayList<>();
		for (Project p : projList) {
			if (p.getGuide() != null) {
				continue;
			} else {
				list.add(p);
			}
		}
		hs.setAttribute("projectList", list);
		hs.setAttribute("FacultyList", adminService.fetchFaculty());
		return "/Admin/assignGuide";
	}

	@PostMapping("/assignGuide")
	public String assignGuide(@RequestParam int proj, @RequestParam int fac, Model modelMap,
			RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", adminService.addGuide(proj, fac));
		return "redirect:/Admin/assignGuide";
	}
	@GetMapping("/approvedProject")
	public String showapprovedProject(HttpSession hs) {
		hs.setAttribute("projectRequest", adminService.fetchApprovedProject());
		return "/Admin/approvedProject";
	}
	
	@GetMapping("/rejectedproject")
	public String showrejectedProject(HttpSession hs) {
		hs.setAttribute("projectRequest", adminService.fetchRejectedProject());
		return "/Admin/rejectedproject";
	}
	
	@GetMapping("/viewReport")
	public String viewReport(HttpSession hs) {
		hs.setAttribute("projectsList", adminService.fetchApprovedProject());
		return "/Admin/viewReport";
	}
	@GetMapping("/reportForm")
	public String showReportForm(@RequestParam int pid,HttpSession hs) {
		
		hs.setAttribute("report", facultyService.fetchReport(pid));
		return "/Admin/reportForm";
	}
	
}

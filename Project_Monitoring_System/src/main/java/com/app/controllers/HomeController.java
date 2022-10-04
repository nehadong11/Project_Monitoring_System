package com.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Address;
import com.app.pojos.Admin;
import com.app.pojos.Faculty;
import com.app.pojos.Students;
import com.app.service.LoginServiceInterface;
import com.app.utility.AESUtils;
import com.app.utility.OTPSender;
import com.app.utility.Utility;

@Controller
@RequestMapping("/")
public class HomeController {

	final String secretKey = "JHKLXABYZC!!!!";
	
	@Autowired
	private LoginServiceInterface loginService;

	public HomeController() {
		System.out.println("Home controller is Initilized.... ");
	}

	@GetMapping("/")
	public String showHomePage(HttpSession hs) {
		Admin admin = loginService.checkAdminAvailablity();
		if (admin != null) {
			
		} else {
			Admin admin1 = new Admin("Super User", "admin@gmail.com", "admin@123", "9766783954", "Active");
			loginService.registerAdmin(admin1);
		}
		return "/Index";
	}

	@GetMapping("/registration")
	public String showRegisterPage() {
		return "/Registration";
	}

	@PostMapping("/signup")
	public String signUpStudent(@RequestParam String prn, @RequestParam String name, @RequestParam String email,
			@RequestParam String locality, @RequestParam String address, @RequestParam String state,
			@RequestParam String zip, @RequestParam String country, @RequestParam String dob,
			@RequestParam String gender, @RequestParam String pcode, @RequestParam String mobile,
			@RequestParam String password, @RequestParam String courseName, @RequestParam String courseBatchYear,
			@RequestParam String courseDuration, @RequestParam String cpassword, HttpSession hs, Model modelMap,
			RedirectAttributes flashMap) {
		String encryptedPassword = AESUtils.encrypt(password, secretKey);
		//User user = userService.validateUser(email, encryptedPassword);
		
		Students stdData = new Students(prn, name, gender, email, pcode + mobile, courseName, courseBatchYear,
				courseDuration, encryptedPassword, "new");
		Address stdAddress = new Address(locality, address, state, zip, country);
		hs.setAttribute("stdData", stdData);
		hs.setAttribute("stdAddress", stdAddress);
		int otp = Utility.generateOTP();
		System.out.println(otp);
		hs.setAttribute("otp", otp);
		OTPSender otpSender = new OTPSender();
		otpSender.sendEmail(email, otp);
		return "/Verifaction";
		// return "/registration";
	}

	@PostMapping("/verify")
	public String verifyOTP(@RequestParam String otp, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		Students std = (Students) hs.getAttribute("stdData");
		Address add = (Address) hs.getAttribute("stdAddress");
		int otp1 = (int) hs.getAttribute("otp");
		if (otp.equals("")) {
			modelMap.addAttribute("otpError", "Please Insert OTP to verify");
			return "/Verifaction";
		} else {
			if (otp1 == Integer.parseInt(otp)) {
				flashMap.addFlashAttribute("message", loginService.registerUser(std, add));
				return "redirect:/success";
			} else {
				modelMap.addAttribute("otpError", "Invalid Otp Try Again");
				return "/Verifaction";
			}
		}
	}

	@GetMapping("/success")
	public String successPage() {
		return "/Success";
	}

	//form data submited on login form is fetched here
	@PostMapping("/userLogin")
	public String verifyUserLogin(@RequestParam String email, @RequestParam String password, Model modelMap,
			RedirectAttributes flashMap, HttpSession hs) {
		try {
			String encryptedPassword = AESUtils.encrypt(password, secretKey);
			Students std = loginService.verifyStudentLogin(email, encryptedPassword);
			Faculty fac = loginService.verifyFacultyLogin(email, password);
			Admin admin = loginService.verifyAdminLogin(email, password);
			if (std != null) {
				hs.setAttribute("userDetails", std);
				return "redirect:/Student/Dashboard";
			} else if (fac != null) {
				hs.setAttribute("userDetails", fac);
				return "redirect:/Faculty/Dashboard";
			} else if (admin != null) {
				hs.setAttribute("userDetails", admin);
				return "redirect:/Admin/Dashboard";
			}else {
			flashMap.addFlashAttribute("error", "Invalid Credentials");
				return "redirect:/";
			
			}
		} catch (Exception e) {
			modelMap.addAttribute("error", "Under Maintainance Please try later");
			return "redirect:/";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.getAttribute("userDetails");
		hs.invalidate();
		return "redirect:/";
	}
	
	
	@GetMapping("/forgetpassword")
	public String showForgetpasswordPage() {
		return "/Forgetpassword";
	}
	
	@PostMapping("/getpassword")
	public String getPassword(@RequestParam String email, HttpSession hs, Model modelMap,RedirectAttributes flashMap) 
	{
		String psw= loginService.fetchPassword(email);
		String decryptPassword = AESUtils.decrypt(psw, secretKey);
		
		System.out.println(decryptPassword);
		OTPSender otpSender = new OTPSender();
		otpSender.sendpassEmail(email, decryptPassword);
		return "redirect:/";
		
		
	}


}

package kr.somoonShop.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {

	@RequestMapping("/login")
	public String loginPage() {
		return "/login.html";
	}
	
	@RequestMapping("/sign")
	public String signPage() {
		return "/sign.html";
	}
	
	@RequestMapping("/signup")
	public @ResponseBody Map<String, Object> signupPage(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println(request.getParameter("accountId"));
		System.out.println(request.getParameter("accountMail"));
		System.out.println(request.getParameter("accountPassword"));
		System.out.println(request.getParameter("accountPassword2"));
		return result;
	}
	
	@RequestMapping("/member")
	public Map<String, Object> memberSignUp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> param = new HashMap<String, Object>();
		
		return param;
		
	}

}

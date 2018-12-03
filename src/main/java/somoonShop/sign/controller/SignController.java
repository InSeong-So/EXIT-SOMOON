package somoonShop.sign.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignController {

	@RequestMapping("/login")
	public String loginPage() {
		return "/login.html";
	}
	
	@RequestMapping("/sign")
	public String signPage() {
		return "/sign.html";
	}
	
	@RequestMapping("/member")
	public Map<String, Object> memberSignUp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> param = new HashMap<String, Object>();
		
		return param;
		
	}

}

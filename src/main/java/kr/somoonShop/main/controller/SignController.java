package kr.somoonShop.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.somoonShop.service.SMAccount;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SignController {

	@Autowired
	private SMAccount smAccount;

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
		String[] accountInfo = { request.getParameter("accountId"), request.getParameter("accountMail"),
				request.getParameter("accountPassword") };

		if (smAccount.getAccountInfo(request.getParameter("accountId")).isPresent()) {
			log.info("존재하는 값입니다.");
		} else {
			smAccount.addAccount(accountInfo);
		}

		result.put("accountId", request.getParameter("accountId"));

		return result;
	}

	@RequestMapping("/member")
	public Map<String, Object> memberSignUp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> param = new HashMap<String, Object>();

		return param;

	}

}

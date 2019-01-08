package kr.somoonShop.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.somoonShop.service.SMAccount;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignController {

	@Autowired
	private SMAccount smAccount;

	@RequestMapping("/")
	public String mainPage(HttpSession session) {

		if (session == null) {
			log.info("로그인 정보가 없습니다.");
		} else {
			log.info("로그인 되었습니다." + session.getAttribute("account"));
		}

		return "01-home";
	}

	@RequestMapping(value = "/session", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sessionData(HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("account", session.getAttribute("account"));
		return result;
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/loginAccess")
	public String loginAccessPage(HttpServletRequest request, HttpSession session) {
		if (request.getParameter("accountId") != null && smAccount.accessLogin(request.getParameter("accountId"),
				request.getParameter("accountPassword")) != null) {
			log.info("환영합니다.");
			session.setAttribute("account",
					smAccount.accessLogin(request.getParameter("accountId"), request.getParameter("accountPassword"))
							.getAccountName());
		} else {
			log.info("계정 정보가 일치하지 않거나 없는 계정입니다.");
		}
		return mainPage(session);
	}

	@RequestMapping("/sign")
	public String signPage() {
		return "sign";
	}

	@RequestMapping("/signup")
	public @ResponseBody Map<String, Object> signupPage(HttpServletRequest request, HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		String[] accountInfo = { request.getParameter("accountId"), request.getParameter("accountMail"),
				request.getParameter("accountPassword") };

		if (smAccount.getAccountInfo(request.getParameter("accountId")).isPresent()) {
			log.info("존재하는 값입니다.");
		} else {
			smAccount.addAccount(accountInfo);
		}

		session.setAttribute("accountId",
				smAccount.getAccountInfo(request.getParameter("accountId")).get().getAccountNo());

		result.put("accountId", request.getParameter("accountId"));

		return result;
	}

	@RequestMapping("/member")
	public Map<String, Object> memberSignUp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> param = new HashMap<String, Object>();

		return param;

	}

	@RequestMapping("/mypage")
	public @ResponseBody Map<String, Object> myPage(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();

//		smAccount.getAccountInfo(accountNo);

		return result;
	}

}

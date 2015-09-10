package com.test.mmm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.mmm.entity.Result;
import com.test.mmm.entity.User;
import com.test.mmm.repository.ResultRepository;
import com.test.mmm.repository.UserRepository;

/**
 * Created by Marian_Mykhalchuk on 9/9/2015.
 */
@Controller
public class ResultController {

	@Autowired
	private ResultRepository resultRepository;
	@Autowired
	private UserRepository userRepository;

	/**
	 * All possible parameters in Controller's method
	 * http://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping-arguments
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/results")
	public ModelAndView getAllResults() {
		ModelAndView mv = new ModelAndView("resultsView");
		mv.addObject("results", resultRepository.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/results/{resultId}")
	public ModelAndView getResult(@PathVariable("resultId") Long resultId) {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/results/add")
	public ModelAndView createFormResult() {
		ModelAndView mv = new ModelAndView("formResult");
		mv.addObject("result", new Result());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/results/add")
	public String createResult(@ModelAttribute Result result, Principal principal) {
		User user = userRepository.findByFirstName(principal.getName()).get(0);
		result.setUser(user);
		resultRepository.save(result);
		return "redirect:/results";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/results/delete/{resultId}")
	public ModelAndView removeResult(@PathVariable("resultId") Long resultId) {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}

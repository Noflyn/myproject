package com.dresses.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloWorldController {

	@RequestMapping("/")
	public ModelAndView helloWorld() {
	return new ModelAndView("welcome");
	
}
	@RequestMapping("/login")
	public ModelAndView helloWorld1() {
	return new ModelAndView("login");
	
}
	@RequestMapping("/lehenga")
	public ModelAndView helloWorld2() {
	return new ModelAndView("lehenga");
	
}
	@RequestMapping("/salwar")
public ModelAndView helloWorld3() {
return new ModelAndView("salwar");

}
	@RequestMapping("/contact")
	public ModelAndView helloWorld4() {
	return new ModelAndView("contact");
}

@RequestMapping("/sarees")
public ModelAndView helloWorld5() {
return new ModelAndView("sarees");
}
}
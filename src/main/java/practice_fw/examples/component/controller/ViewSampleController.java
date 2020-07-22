package practice_fw.examples.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewSampleController {

	public ViewSampleController() {
		super();
	}

	@RequestMapping(value="/view_sample.do", method=RequestMethod.GET)
	public String handleRequest(){
		String viewName = "sample";
		return viewName;
	}
}

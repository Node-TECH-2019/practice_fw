package practice_fw.examples.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import practice_fw.examples.entity.ProductModel;

@Controller
public class ParameterSampleController {

	public ParameterSampleController() {
		super();
	}

	@RequestMapping(value="/show_form.do", method=RequestMethod.GET)
	public String showForm(){
		String name = "parameter_form";
		return name;
	}

	@RequestMapping(value="/show_parameter.do", method=RequestMethod.POST)
	public ModelAndView receiveParameter(@RequestParam("name") String productName, @RequestParam("price") Integer productPrice){
		ProductModel productModel = new ProductModel();
		productModel.setName(productName);
		productModel.setPrice(productPrice);

		String name = "parameter_view";
		return new ModelAndView(name, "product", productModel);
	}

	@RequestMapping(value="/show_model.do", method=RequestMethod.POST)
	public ModelAndView receiveParameterByModel(ProductModel productModel){
		String name = "parameter_view";
		return new ModelAndView(name, "product", productModel);
	}
}

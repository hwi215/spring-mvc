package com.example.mybatisspring0.controller;

import com.example.mybatisspring0.dto.ProductDTO;
import com.example.mybatisspring0.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/form/{url}")
	public void url(){}

	/**
	 * 0. 전체검색
	 */
	@RequestMapping("/selectAll")
	public ModelAndView selectAll(){
		List<ProductDTO> list = productService.selectAll();
		// viewName: jsp 이름,  modelName: 프론트에 전달되는 이름
		return new ModelAndView("selectResult", "productList", list);
	}


}








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
	 * 1. 전체검색
	 */
	@RequestMapping("/selectAll")
	public ModelAndView selectAll(){
		List<ProductDTO> list = productService.selectAll();
		// viewName: jsp 이름,  modelName: 프론트에 전달되는 이름
		return new ModelAndView("selectResult", "productList", list);
	}
	/**
	 * 2. 등록하기
	 */
	@RequestMapping("/insert")
	public String insert(ProductDTO productDTO){
		// 레코드 삽입
		productService.insert(productDTO);
		System.out.println("등록 성공");
		return "redirect:/selectAll";
	}

	/**
	 * 3. 검색필드 , 검색단어에 해당하는 레코드 검색
	 * */
	@RequestMapping("/selectByWord")
	public ModelAndView selectByWord(String keyField, String keyWord){
		// 조건에 맞는 레코드 검색
		List<ProductDTO> list = productService.selectByKeyWord(keyField, keyWord);
		System.out.println("검색 성공!");
		return new ModelAndView("selectResult", "productList", list);
	}

	/**
	 * 4. 정렬대상 컬럼을 인수로 받아 정렬
	 * */
	@RequestMapping("/selectByOrder")
	public ModelAndView selectByOrder(String columnName){
		List<ProductDTO> list = productService.selectOrder(columnName);
		System.out.println("정렬 성공!");
		return new ModelAndView("selectResult", "productList", list);

	}

	/**
	 * 5. 파라미터 값을 받아 업데이트하기
	 * */
	@RequestMapping("/update")
	public String update(ProductDTO productDTO){
		productService.update(productDTO);
		System.out.println("update 성공");
		return "redirect:/selectAll";

	}


}








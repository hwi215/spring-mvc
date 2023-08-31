package com.example.mybatisspring0.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
	private String code;
	private String name;
	private int qty;
	private int price;
	private String detail;
}

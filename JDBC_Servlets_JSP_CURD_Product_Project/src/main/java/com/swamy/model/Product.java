package com.swamy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer pid;
	private String pname;
	private Double pcost;
	private String pdesc;
}


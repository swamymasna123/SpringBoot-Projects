package com.swamy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_tab_orm")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id_col")
	private Integer id;

	@Column(name = "employee_name_col")
	private String empName;
	
	@Column(name = "employee_sal_col")
	private Double empSal;
	
	@Column(name = "employee_pf_col")
	private Double pf;
	
	@Column(name = "employee_esi_col")
	private Double esi;
	
	@Column(name = "employee_address_col")
	private String empAddress;
}

package com.example.demo.dto;

import java.io.Serializable;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor

public class DancerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long dancerId;
	private String firstName;
	private Long articalId;
	private String brandName;
	
	

}

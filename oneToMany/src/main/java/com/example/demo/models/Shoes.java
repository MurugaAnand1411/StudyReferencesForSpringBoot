package com.example.demo.models;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "shoes")

public class Shoes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "artical_Id")
	private Long articalId;

	@Column(name = "brandName")
	private String brandName;

	@Column(name = "modelName")
	private String modelName;
	
	@ManyToOne
	//@JoinColumn(name="fk_dancer_id")
	private Dancer dan;
	
}

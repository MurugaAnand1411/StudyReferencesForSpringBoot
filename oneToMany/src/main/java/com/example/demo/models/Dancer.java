package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "dancer")


public class Dancer{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "dancer_Id")
		private Long dancerId;

		@Column(name = "firstName")
		private String firstName;

		@Column(name = "lastName")
		private String lastName;
		
		@Column(name = "danceType")
		private String danceType;
		
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		//@JoinColumn(name="fk_shoes_id")
		private List <Shoes> shoes;
		
}

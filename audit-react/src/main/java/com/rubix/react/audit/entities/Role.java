package com.rubix.react.audit.entities;
/*
 * *@author Muruganandham
 *
 * @version 1.0
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "role")


public class Role {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_Id")

	private Long roleId;

	private String name;


}

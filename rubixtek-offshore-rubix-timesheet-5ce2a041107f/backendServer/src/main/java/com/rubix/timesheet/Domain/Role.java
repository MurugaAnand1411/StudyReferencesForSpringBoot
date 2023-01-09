package com.rubix.timesheet.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "role_seq", initialValue = 5, allocationSize = 5)
@Table(name = "roles" ,schema="public")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

}
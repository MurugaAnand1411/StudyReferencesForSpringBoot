package com.rubix.react.audit.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users",schema="public")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_Id")

	private Long userId;

	private String firstName;

	private String lastName;

	private String password;

	//@Column(unique = true, nullable = false, length = 45)
	private String email;

	private String mobileNumber;


//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "users_roles",
//			joinColumns = @JoinColumn(
//		            name = "user_id", referencedColumnName = "user_Id"),
//			inverseJoinColumns = @JoinColumn(
//				            name = "role_id", referencedColumnName = "role_Id"))



	@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rp_fk", referencedColumnName = "user_Id")
	private Collection<Role> roles;

}

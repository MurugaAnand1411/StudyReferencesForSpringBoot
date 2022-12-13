package com.rubix.hrm.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="client1")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="client_id")
	private long clientId;	
	
	@Column(name="cli_name")
	private String cliName;
	

	@Column(name="cli_gstno")
	private String cliGestNo;
	
	@Column(name="cli_mail")
	private String cliMail;
	
	@Column(name="cli_address")
	private String cliAddress;
	
	@Column(name="cli_barach")
	private String comabrach;
	
	@Column(name="cli_region")
	private String comaRegion;


}

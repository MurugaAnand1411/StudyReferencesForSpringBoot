package com.demo.kpac.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


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
public class Kpac {
	@JsonProperty("id")
	private long kpacId;
	@JsonProperty("title")
	private String kpacTitle;
	private String description;
	@JsonFormat(pattern = "MM-dd-YYYY")
	private Date createDate = new Date();

}

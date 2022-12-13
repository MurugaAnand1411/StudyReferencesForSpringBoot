package com.demo.kpac.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetOfKpac {
	@JsonProperty("id")
	private long setId;
	@JsonProperty("title")
	private String setTitle;
	private List<Kpac> kpacs;

	public void addKPac(Kpac kpac) {
		if (kpac != null) {
			kpacs.add(kpac);
		}
	}

}

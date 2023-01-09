package com.rubix.timesheet.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team", schema = "public")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long teamId;
	private String teamname;
	private String teamlead;

}

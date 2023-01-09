package com.rubix.timesheet.Domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project", schema = "public")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long projectId;
	private String clientName;
    private String projectName;
    private String projectType;
    private String projectDescription;
    private String projectManager;
    @Temporal(TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private Date startDate;
    @Temporal(TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private Date endDate;
}

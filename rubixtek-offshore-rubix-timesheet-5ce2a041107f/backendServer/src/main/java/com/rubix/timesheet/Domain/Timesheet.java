package com.rubix.timesheet.Domain;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "timesheet", schema = "public")
public class Timesheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long timesheetId;
	private String teamname;
	@Temporal(TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date startDate;
	@Temporal(TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date endDate;
	@Temporal(TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date submittedDate;
	private String timesheetApprover;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
	private Employee employee;
	@JsonIgnore
	@OneToMany(mappedBy = "timesheet", cascade = CascadeType.REMOVE)
	private List<TimesheetDetail> timesheetDetail;
	@Temporal(TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@ElementCollection
	private List<Date> dateRange;
	@Enumerated(EnumType.STRING)
	private Status status;
	private long billableHours;
	private Boolean isApproved;
	private Boolean isRejected;
	
}

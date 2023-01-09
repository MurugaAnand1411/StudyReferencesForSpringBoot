package com.rubix.timesheet.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "timesheetdetail", schema = "public")
public class TimesheetDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long timesheetDetailId;
	private String projectname;
	private String task;
	private String paycode;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "timesheet_id", referencedColumnName = "timesheetId")
	private Timesheet timesheet;
	@OneToMany(mappedBy = "timesheetDetail", cascade = CascadeType.REMOVE)
	private List<DateRange> daterange;
	@OneToMany(mappedBy = "timesheetDetail", cascade = CascadeType.REMOVE)
	private List<Holidaytimeoff> holidaytimeoff;
	@OneToMany(mappedBy = "timesheetDetail", cascade = CascadeType.REMOVE)
	private List<Applytimeoff> applytimeoff;
}

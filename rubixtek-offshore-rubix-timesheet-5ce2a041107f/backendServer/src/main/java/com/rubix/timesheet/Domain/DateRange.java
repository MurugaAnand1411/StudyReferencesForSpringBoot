package com.rubix.timesheet.Domain;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "daterange", schema = "public")

public class DateRange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long dateRangeId;
	@Temporal(TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date date;
	@Column(nullable=true,columnDefinition = "bigint default 0")
	private long hours;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "timesheetdetail_id", referencedColumnName = "timesheetDetailId")
	private TimesheetDetail timesheetDetail;
	
}

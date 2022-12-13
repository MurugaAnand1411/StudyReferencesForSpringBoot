package com.react.ecommerce.domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

	@CreatedDate
	@Temporal(TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	protected Date createdDate;
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	protected Date updatedDate;
	protected long createdDateEpoch;
	protected long updatedDateEpoch;

	@PrePersist
	protected void onCreate() {
		createdDateEpoch = System.currentTimeMillis();

	}

	@PreUpdate
	protected void onUpdate() {
		updatedDateEpoch = System.currentTimeMillis();
	}
}
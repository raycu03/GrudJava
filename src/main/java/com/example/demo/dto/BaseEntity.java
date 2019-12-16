package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//numero
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name ="fecha_creacion", nullable=false, updatable= false)
	@CreatedDate
	private Date fechaCreacionDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name ="fecha_actu", updatable= true)
	
	@LastModifiedDate
	private Date fechaActu;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCreacionDate() {
		return fechaCreacionDate;
	}

	public void setFechaCreacionDate(Date fechaCreacionDate) {
		this.fechaCreacionDate = fechaCreacionDate;
	}

	public Date getFechaActu() {
		return fechaActu;
	}

	public void setFechaActu(Date fechaActu) {
		this.fechaActu = fechaActu;
	}

	
	
}

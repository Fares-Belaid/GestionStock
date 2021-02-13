package com.fares.gestiondestock.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)			// ta3mel listener l class bech f kol marra ta3ti valeur l creation date w last modified date
public class AbstractEntity implements Serializable {

@Id
@GeneratedValue
private int id;

@CreatedDate
@Column(name="creationDate", nullable = false)
@JsonIgnore
private Instant CreationDate;

@LastModifiedDate
@Column(name="castModifiedDate",nullable = false)
@JsonIgnore
private Instant LastModifiedDate;




}

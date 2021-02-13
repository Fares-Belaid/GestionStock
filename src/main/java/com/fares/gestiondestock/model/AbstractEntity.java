package com.fares.gestiondestock.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@MappedSuperclass
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

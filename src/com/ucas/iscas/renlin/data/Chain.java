package com.ucas.iscas.renlin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Chain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "chain", catalog = "ssllabs")
public class Chain implements java.io.Serializable {

	// Fields

	private Integer id;
	private String certs;
	private Short issues;

	// Constructors

	/** default constructor */
	public Chain() {
	}

	/** minimal constructor */
	public Chain(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Chain(Integer id, String certs, Short issues) {
		this.id = id;
		this.certs = certs;
		this.issues = issues;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "certs")
	public String getCerts() {
		return this.certs;
	}

	public void setCerts(String certs) {
		this.certs = certs;
	}

	@Column(name = "issues")
	public Short getIssues() {
		return this.issues;
	}

	public void setIssues(Short issues) {
		this.issues = issues;
	}

}
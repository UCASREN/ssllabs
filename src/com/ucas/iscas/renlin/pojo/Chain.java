package com.ucas.iscas.renlin.pojo;

import java.util.List;

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
	private List<Chaincert> certs;
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
	public Chain(Integer id, List<Chaincert> certs, Short issues) {
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
	public List<Chaincert> getCerts() {
		return this.certs;
	}

	public void setCerts(List<Chaincert> certs) {
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
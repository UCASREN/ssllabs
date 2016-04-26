package com.ucas.iscas.renlin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simdetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "simdetails", catalog = "ssllabs")
public class Simdetails implements java.io.Serializable {

	// Fields

	private Integer id;
	private String results;

	// Constructors

	/** default constructor */
	public Simdetails() {
	}

	/** minimal constructor */
	public Simdetails(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Simdetails(Integer id, String results) {
		this.id = id;
		this.results = results;
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

	@Column(name = "results")
	public String getResults() {
		return this.results;
	}

	public void setResults(String results) {
		this.results = results;
	}

}
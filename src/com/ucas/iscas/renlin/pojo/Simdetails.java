package com.ucas.iscas.renlin.pojo;

import java.util.List;

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
	private List<Simulation> results;

	// Constructors

	/** default constructor */
	public Simdetails() {
	}

	/** minimal constructor */
	public Simdetails(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Simdetails(Integer id, List<Simulation> results) {
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
	public List<Simulation> getResults() {
		return this.results;
	}

	public void setResults(List<Simulation> results) {
		this.results = results;
	}

}
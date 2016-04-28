package com.ucas.iscas.renlin.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private Set<Simulation> results = new HashSet<Simulation>(0);

	// Constructors

	/** default constructor */
	public Simdetails() {
	}

	/** minimal constructor */
	public Simdetails(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Simdetails(Integer id, Set<Simulation> results) {
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
	public Set<Simulation> getResults() {
		return this.results;
	}

	public void setResults(Set<Simulation> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "results: " + results;
	}

}
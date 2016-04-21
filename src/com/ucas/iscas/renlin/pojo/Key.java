package com.ucas.iscas.renlin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Key entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "key", catalog = "ssllabs")
public class Key implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer size;
	private Integer strength;
	private String alg;
	private Boolean debianFlaw;
	private Boolean q;

	// Constructors

	/** default constructor */
	public Key() {
	}

	/** minimal constructor */
	public Key(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Key(Integer id, Integer size, Integer strength, String alg,
			Boolean debianFlaw, Boolean q) {
		this.id = id;
		this.size = size;
		this.strength = strength;
		this.alg = alg;
		this.debianFlaw = debianFlaw;
		this.q = q;
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

	@Column(name = "size")
	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Column(name = "strength")
	public Integer getStrength() {
		return this.strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	@Column(name = "alg")
	public String getAlg() {
		return this.alg;
	}

	public void setAlg(String alg) {
		this.alg = alg;
	}

	@Column(name = "debianFlaw")
	public Boolean getDebianFlaw() {
		return this.debianFlaw;
	}

	public void setDebianFlaw(Boolean debianFlaw) {
		this.debianFlaw = debianFlaw;
	}

	@Column(name = "q")
	public Boolean getQ() {
		return this.q;
	}

	public void setQ(Boolean q) {
		this.q = q;
	}

}
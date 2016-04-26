package com.ucas.iscas.renlin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Suites entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "suites", catalog = "ssllabs")
public class Suites implements java.io.Serializable {

	// Fields

	private Integer id;
	private String list;
	private Boolean preference;

	// Constructors

	/** default constructor */
	public Suites() {
	}

	/** minimal constructor */
	public Suites(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Suites(Integer id, String list, Boolean preference) {
		this.id = id;
		this.list = list;
		this.preference = preference;
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

	@Column(name = "list", length = 65535)
	public String getList() {
		return this.list;
	}

	public void setList(String list) {
		this.list = list;
	}

	@Column(name = "preference")
	public Boolean getPreference() {
		return this.preference;
	}

	public void setPreference(Boolean preference) {
		this.preference = preference;
	}

}
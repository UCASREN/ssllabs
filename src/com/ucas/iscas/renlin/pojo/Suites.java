package com.ucas.iscas.renlin.pojo;

import java.util.List;

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
	private List<Suite> list;
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
	public Suites(Integer id, List<Suite> list, Boolean preference) {
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
	public List<Suite> getList() {
		return this.list;
	}

	public void setList(List<Suite> list) {
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
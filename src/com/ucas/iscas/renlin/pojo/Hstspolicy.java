package com.ucas.iscas.renlin.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hstspolicy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hstspolicy", catalog = "ssllabs")
public class Hstspolicy implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer LONG_MAX_AGE;
	private String header;
	private String status;
	private String error;
	private Long maxAge;
	private Boolean includeSubDomains;
	private Boolean preload;
	private Directive directives;

	// Constructors

	/** default constructor */
	public Hstspolicy() {
	}

	/** minimal constructor */
	public Hstspolicy(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Hstspolicy(Integer id, int longMaxAge, String header,
			String status, String error, Long maxAge,
			Boolean includeSubDomains, Boolean preload, Directive directives) {
		this.id = id;
		this.LONG_MAX_AGE = longMaxAge;
		this.header = header;
		this.status = status;
		this.error = error;
		this.maxAge = maxAge;
		this.includeSubDomains = includeSubDomains;
		this.preload = preload;
		this.directives = directives;
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

	@Column(name = "LONG_MAX_AGE")
	public int getLongMaxAge() {
		return this.LONG_MAX_AGE;
	}

	public void setLongMaxAge(int longMaxAge) {
		this.LONG_MAX_AGE = longMaxAge;
	}

	@Column(name = "header")
	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "error")
	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Column(name = "maxAge")
	public Long getMaxAge() {
		return this.maxAge;
	}

	public void setMaxAge(Long maxAge) {
		this.maxAge = maxAge;
	}

	@Column(name = "includeSubDomains")
	public Boolean getIncludeSubDomains() {
		return this.includeSubDomains;
	}

	public void setIncludeSubDomains(Boolean includeSubDomains) {
		this.includeSubDomains = includeSubDomains;
	}

	@Column(name = "preload")
	public Boolean getPreload() {
		return this.preload;
	}

	public void setPreload(Boolean preload) {
		this.preload = preload;
	}

	@Column(name = "directives")
	public Directive getDirectives() {
		return this.directives;
	}

	public void setDirectives(Directive directives) {
		this.directives = directives;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "LONG_MAX_AGE: " + LONG_MAX_AGE + ", header: " + header + ", status: " + status + ", error: " + error + ", maxAge" + maxAge + ", includeSubDomains: " + includeSubDomains + ", preload: " + preload;
	}
}
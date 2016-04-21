package com.ucas.iscas.renlin.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hpkppolicy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hpkppolicy", catalog = "ssllabs")
public class Hpkppolicy implements java.io.Serializable {

	// Fields

	private Integer id;
	private String status;
	private String header;
	private String error;
	private Long maxAge;
	private Boolean includeSubDomains;
	private String reportUri;
	private List<String> pins;
	private List<String> matchedPins;
	private Directive directives;

	// Constructors

	/** default constructor */
	public Hpkppolicy() {
	}

	/** minimal constructor */
	public Hpkppolicy(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Hpkppolicy(Integer id, String status, String header, String error,
			Long maxAge, Boolean includeSubDomains, String reportUri,
			List<String> pins, List<String> matchedPins, Directive directives) {
		this.id = id;
		this.status = status;
		this.header = header;
		this.error = error;
		this.maxAge = maxAge;
		this.includeSubDomains = includeSubDomains;
		this.reportUri = reportUri;
		this.pins = pins;
		this.matchedPins = matchedPins;
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

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "header")
	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
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

	@Column(name = "reportUri")
	public String getReportUri() {
		return this.reportUri;
	}

	public void setReportUri(String reportUri) {
		this.reportUri = reportUri;
	}

	@Column(name = "pins")
	public List<String> getPins() {
		return this.pins;
	}

	public void setPins(List<String> pins) {
		this.pins = pins;
	}

	@Column(name = "matchedPins")
	public List<String> getMatchedPins() {
		return this.matchedPins;
	}

	public void setMatchedPins(List<String> matchedPins) {
		this.matchedPins = matchedPins;
	}

	@Column(name = "directives")
	public Directive getDirectives() {
		return this.directives;
	}

	public void setDirectives(Directive directives) {
		this.directives = directives;
	}

}
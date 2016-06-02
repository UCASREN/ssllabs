package com.ucas.iscas.renlin.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	private Set<Pins> pins = new HashSet<Pins>(0);
	private String pinsString;
	
	private Set<Pins> matchedPins = new HashSet<Pins>(0);
	private String matchedPinsString;
	
	


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
			Set<Pins> pins, Set<Pins> matchedPins, Directive directives) {
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


/*	public Set<String> getPins() {
		return this.pins;
	}

	public void setPins(Set<String> pins) {
		this.pins = pins;
	}


	public Set<String> getMatchedPins() {
		return this.matchedPins;
	}

	public void setMatchedPins(Set<String> matchedPins) {
		this.matchedPins = matchedPins;
	}*/

	@Column(name = "directives")
	public Directive getDirectives() {
		return this.directives;
	}

	public void setDirectives(Directive directives) {
		this.directives = directives;
	}
	
	@Column(name = "pins")
	public String getPinsString() {
		return pins == null ? "" : pins.toString();
	}

	public void setPinsString(String pinsString) {
		this.pinsString = pins.toString();
	}

	@Column(name = "matchedPins")
	public String getMatchedPinsString() {
		return matchedPins == null ? "" : matchedPins.toString();
	}

	public void setMatchedPinsString(String matchedPinsString) {
		this.matchedPinsString = matchedPins.toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "status: " + status + ", header: " + header + ", error: " + error + ", maxAge: " + maxAge + ", includeSubDomains: " + includeSubDomains;
	}

}
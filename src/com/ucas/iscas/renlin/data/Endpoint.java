package com.ucas.iscas.renlin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Endpoint entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "endpoint", catalog = "ssllabs")
public class Endpoint implements java.io.Serializable {

	// Fields

	private String ipAddress;
	private Host host;
	private String serverName;
	private String statusMessage;
	private String statusDetails;
	private String statusDetailsMessage;
	private String grade;
	private String gradeTrustIgnored;
	private String hasWarnings;
	private String isExceptional;
	private String progress;
	private String duration;
	private String eta;
	private Boolean delegation;
	private String details;
	private Endpointdetails endpointdetails;

	// Constructors

	/** default constructor */
	public Endpoint() {
	}

	/** minimal constructor */
	public Endpoint(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/** full constructor */
	public Endpoint(String ipAddress, Host host, String serverName,
			String statusMessage, String statusDetails,
			String statusDetailsMessage, String grade,
			String gradeTrustIgnored, String hasWarnings, String isExceptional,
			String progress, String duration, String eta, Boolean delegation,
			String details, Endpointdetails endpointdetails) {
		this.ipAddress = ipAddress;
		this.host = host;
		this.serverName = serverName;
		this.statusMessage = statusMessage;
		this.statusDetails = statusDetails;
		this.statusDetailsMessage = statusDetailsMessage;
		this.grade = grade;
		this.gradeTrustIgnored = gradeTrustIgnored;
		this.hasWarnings = hasWarnings;
		this.isExceptional = isExceptional;
		this.progress = progress;
		this.duration = duration;
		this.eta = eta;
		this.delegation = delegation;
		this.details = details;
		this.endpointdetails = endpointdetails;
	}

	// Property accessors
	@Id
	@Column(name = "ipAddress", unique = true, nullable = false)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "host")
	public Host getHost() {
		return this.host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	@Column(name = "serverName")
	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	@Column(name = "statusMessage")
	public String getStatusMessage() {
		return this.statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Column(name = "statusDetails")
	public String getStatusDetails() {
		return this.statusDetails;
	}

	public void setStatusDetails(String statusDetails) {
		this.statusDetails = statusDetails;
	}

	@Column(name = "statusDetailsMessage")
	public String getStatusDetailsMessage() {
		return this.statusDetailsMessage;
	}

	public void setStatusDetailsMessage(String statusDetailsMessage) {
		this.statusDetailsMessage = statusDetailsMessage;
	}

	@Column(name = "grade", length = 10)
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name = "gradeTrustIgnored", length = 10)
	public String getGradeTrustIgnored() {
		return this.gradeTrustIgnored;
	}

	public void setGradeTrustIgnored(String gradeTrustIgnored) {
		this.gradeTrustIgnored = gradeTrustIgnored;
	}

	@Column(name = "hasWarnings")
	public String getHasWarnings() {
		return this.hasWarnings;
	}

	public void setHasWarnings(String hasWarnings) {
		this.hasWarnings = hasWarnings;
	}

	@Column(name = "isExceptional")
	public String getIsExceptional() {
		return this.isExceptional;
	}

	public void setIsExceptional(String isExceptional) {
		this.isExceptional = isExceptional;
	}

	@Column(name = "progress")
	public String getProgress() {
		return this.progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Column(name = "duration")
	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Column(name = "eta")
	public String getEta() {
		return this.eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	@Column(name = "delegation")
	public Boolean getDelegation() {
		return this.delegation;
	}

	public void setDelegation(Boolean delegation) {
		this.delegation = delegation;
	}

	@Column(name = "details")
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "endpoint")
	public Endpointdetails getEndpointdetails() {
		return this.endpointdetails;
	}

	public void setEndpointdetails(Endpointdetails endpointdetails) {
		this.endpointdetails = endpointdetails;
	}

}
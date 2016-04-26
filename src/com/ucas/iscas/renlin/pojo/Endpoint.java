package com.ucas.iscas.renlin.pojo;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.metamodel.source.annotations.attribute.type.LobTypeResolver;

/**
 * Endpoint entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "endpoint")
public class Endpoint implements java.io.Serializable {

	// Fields

	private Integer id;
	private String host;
	private String ipAddress;
	private String serverName;
	private String statusMessage;
	private String statusDetails;
	private String statusDetailsMessage;
	private String grade;
	private String gradeTrustIgnored;
	private Boolean hasWarnings;
	private Boolean isExceptional;
	private Short progress;
	private Integer duration;
	private Integer eta;
	private Short delegation;
	
	private Endpointdetails details_info;
	
	private String detailsString;

	// Constructors

	/** default constructor */
	public Endpoint() {
	}

	/** minimal constructor */
	public Endpoint(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Endpoint(Integer id, Host host, String ipAddress, String serverName,
			String statusMessage, String statusDetails,
			String statusDetailsMessage, String grade,
			String gradeTrustIgnored, Boolean hasWarnings,
			Boolean isExceptional, Short progress, Integer duration,
			Integer eta, Short delegation, Endpointdetails details_info) {
		this.id = id;
		this.host = host.getHost();
		this.ipAddress = ipAddress;
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
		this.details_info = details_info;
		this.detailsString = details_info.toString();
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

/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "host_id")*/
	@Column(name = "host")
	public String getHost() {
		return this.host;
	}

	public void setHost(Host host) {
		this.host = host.getHost();
	}

	@Column(name = "ipAddress")
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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
	public Boolean getHasWarnings() {
		return this.hasWarnings;
	}

	public void setHasWarnings(Boolean hasWarnings) {
		this.hasWarnings = hasWarnings;
	}

	@Column(name = "isExceptional")
	public Boolean getIsExceptional() {
		return this.isExceptional;
	}

	public void setIsExceptional(Boolean isExceptional) {
		this.isExceptional = isExceptional;
	}

	@Column(name = "progress")
	public Short getProgress() {
		return this.progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "eta")
	public Integer getEta() {
		return this.eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	@Column(name = "delegation")
	public Short getDelegation() {
		return this.delegation;
	}

	public void setDelegation(Short delegation) {
		this.delegation = delegation;
	}

/*    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="endpointdetails_id")*/
	public Endpointdetails getDetails_info() {
		return details_info;
	}

	public void setDetails_info(Endpointdetails details_info) {
		this.details_info = details_info;
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="details_info", columnDefinition="TEXT")
	public String getDetailsString() {
		return detailsString;
	}
	public void setDetailsString() {
		this.detailsString = details_info.toString();
	}

}
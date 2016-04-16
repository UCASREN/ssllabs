package com.ucas.iscas.renlin.data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Host entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "host", catalog = "ssllabs")
public class Host implements java.io.Serializable {

	// Fields

	private String host;
	private String port;
	private String protocol;
	private Boolean isPublic;
	private Boolean status;
	private String statusMessage;
	private String startTime;
	private String testTime;
	private String engineVersion;
	private String criteriaVersion;
	private String cacheExpiryTime;
	private String endpoints;
	private String certHostnames;
	private Set<Endpoint> endpoints_1 = new HashSet<Endpoint>(0);

	// Constructors

	/** default constructor */
	public Host() {
	}

	/** minimal constructor */
	public Host(String host) {
		this.host = host;
	}

	/** full constructor */
	public Host(String host, String port, String protocol, Boolean isPublic,
			Boolean status, String statusMessage, String startTime,
			String testTime, String engineVersion, String criteriaVersion,
			String cacheExpiryTime, String endpoints, String certHostnames,
			Set<Endpoint> endpoints_1) {
		this.host = host;
		this.port = port;
		this.protocol = protocol;
		this.isPublic = isPublic;
		this.status = status;
		this.statusMessage = statusMessage;
		this.startTime = startTime;
		this.testTime = testTime;
		this.engineVersion = engineVersion;
		this.criteriaVersion = criteriaVersion;
		this.cacheExpiryTime = cacheExpiryTime;
		this.endpoints = endpoints;
		this.certHostnames = certHostnames;
		this.endpoints_1 = endpoints_1;
	}

	// Property accessors
	@Id
	@Column(name = "host", unique = true, nullable = false)
	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Column(name = "port")
	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Column(name = "protocol")
	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Column(name = "isPublic")
	public Boolean getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name = "statusMessage", length = 1000)
	public String getStatusMessage() {
		return this.statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Column(name = "startTime")
	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "testTime")
	public String getTestTime() {
		return this.testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}

	@Column(name = "engineVersion")
	public String getEngineVersion() {
		return this.engineVersion;
	}

	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}

	@Column(name = "criteriaVersion")
	public String getCriteriaVersion() {
		return this.criteriaVersion;
	}

	public void setCriteriaVersion(String criteriaVersion) {
		this.criteriaVersion = criteriaVersion;
	}

	@Column(name = "cacheExpiryTime")
	public String getCacheExpiryTime() {
		return this.cacheExpiryTime;
	}

	public void setCacheExpiryTime(String cacheExpiryTime) {
		this.cacheExpiryTime = cacheExpiryTime;
	}

	@Column(name = "endpoints")
	public String getEndpoints() {
		return this.endpoints;
	}

	public void setEndpoints(String endpoints) {
		this.endpoints = endpoints;
	}

	@Column(name = "certHostnames", length = 65535)
	public String getCertHostnames() {
		return this.certHostnames;
	}

	public void setCertHostnames(String certHostnames) {
		this.certHostnames = certHostnames;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "host")
	public Set<Endpoint> getEndpoints_1() {
		return this.endpoints_1;
	}

	public void setEndpoints_1(Set<Endpoint> endpoints_1) {
		this.endpoints_1 = endpoints_1;
	}

}
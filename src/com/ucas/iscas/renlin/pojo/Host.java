package com.ucas.iscas.renlin.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

/**
 * Host entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "host")
public class Host implements java.io.Serializable {

	// Fields

	private Integer id;
	private String host;
	private Integer port;
	private String protocol;
	private Boolean isPublic;
	private String status;
	private String statusMessage;
	private Long startTime;
	private Long testTime;
	private String engineVersion;
	private String criteriaVersion;
	private Long cacheExpiryTime;
	
	private Set<Endpoint> endpoints = new HashSet<Endpoint>(0);
	private String endpointsString;
	
	private Set<String> certHostnames = new HashSet<String>(0);
	private String certHostnameString;


	// Constructors

	/** default constructor */
	public Host() {
	}

	/** minimal constructor */
	public Host(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Host(Integer id, String host, Integer port, String protocol,
			Boolean isPublic, String status, String statusMessage,
			Long startTime, Long testTime, String engineVersion,
			String criteriaVersion, Long cacheExpiryTime, Set<Endpoint> endpoints,
			Set<String> certHostnames) {
		super();
		this.id = id;
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
		this.endpointsString = endpoints.toString();
		this.certHostnameString = certHostnames.toString();
	}


	
	//@OneToMany(targetEntity=Endpoint.class, fetch=FetchType.EAGER)
	@ElementCollection(targetClass=Endpoint.class)
	public Set<Endpoint> getEndpoints() {
		return this.endpoints;
	}

	public void setEndpoints(Set<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	
	public Set<String> getCertHostnames() {
		return this.certHostnames;
	}
	public void setCertHostnames(Set<String> certHostnames) {
		this.certHostnames = certHostnames;
	}
	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "host")
	public String getHost() {
		return this.host;
	}
	public void setHost(String host) {
		this.host = host;
	}

	@Column(name = "port")
	public Integer getPort() {
		return this.port;
	}
	public void setPort(Integer port) {
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
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
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
	public Long getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	@Column(name = "testTime")
	public Long getTestTime() {
		return this.testTime;
	}

	public void setTestTime(Long testTime) {
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
	public Long getCacheExpiryTime() {
		return this.cacheExpiryTime;
	}

	public void setCacheExpiryTime(Long cacheExpiryTime) {
		this.cacheExpiryTime = cacheExpiryTime;
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "endpoints", columnDefinition="LONGTEXT")
	public String getEndpointsString() {
		return endpointsString;
	}
	public void setEndpointsString(Set<Endpoint> endpoints) {
		this.endpointsString = endpoints.toString();
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "certHostnames", columnDefinition="TEXT")
	public String getCertHostnameString() {
		return certHostnameString;
	}
	public void setCertHostnameString(Set<String> certHostnames) {
		this.certHostnameString = certHostnames.toString();
	}
	
	

}
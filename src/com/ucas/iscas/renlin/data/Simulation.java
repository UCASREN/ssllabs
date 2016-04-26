package com.ucas.iscas.renlin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simulation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "simulation", catalog = "ssllabs")
public class Simulation implements java.io.Serializable {

	// Fields

	private Integer id;
	private String client;
	private Boolean errorCode;
	private Boolean attempts;
	private Integer protocolId;
	private Integer suiteId;

	// Constructors

	/** default constructor */
	public Simulation() {
	}

	/** minimal constructor */
	public Simulation(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Simulation(Integer id, String client, Boolean errorCode,
			Boolean attempts, Integer protocolId, Integer suiteId) {
		this.id = id;
		this.client = client;
		this.errorCode = errorCode;
		this.attempts = attempts;
		this.protocolId = protocolId;
		this.suiteId = suiteId;
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

	@Column(name = "client")
	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Column(name = "errorCode")
	public Boolean getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(Boolean errorCode) {
		this.errorCode = errorCode;
	}

	@Column(name = "attempts")
	public Boolean getAttempts() {
		return this.attempts;
	}

	public void setAttempts(Boolean attempts) {
		this.attempts = attempts;
	}

	@Column(name = "protocolId")
	public Integer getProtocolId() {
		return this.protocolId;
	}

	public void setProtocolId(Integer protocolId) {
		this.protocolId = protocolId;
	}

	@Column(name = "suiteId")
	public Integer getSuiteId() {
		return this.suiteId;
	}

	public void setSuiteId(Integer suiteId) {
		this.suiteId = suiteId;
	}

}
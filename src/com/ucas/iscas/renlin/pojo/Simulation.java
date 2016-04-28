package com.ucas.iscas.renlin.pojo;

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
	private Simclient client;
	private Integer errorCode;
	private Integer attempts;
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
	public Simulation(Integer id, Simclient client, Integer errorCode,
			Integer attempts, Integer protocolId, Integer suiteId) {
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
	public Simclient getClient() {
		return this.client;
	}

	public void setClient(Simclient client) {
		this.client = client;
	}

	@Column(name = "errorCode")
	public Integer getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	@Column(name = "attempts")
	public Integer getAttempts() {
		return this.attempts;
	}

	public void setAttempts(Integer attempts) {
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "client: " + client + ", errorCode: " + errorCode + ", protocolld: " + protocolId + ", suiteId: " + suiteId;
	}

}
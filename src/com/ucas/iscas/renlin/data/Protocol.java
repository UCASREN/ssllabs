package com.ucas.iscas.renlin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Protocol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "protocol", catalog = "ssllabs")
public class Protocol implements java.io.Serializable {

	// Fields

	private Integer iid;
	private String version;
	private Integer id;
	private Boolean v2suitesDisabled;
	private Boolean q;

	// Constructors

	/** default constructor */
	public Protocol() {
	}

	/** minimal constructor */
	public Protocol(Integer iid) {
		this.iid = iid;
	}

	/** full constructor */
	public Protocol(Integer iid, Integer id, Boolean v2suitesDisabled, Boolean q) {
		this.iid = iid;
		this.id = id;
		this.v2suitesDisabled = v2suitesDisabled;
		this.q = q;
	}

	// Property accessors
	@Id
	@Column(name = "iid", unique = true, nullable = false)
	public Integer getIid() {
		return this.iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	@Version
	@Column(name = "version")
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "v2SuitesDisabled")
	public Boolean getV2suitesDisabled() {
		return this.v2suitesDisabled;
	}

	public void setV2suitesDisabled(Boolean v2suitesDisabled) {
		this.v2suitesDisabled = v2suitesDisabled;
	}

	@Column(name = "q")
	public Boolean getQ() {
		return this.q;
	}

	public void setQ(Boolean q) {
		this.q = q;
	}

}
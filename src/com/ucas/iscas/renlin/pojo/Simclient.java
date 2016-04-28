package com.ucas.iscas.renlin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Simclient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "simclient")
public class Simclient implements java.io.Serializable {

	// Fields

	private Integer iid;
	private String version;
	private Integer id;
	private String name;
	private String platform;
	private Boolean isReference;

	// Constructors

	/** default constructor */
	public Simclient() {
	}

	/** minimal constructor */
	public Simclient(Integer iid) {
		this.iid = iid;
	}

	/** full constructor */
	public Simclient(Integer iid, Integer id, String name, String platform,
			Boolean isReference) {
		this.iid = iid;
		this.id = id;
		this.name = name;
		this.platform = platform;
		this.isReference = isReference;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "platform")
	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Column(name = "isReference")
	public Boolean getIsReference() {
		return this.isReference;
	}

	public void setIsReference(Boolean isReference) {
		this.isReference = isReference;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: " + name + ", platform: " + platform + ", version: " + version + ", isReference: " + isReference;
	}
}
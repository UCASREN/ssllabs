package com.ucas.iscas.renlin.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hstspreload entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hstspreload", catalog = "ssllabs")
public class Hstspreload implements java.io.Serializable {

	// Fields

	private Integer id;
	private String hostname;
	private String source;
	private String status;
	private String error;
	private Long sourceTime;

	// Constructors

	/** default constructor */
	public Hstspreload() {
	}

	/** minimal constructor */
	public Hstspreload(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Hstspreload(Integer id, String hostname, String source,
			String status, String error, long sourceTime) {
		this.id = id;
		this.hostname = hostname;
		this.source = source;
		this.status = status;
		this.error = error;
		this.sourceTime = sourceTime;
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

	@Column(name = "hostname")
	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	@Column(name = "source")
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "error")
	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Column(name = "sourceTime", length = 19)
	public long getSourceTime() {
		return this.sourceTime;
	}

	public void setSourceTime(long sourceTime) {
		this.sourceTime = sourceTime;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "source: " + source + ", status: " + status + ", error: " + error + ", sourceTime: " + sourceTime;
	}
}
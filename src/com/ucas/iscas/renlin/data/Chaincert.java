package com.ucas.iscas.renlin.data;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Chaincert entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "chaincert", catalog = "ssllabs")
public class Chaincert implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subject;
	private String label;
	private Timestamp notBefore;
	private Timestamp notAfter;
	private String issuerSubject;
	private String issuerLabel;
	private String sigAlg;
	private Short issues;
	private String keyAlg;
	private Integer keySize;
	private Integer keyStrength;
	private Boolean revocationStatus;
	private Boolean crlRevocationStatus;
	private Boolean ocspRevocationStatus;
	private String raw;

	// Constructors

	/** default constructor */
	public Chaincert() {
	}

	/** minimal constructor */
	public Chaincert(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Chaincert(Integer id, String subject, String label,
			Timestamp notBefore, Timestamp notAfter, String issuerSubject,
			String issuerLabel, String sigAlg, Short issues, String keyAlg,
			Integer keySize, Integer keyStrength, Boolean revocationStatus,
			Boolean crlRevocationStatus, Boolean ocspRevocationStatus,
			String raw) {
		this.id = id;
		this.subject = subject;
		this.label = label;
		this.notBefore = notBefore;
		this.notAfter = notAfter;
		this.issuerSubject = issuerSubject;
		this.issuerLabel = issuerLabel;
		this.sigAlg = sigAlg;
		this.issues = issues;
		this.keyAlg = keyAlg;
		this.keySize = keySize;
		this.keyStrength = keyStrength;
		this.revocationStatus = revocationStatus;
		this.crlRevocationStatus = crlRevocationStatus;
		this.ocspRevocationStatus = ocspRevocationStatus;
		this.raw = raw;
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

	@Column(name = "subject")
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "label")
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "notBefore", length = 19)
	public Timestamp getNotBefore() {
		return this.notBefore;
	}

	public void setNotBefore(Timestamp notBefore) {
		this.notBefore = notBefore;
	}

	@Column(name = "notAfter", length = 19)
	public Timestamp getNotAfter() {
		return this.notAfter;
	}

	public void setNotAfter(Timestamp notAfter) {
		this.notAfter = notAfter;
	}

	@Column(name = "issuerSubject")
	public String getIssuerSubject() {
		return this.issuerSubject;
	}

	public void setIssuerSubject(String issuerSubject) {
		this.issuerSubject = issuerSubject;
	}

	@Column(name = "issuerLabel")
	public String getIssuerLabel() {
		return this.issuerLabel;
	}

	public void setIssuerLabel(String issuerLabel) {
		this.issuerLabel = issuerLabel;
	}

	@Column(name = "sigAlg")
	public String getSigAlg() {
		return this.sigAlg;
	}

	public void setSigAlg(String sigAlg) {
		this.sigAlg = sigAlg;
	}

	@Column(name = "issues")
	public Short getIssues() {
		return this.issues;
	}

	public void setIssues(Short issues) {
		this.issues = issues;
	}

	@Column(name = "keyAlg")
	public String getKeyAlg() {
		return this.keyAlg;
	}

	public void setKeyAlg(String keyAlg) {
		this.keyAlg = keyAlg;
	}

	@Column(name = "keySize")
	public Integer getKeySize() {
		return this.keySize;
	}

	public void setKeySize(Integer keySize) {
		this.keySize = keySize;
	}

	@Column(name = "keyStrength")
	public Integer getKeyStrength() {
		return this.keyStrength;
	}

	public void setKeyStrength(Integer keyStrength) {
		this.keyStrength = keyStrength;
	}

	@Column(name = "revocationStatus")
	public Boolean getRevocationStatus() {
		return this.revocationStatus;
	}

	public void setRevocationStatus(Boolean revocationStatus) {
		this.revocationStatus = revocationStatus;
	}

	@Column(name = "crlRevocationStatus")
	public Boolean getCrlRevocationStatus() {
		return this.crlRevocationStatus;
	}

	public void setCrlRevocationStatus(Boolean crlRevocationStatus) {
		this.crlRevocationStatus = crlRevocationStatus;
	}

	@Column(name = "ocspRevocationStatus")
	public Boolean getOcspRevocationStatus() {
		return this.ocspRevocationStatus;
	}

	public void setOcspRevocationStatus(Boolean ocspRevocationStatus) {
		this.ocspRevocationStatus = ocspRevocationStatus;
	}

	@Column(name = "raw", length = 65535)
	public String getRaw() {
		return this.raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

}
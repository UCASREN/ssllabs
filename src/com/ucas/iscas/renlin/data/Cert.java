package com.ucas.iscas.renlin.data;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cert entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cert", catalog = "ssllabs")
public class Cert implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subject;
	private String commonNames;
	private String altNames;
	private Timestamp notBefore;
	private Timestamp notAfter;
	private String issuerSubject;
	private String sigAlg;
	private String issuerLabel;
	private Boolean revocationInfo;
	private String crlUris;
	private String ocspUris;
	private Boolean revocationStatus;
	private Boolean crlRevocationStatus;
	private Boolean ocspRevocationStatus;
	private Boolean sgc;
	private String validationType;
	private Short issues;
	private Boolean sct;

	// Constructors

	/** default constructor */
	public Cert() {
	}

	/** minimal constructor */
	public Cert(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Cert(Integer id, String subject, String commonNames,
			String altNames, Timestamp notBefore, Timestamp notAfter,
			String issuerSubject, String sigAlg, String issuerLabel,
			Boolean revocationInfo, String crlUris, String ocspUris,
			Boolean revocationStatus, Boolean crlRevocationStatus,
			Boolean ocspRevocationStatus, Boolean sgc, String validationType,
			Short issues, Boolean sct) {
		this.id = id;
		this.subject = subject;
		this.commonNames = commonNames;
		this.altNames = altNames;
		this.notBefore = notBefore;
		this.notAfter = notAfter;
		this.issuerSubject = issuerSubject;
		this.sigAlg = sigAlg;
		this.issuerLabel = issuerLabel;
		this.revocationInfo = revocationInfo;
		this.crlUris = crlUris;
		this.ocspUris = ocspUris;
		this.revocationStatus = revocationStatus;
		this.crlRevocationStatus = crlRevocationStatus;
		this.ocspRevocationStatus = ocspRevocationStatus;
		this.sgc = sgc;
		this.validationType = validationType;
		this.issues = issues;
		this.sct = sct;
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

	@Column(name = "commonNames")
	public String getCommonNames() {
		return this.commonNames;
	}

	public void setCommonNames(String commonNames) {
		this.commonNames = commonNames;
	}

	@Column(name = "altNames")
	public String getAltNames() {
		return this.altNames;
	}

	public void setAltNames(String altNames) {
		this.altNames = altNames;
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

	@Column(name = "sigAlg")
	public String getSigAlg() {
		return this.sigAlg;
	}

	public void setSigAlg(String sigAlg) {
		this.sigAlg = sigAlg;
	}

	@Column(name = "issuerLabel")
	public String getIssuerLabel() {
		return this.issuerLabel;
	}

	public void setIssuerLabel(String issuerLabel) {
		this.issuerLabel = issuerLabel;
	}

	@Column(name = "revocationInfo")
	public Boolean getRevocationInfo() {
		return this.revocationInfo;
	}

	public void setRevocationInfo(Boolean revocationInfo) {
		this.revocationInfo = revocationInfo;
	}

	@Column(name = "crlURIs")
	public String getCrlUris() {
		return this.crlUris;
	}

	public void setCrlUris(String crlUris) {
		this.crlUris = crlUris;
	}

	@Column(name = "ocspURIs")
	public String getOcspUris() {
		return this.ocspUris;
	}

	public void setOcspUris(String ocspUris) {
		this.ocspUris = ocspUris;
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

	@Column(name = "sgc")
	public Boolean getSgc() {
		return this.sgc;
	}

	public void setSgc(Boolean sgc) {
		this.sgc = sgc;
	}

	@Column(name = "validationType")
	public String getValidationType() {
		return this.validationType;
	}

	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}

	@Column(name = "issues")
	public Short getIssues() {
		return this.issues;
	}

	public void setIssues(Short issues) {
		this.issues = issues;
	}

	@Column(name = "sct")
	public Boolean getSct() {
		return this.sct;
	}

	public void setSct(Boolean sct) {
		this.sct = sct;
	}

}
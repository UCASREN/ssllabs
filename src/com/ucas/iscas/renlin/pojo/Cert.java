package com.ucas.iscas.renlin.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private Set<String> commonNames = new HashSet<String>(0);
	private Set<String> altNames = new HashSet<String>();
	private long notBefore;
	private long notAfter;
	private String issuerSubject;
	private String sigAlg;
	private String issuerLabel;
	private Short revocationInfo;
	private Set<String> crlURIs = new HashSet<String>(0);
	private Set<String> ocspURIs = new HashSet<String>(0);
	private Short revocationStatus;
	private Short crlRevocationStatus;
	private Short ocspRevocationStatus;
	private Integer sgc;
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
	public Cert(Integer id, String subject, Set<String> commonNames,
			Set<String> altNames, long notBefore, long notAfter,
			String issuerSubject, String sigAlg, String issuerLabel,
			Short revocationInfo, Set<String> crlURIs, Set<String> ocspURIs,
			Short revocationStatus, Short crlRevocationStatus,
			Short ocspRevocationStatus, Integer sgc, String validationType,
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
		this.crlURIs = crlURIs;
		this.ocspURIs = ocspURIs;
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
	public Set<String> getCommonNames() {
		return this.commonNames;
	}

	public void setCommonNames(Set<String> commonNames) {
		this.commonNames = commonNames;
	}

	@Column(name = "altNames")
	public Set<String> getAltNames() {
		return this.altNames;
	}

	public void setAltNames(Set<String> altNames) {
		this.altNames = altNames;
	}

	@Column(name = "notBefore", length = 19)
	public long getNotBefore() {
		return this.notBefore;
	}

	public void setNotBefore(long notBefore) {
		this.notBefore = notBefore;
	}

	@Column(name = "notAfter", length = 19)
	public long getNotAfter() {
		return this.notAfter;
	}

	public void setNotAfter(long notAfter) {
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
	public Short getRevocationInfo() {
		return this.revocationInfo;
	}

	public void setRevocationInfo(Short revocationInfo) {
		this.revocationInfo = revocationInfo;
	}

	@Column(name = "crlURIs")
	public Set<String> getCrlUris() {
		return this.crlURIs;
	}

	public void setCrlURIs(Set<String> crlURIs) {
		this.crlURIs = crlURIs;
	}

	@Column(name = "ocspURIs")
	public Set<String> getOcspURIs() {
		return this.ocspURIs;
	}

	public void setOcspURIs(Set<String> ocspURIs) {
		this.ocspURIs = ocspURIs;
	}

	@Column(name = "revocationStatus")
	public Short getRevocationStatus() {
		return this.revocationStatus;
	}

	public void setRevocationStatus(Short revocationStatus) {
		this.revocationStatus = revocationStatus;
	}

	@Column(name = "crlRevocationStatus")
	public Short getCrlRevocationStatus() {
		return this.crlRevocationStatus;
	}

	public void setCrlRevocationStatus(Short crlRevocationStatus) {
		this.crlRevocationStatus = crlRevocationStatus;
	}

	@Column(name = "ocspRevocationStatus")
	public Short getOcspRevocationStatus() {
		return this.ocspRevocationStatus;
	}

	public void setOcspRevocationStatus(Short ocspRevocationStatus) {
		this.ocspRevocationStatus = ocspRevocationStatus;
	}

	@Column(name = "sgc")
	public Integer getSgc() {
		return this.sgc;
	}

	public void setSgc(Integer sgc) {
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "subject: " + subject + ", commonNames: " + commonNames + ", altNames: " + altNames + ", notBefore: " + notBefore + ", notAfter: " + notAfter + ", issuerSubject: " + issuerSubject +
				", sigAlg: " + sigAlg + ", revocationInfo: " + revocationInfo + ", revocatioStatus: " + revocationStatus + ", validationType: " +  validationType + ", issues: " + issues;
	}

}
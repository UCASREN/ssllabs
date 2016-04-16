package com.ucas.iscas.renlin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Endpointdetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "endpointdetails", catalog = "ssllabs")
public class Endpointdetails implements java.io.Serializable {

	// Fields

	private String ipAddress;
	private Endpoint endpoint;
	private String hostStartTime;
	private String key;
	private String cert;
	private String chain;
	private String protocols;
	private String suites;
	private String serverSignature;
	private Boolean prefixDelegation;
	private Boolean nonPrefixDelegation;
	private Boolean vulnBeast;
	private Boolean renegSupport;
	private Boolean sessionResumption;
	private Integer compressionMethods;
	private Boolean supportsNpn;
	private String npnProtocols;
	private Boolean sessionTickes;
	private Boolean ocspStapling;
	private Boolean staplingRevocationStatus;
	private String staplingRevocationErrorMessage;
	private Boolean sniRequired;
	private String httpStatusCode;
	private String httpForwarding;
	private Boolean supportsRc4;
	private Boolean rc4withModern;
	private Boolean rc4only;
	private Boolean forwardSecrecy;
	private String sims;
	private Boolean heartbleed;
	private Boolean heartbeat;
	private Boolean openSslCcs;
	private Boolean poodle;
	private Boolean poodleTls;
	private Boolean fallbackScsv;
	private Boolean freak;
	private Boolean hasSct;
	private String dhPrimes;
	private Boolean dhUsesKnownPrimes;
	private Boolean dhYsReuse;
	private Boolean logjam;
	private Boolean chaCha20preference;
	private String hstsPolicy;
	private String hstsPreloads;
	private String hpkpPolicy;
	private String hpkpRoPolicy;

	// Constructors

	/** default constructor */
	public Endpointdetails() {
	}

	/** minimal constructor */
	public Endpointdetails(String ipAddress, Endpoint endpoint) {
		this.ipAddress = ipAddress;
		this.endpoint = endpoint;
	}

	/** full constructor */
	public Endpointdetails(String ipAddress, Endpoint endpoint,
			String hostStartTime, String key, String cert, String chain,
			String protocols, String suites, String serverSignature,
			Boolean prefixDelegation, Boolean nonPrefixDelegation,
			Boolean vulnBeast, Boolean renegSupport, Boolean sessionResumption,
			Integer compressionMethods, Boolean supportsNpn,
			String npnProtocols, Boolean sessionTickes, Boolean ocspStapling,
			Boolean staplingRevocationStatus,
			String staplingRevocationErrorMessage, Boolean sniRequired,
			String httpStatusCode, String httpForwarding, Boolean supportsRc4,
			Boolean rc4withModern, Boolean rc4only, Boolean forwardSecrecy,
			String sims, Boolean heartbleed, Boolean heartbeat,
			Boolean openSslCcs, Boolean poodle, Boolean poodleTls,
			Boolean fallbackScsv, Boolean freak, Boolean hasSct,
			String dhPrimes, Boolean dhUsesKnownPrimes, Boolean dhYsReuse,
			Boolean logjam, Boolean chaCha20preference, String hstsPolicy,
			String hstsPreloads, String hpkpPolicy, String hpkpRoPolicy) {
		this.ipAddress = ipAddress;
		this.endpoint = endpoint;
		this.hostStartTime = hostStartTime;
		this.key = key;
		this.cert = cert;
		this.chain = chain;
		this.protocols = protocols;
		this.suites = suites;
		this.serverSignature = serverSignature;
		this.prefixDelegation = prefixDelegation;
		this.nonPrefixDelegation = nonPrefixDelegation;
		this.vulnBeast = vulnBeast;
		this.renegSupport = renegSupport;
		this.sessionResumption = sessionResumption;
		this.compressionMethods = compressionMethods;
		this.supportsNpn = supportsNpn;
		this.npnProtocols = npnProtocols;
		this.sessionTickes = sessionTickes;
		this.ocspStapling = ocspStapling;
		this.staplingRevocationStatus = staplingRevocationStatus;
		this.staplingRevocationErrorMessage = staplingRevocationErrorMessage;
		this.sniRequired = sniRequired;
		this.httpStatusCode = httpStatusCode;
		this.httpForwarding = httpForwarding;
		this.supportsRc4 = supportsRc4;
		this.rc4withModern = rc4withModern;
		this.rc4only = rc4only;
		this.forwardSecrecy = forwardSecrecy;
		this.sims = sims;
		this.heartbleed = heartbleed;
		this.heartbeat = heartbeat;
		this.openSslCcs = openSslCcs;
		this.poodle = poodle;
		this.poodleTls = poodleTls;
		this.fallbackScsv = fallbackScsv;
		this.freak = freak;
		this.hasSct = hasSct;
		this.dhPrimes = dhPrimes;
		this.dhUsesKnownPrimes = dhUsesKnownPrimes;
		this.dhYsReuse = dhYsReuse;
		this.logjam = logjam;
		this.chaCha20preference = chaCha20preference;
		this.hstsPolicy = hstsPolicy;
		this.hstsPreloads = hstsPreloads;
		this.hpkpPolicy = hpkpPolicy;
		this.hpkpRoPolicy = hpkpRoPolicy;
	}

	// Property accessors
	@Id
	@Column(name = "ipAddress", unique = true, nullable = false)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Endpoint getEndpoint() {
		return this.endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	@Column(name = "hostStartTime")
	public String getHostStartTime() {
		return this.hostStartTime;
	}

	public void setHostStartTime(String hostStartTime) {
		this.hostStartTime = hostStartTime;
	}

	@Column(name = "key")
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "cert", length = 65535)
	public String getCert() {
		return this.cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	@Column(name = "chain")
	public String getChain() {
		return this.chain;
	}

	public void setChain(String chain) {
		this.chain = chain;
	}

	@Column(name = "protocols")
	public String getProtocols() {
		return this.protocols;
	}

	public void setProtocols(String protocols) {
		this.protocols = protocols;
	}

	@Column(name = "suites", length = 65535)
	public String getSuites() {
		return this.suites;
	}

	public void setSuites(String suites) {
		this.suites = suites;
	}

	@Column(name = "serverSignature")
	public String getServerSignature() {
		return this.serverSignature;
	}

	public void setServerSignature(String serverSignature) {
		this.serverSignature = serverSignature;
	}

	@Column(name = "prefixDelegation")
	public Boolean getPrefixDelegation() {
		return this.prefixDelegation;
	}

	public void setPrefixDelegation(Boolean prefixDelegation) {
		this.prefixDelegation = prefixDelegation;
	}

	@Column(name = "nonPrefixDelegation")
	public Boolean getNonPrefixDelegation() {
		return this.nonPrefixDelegation;
	}

	public void setNonPrefixDelegation(Boolean nonPrefixDelegation) {
		this.nonPrefixDelegation = nonPrefixDelegation;
	}

	@Column(name = "vulnBeast")
	public Boolean getVulnBeast() {
		return this.vulnBeast;
	}

	public void setVulnBeast(Boolean vulnBeast) {
		this.vulnBeast = vulnBeast;
	}

	@Column(name = "renegSupport")
	public Boolean getRenegSupport() {
		return this.renegSupport;
	}

	public void setRenegSupport(Boolean renegSupport) {
		this.renegSupport = renegSupport;
	}

	@Column(name = "sessionResumption")
	public Boolean getSessionResumption() {
		return this.sessionResumption;
	}

	public void setSessionResumption(Boolean sessionResumption) {
		this.sessionResumption = sessionResumption;
	}

	@Column(name = "compressionMethods")
	public Integer getCompressionMethods() {
		return this.compressionMethods;
	}

	public void setCompressionMethods(Integer compressionMethods) {
		this.compressionMethods = compressionMethods;
	}

	@Column(name = "supportsNpn")
	public Boolean getSupportsNpn() {
		return this.supportsNpn;
	}

	public void setSupportsNpn(Boolean supportsNpn) {
		this.supportsNpn = supportsNpn;
	}

	@Column(name = "npnProtocols")
	public String getNpnProtocols() {
		return this.npnProtocols;
	}

	public void setNpnProtocols(String npnProtocols) {
		this.npnProtocols = npnProtocols;
	}

	@Column(name = "sessionTickes")
	public Boolean getSessionTickes() {
		return this.sessionTickes;
	}

	public void setSessionTickes(Boolean sessionTickes) {
		this.sessionTickes = sessionTickes;
	}

	@Column(name = "ocspStapling")
	public Boolean getOcspStapling() {
		return this.ocspStapling;
	}

	public void setOcspStapling(Boolean ocspStapling) {
		this.ocspStapling = ocspStapling;
	}

	@Column(name = "staplingRevocationStatus")
	public Boolean getStaplingRevocationStatus() {
		return this.staplingRevocationStatus;
	}

	public void setStaplingRevocationStatus(Boolean staplingRevocationStatus) {
		this.staplingRevocationStatus = staplingRevocationStatus;
	}

	@Column(name = "staplingRevocationErrorMessage")
	public String getStaplingRevocationErrorMessage() {
		return this.staplingRevocationErrorMessage;
	}

	public void setStaplingRevocationErrorMessage(
			String staplingRevocationErrorMessage) {
		this.staplingRevocationErrorMessage = staplingRevocationErrorMessage;
	}

	@Column(name = "sniRequired")
	public Boolean getSniRequired() {
		return this.sniRequired;
	}

	public void setSniRequired(Boolean sniRequired) {
		this.sniRequired = sniRequired;
	}

	@Column(name = " httpStatusCode")
	public String getHttpStatusCode() {
		return this.httpStatusCode;
	}

	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	@Column(name = "httpForwarding")
	public String getHttpForwarding() {
		return this.httpForwarding;
	}

	public void setHttpForwarding(String httpForwarding) {
		this.httpForwarding = httpForwarding;
	}

	@Column(name = "supportsRc4")
	public Boolean getSupportsRc4() {
		return this.supportsRc4;
	}

	public void setSupportsRc4(Boolean supportsRc4) {
		this.supportsRc4 = supportsRc4;
	}

	@Column(name = "rc4WithModern")
	public Boolean getRc4withModern() {
		return this.rc4withModern;
	}

	public void setRc4withModern(Boolean rc4withModern) {
		this.rc4withModern = rc4withModern;
	}

	@Column(name = "rc4Only")
	public Boolean getRc4only() {
		return this.rc4only;
	}

	public void setRc4only(Boolean rc4only) {
		this.rc4only = rc4only;
	}

	@Column(name = "forwardSecrecy")
	public Boolean getForwardSecrecy() {
		return this.forwardSecrecy;
	}

	public void setForwardSecrecy(Boolean forwardSecrecy) {
		this.forwardSecrecy = forwardSecrecy;
	}

	@Column(name = "sims")
	public String getSims() {
		return this.sims;
	}

	public void setSims(String sims) {
		this.sims = sims;
	}

	@Column(name = "heartbleed")
	public Boolean getHeartbleed() {
		return this.heartbleed;
	}

	public void setHeartbleed(Boolean heartbleed) {
		this.heartbleed = heartbleed;
	}

	@Column(name = "heartbeat")
	public Boolean getHeartbeat() {
		return this.heartbeat;
	}

	public void setHeartbeat(Boolean heartbeat) {
		this.heartbeat = heartbeat;
	}

	@Column(name = "openSslCcs")
	public Boolean getOpenSslCcs() {
		return this.openSslCcs;
	}

	public void setOpenSslCcs(Boolean openSslCcs) {
		this.openSslCcs = openSslCcs;
	}

	@Column(name = "poodle")
	public Boolean getPoodle() {
		return this.poodle;
	}

	public void setPoodle(Boolean poodle) {
		this.poodle = poodle;
	}

	@Column(name = "poodleTls")
	public Boolean getPoodleTls() {
		return this.poodleTls;
	}

	public void setPoodleTls(Boolean poodleTls) {
		this.poodleTls = poodleTls;
	}

	@Column(name = "fallbackScsv")
	public Boolean getFallbackScsv() {
		return this.fallbackScsv;
	}

	public void setFallbackScsv(Boolean fallbackScsv) {
		this.fallbackScsv = fallbackScsv;
	}

	@Column(name = "freak")
	public Boolean getFreak() {
		return this.freak;
	}

	public void setFreak(Boolean freak) {
		this.freak = freak;
	}

	@Column(name = "hasSct")
	public Boolean getHasSct() {
		return this.hasSct;
	}

	public void setHasSct(Boolean hasSct) {
		this.hasSct = hasSct;
	}

	@Column(name = "dhPrimes", length = 65535)
	public String getDhPrimes() {
		return this.dhPrimes;
	}

	public void setDhPrimes(String dhPrimes) {
		this.dhPrimes = dhPrimes;
	}

	@Column(name = "dhUsesKnownPrimes")
	public Boolean getDhUsesKnownPrimes() {
		return this.dhUsesKnownPrimes;
	}

	public void setDhUsesKnownPrimes(Boolean dhUsesKnownPrimes) {
		this.dhUsesKnownPrimes = dhUsesKnownPrimes;
	}

	@Column(name = "dhYsReuse")
	public Boolean getDhYsReuse() {
		return this.dhYsReuse;
	}

	public void setDhYsReuse(Boolean dhYsReuse) {
		this.dhYsReuse = dhYsReuse;
	}

	@Column(name = "logjam")
	public Boolean getLogjam() {
		return this.logjam;
	}

	public void setLogjam(Boolean logjam) {
		this.logjam = logjam;
	}

	@Column(name = "chaCha20Preference")
	public Boolean getChaCha20preference() {
		return this.chaCha20preference;
	}

	public void setChaCha20preference(Boolean chaCha20preference) {
		this.chaCha20preference = chaCha20preference;
	}

	@Column(name = "hstsPolicy")
	public String getHstsPolicy() {
		return this.hstsPolicy;
	}

	public void setHstsPolicy(String hstsPolicy) {
		this.hstsPolicy = hstsPolicy;
	}

	@Column(name = "hstsPreloads", length = 65535)
	public String getHstsPreloads() {
		return this.hstsPreloads;
	}

	public void setHstsPreloads(String hstsPreloads) {
		this.hstsPreloads = hstsPreloads;
	}

	@Column(name = "hpkpPolicy")
	public String getHpkpPolicy() {
		return this.hpkpPolicy;
	}

	public void setHpkpPolicy(String hpkpPolicy) {
		this.hpkpPolicy = hpkpPolicy;
	}

	@Column(name = "hpkpRoPolicy")
	public String getHpkpRoPolicy() {
		return this.hpkpRoPolicy;
	}

	public void setHpkpRoPolicy(String hpkpRoPolicy) {
		this.hpkpRoPolicy = hpkpRoPolicy;
	}

}
package com.ucas.iscas.renlin.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Endpointdetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "endpointdetails", catalog = "ssllabs")
public class Endpointdetails implements java.io.Serializable {

	// Fields

	private Integer id;
	private String host;
	private String ipAddress;
	private Long hostStartTime;
	private Key key;
	private Cert cert;
	private Chain chain;
	private List<Protocol> protocols;
	private Suites suites;
	private String serverSignature;
	private Boolean prefixDelegation;
	private Boolean nonPrefixDelegation;
	private Boolean vulnBeast;
	private Integer renegSupport;
	private Integer sessionResumption;
	private Integer compressionMethods;
	private Boolean supportsNpn;
	private String npnProtocols;
	private Integer sessionTickes;
	private Boolean ocspStapling;
	private Integer staplingRevocationStatus;
	private String staplingRevocationErrorMessage;
	private Boolean sniRequired;
	private Integer httpStatusCode;
	private String httpForwarding;
	private Boolean supportsRc4;
	private Boolean rc4WithModern;
	private Boolean rc4Only;
	private Integer forwardSecrecy;
	private Simdetails sims;
	private Boolean heartbleed;
	private Boolean heartbeat;
	private Integer openSslCcs;
	private Boolean poodle;
	private Integer poodleTls;
	private Boolean fallbackScsv;
	private Boolean freak;
	private Integer hasSct;
	private List<String> dhPrimes;
	private Integer dhUsesKnownPrimes;
	private Boolean dhYsReuse;
	private Boolean logjam;
	private Boolean chaCha20preference;
	private Hstspolicy hstsPolicy;
	private List<Hstspreload> hstsPreloads;
	private Hpkppolicy hpkpPolicy;
	private Hpkppolicy hpkpRoPolicy;

	// Constructors

	/** default constructor */
	public Endpointdetails() {
	}

	/** minimal constructor */
	public Endpointdetails(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Endpointdetails(Integer id, String host, String ipAddress,
			Long hostStartTime, Key key, Cert cert, Chain chain,
			List<Protocol> protocols, Suites suites, String serverSignature,
			Boolean prefixDelegation, Boolean nonPrefixDelegation,
			Boolean vulnBeast, Integer renegSupport, Integer sessionResumption,
			Integer compressionMethods, Boolean supportsNpn,
			String npnProtocols, Integer sessionTickes, Boolean ocspStapling,
			Integer staplingRevocationStatus,
			String staplingRevocationErrorMessage, Boolean sniRequired,
			Integer httpStatusCode, String httpForwarding, Boolean supportsRc4,
			Boolean rc4withModern, Boolean rc4only, Integer forwardSecrecy,
			Simdetails sims, Boolean heartbleed, Boolean heartbeat,
			Integer openSslCcs, Boolean poodle, Integer poodleTls,
			Boolean fallbackScsv, Boolean freak, Integer hasSct,
			List<String> dhPrimes, Integer dhUsesKnownPrimes, Boolean dhYsReuse,
			Boolean logjam, Boolean chaCha20preference, Hstspolicy hstsPolicy,
			List<Hstspreload> hstsPreloads, Hpkppolicy hpkpPolicy, Hpkppolicy hpkpRoPolicy) {
		this.id = id;
		this.host = host;
		this.ipAddress = ipAddress;
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
		this.rc4WithModern = rc4withModern;
		this.rc4Only = rc4only;
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

	@Column(name = "ipAddress")
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "hostStartTime")
	public Long getHostStartTime() {
		return this.hostStartTime;
	}

	public void setHostStartTime(Long hostStartTime) {
		this.hostStartTime = hostStartTime;
	}

	@Column(name = "key")
	public Key getKey() {
		return this.key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	@Column(name = "cert", length = 65535)
	public Cert getCert() {
		return this.cert;
	}

	public void setCert(Cert cert) {
		this.cert = cert;
	}

	@Column(name = "chain")
	public Chain getChain() {
		return this.chain;
	}

	public void setChain(Chain chain) {
		this.chain = chain;
	}

	@Column(name = "protocols")
	public List<Protocol> getProtocols() {
		return this.protocols;
	}

	public void setProtocols(List<Protocol> protocols) {
		this.protocols = protocols;
	}

	@Column(name = "suites", length = 65535)
	public Suites getSuites() {
		return this.suites;
	}

	public void setSuites(Suites suites) {
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
	public Integer getRenegSupport() {
		return this.renegSupport;
	}

	public void setRenegSupport(Integer renegSupport) {
		this.renegSupport = renegSupport;
	}

	@Column(name = "sessionResumption")
	public Integer getSessionResumption() {
		return this.sessionResumption;
	}

	public void setSessionResumption(Integer sessionResumption) {
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
	public Integer getSessionTickes() {
		return this.sessionTickes;
	}

	public void setSessionTickes(Integer sessionTickes) {
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
	public Integer getStaplingRevocationStatus() {
		return this.staplingRevocationStatus;
	}

	public void setStaplingRevocationStatus(Integer staplingRevocationStatus) {
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
	public Integer getHttpStatusCode() {
		return this.httpStatusCode;
	}

	public void setHttpStatusCode(Integer httpStatusCode) {
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
	public Boolean getRc4WithModern() {
		return this.rc4WithModern;
	}

	public void setRc4WithModern(Boolean rc4WithModern) {
		this.rc4WithModern = rc4WithModern;
	}

	@Column(name = "rc4Only")
	public Boolean getRc4Only() {
		return this.rc4Only;
	}

	public void setRc4Only(Boolean rc4Only) {
		this.rc4Only = rc4Only;
	}

	@Column(name = "forwardSecrecy")
	public Integer getForwardSecrecy() {
		return this.forwardSecrecy;
	}

	public void setForwardSecrecy(Integer forwardSecrecy) {
		this.forwardSecrecy = forwardSecrecy;
	}

	@Column(name = "sims")
	public Simdetails getSims() {
		return this.sims;
	}

	public void setSims(Simdetails sims) {
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
	public Integer getOpenSslCcs() {
		return this.openSslCcs;
	}

	public void setOpenSslCcs(Integer openSslCcs) {
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
	public Integer getPoodleTls() {
		return this.poodleTls;
	}

	public void setPoodleTls(Integer poodleTls) {
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
	public Integer getHasSct() {
		return this.hasSct;
	}

	public void setHasSct(Integer hasSct) {
		this.hasSct = hasSct;
	}

	@Column(name = "dhPrimes", length = 65535)
	public List<String> getDhPrimes() {
		return this.dhPrimes;
	}

	public void setDhPrimes(List<String> dhPrimes) {
		this.dhPrimes = dhPrimes;
	}

	@Column(name = "dhUsesKnownPrimes")
	public Integer getDhUsesKnownPrimes() {
		return this.dhUsesKnownPrimes;
	}

	public void setDhUsesKnownPrimes(Integer dhUsesKnownPrimes) {
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
	public Hstspolicy getHstsPolicy() {
		return this.hstsPolicy;
	}

	public void setHstsPolicy(Hstspolicy hstsPolicy) {
		this.hstsPolicy = hstsPolicy;
	}

	@Column(name = "hstsPreloads", length = 65535)
	public List<Hstspreload> getHstsPreloads() {
		return this.hstsPreloads;
	}

	public void setHstsPreloads(List<Hstspreload> hstsPreloads) {
		this.hstsPreloads = hstsPreloads;
	}

	@Column(name = "hpkpPolicy")
	public Hpkppolicy getHpkpPolicy() {
		return this.hpkpPolicy;
	}

	public void setHpkpPolicy(Hpkppolicy hpkpPolicy) {
		this.hpkpPolicy = hpkpPolicy;
	}

	@Column(name = "hpkpRoPolicy")
	public Hpkppolicy getHpkpRoPolicy() {
		return this.hpkpRoPolicy;
	}

	public void setHpkpRoPolicy(Hpkppolicy hpkpRoPolicy) {
		this.hpkpRoPolicy = hpkpRoPolicy;
	}

}
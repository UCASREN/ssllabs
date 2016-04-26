package com.ucas.iscas.renlin.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * Endpointdetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "endpointdetails")
public class Endpointdetails implements java.io.Serializable {

	// Fields

	private Integer id;
	private String host;
	private String ip;
	private Long hostStartTime;
	
	private Key key_info;
	private String keyString;
	
	private Cert cert_info;
	private String certString;
	
	private Chain chain_info;
	private String chainString;
	
	private Set<Protocol> protocols = new HashSet<Protocol>(0);
	private String protocolsString;
	
	private Suites suites_info;
	private String suitesString;
	
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
	
	private Simdetails sims_info;
	private String simsString;
	
	private Boolean heartbleed;
	private Boolean heartbeat;
	private Integer openSslCcs;
	private Boolean poodle;
	private Integer poodleTls;
	private Boolean fallbackScsv;
	private Boolean freak;
	private Integer hasSct;
	
	private Set<String> dhPrimes = new HashSet<String>(0);
	private String dhPrimeString;
	
	private Integer dhUsesKnownPrimes;
	private Boolean dhYsReuse;
	private Boolean logjam;
	private Boolean chaCha20preference;
	
	private Hstspolicy hstsPolicy_info;
	private String hstsPolicyString;
	
	private Set<Hstspreload> hstsPreloads = new HashSet<Hstspreload>(0);
	private String hstsPreloadsString;
	
	private Hpkppolicy hpkpPolicy_info;
	private String hpkpPolicyString;
	
	private Hpkppolicy hpkpRoPolicy_info;
	private String hpkpRoPolicyString;
	

	// Constructors

	/** default constructor */
	public Endpointdetails() {
	}

	/** minimal constructor */
	public Endpointdetails(Integer id) {
		this.id = id;
	}

	/** full constructor 
	 * @param endpoint */
	public Endpointdetails(Integer id, Host host, Endpoint endpoint,
			Long hostStartTime, Key key_info, Cert cert_info, Chain chain_info,
			Set<Protocol> protocols, Suites suites_info, String serverSignature,
			Boolean prefixDelegation, Boolean nonPrefixDelegation,
			Boolean vulnBeast, Integer renegSupport, Integer sessionResumption,
			Integer compressionMethods, Boolean supportsNpn,
			String npnProtocols, Integer sessionTickes, Boolean ocspStapling,
			Integer staplingRevocationStatus,
			String staplingRevocationErrorMessage, Boolean sniRequired,
			Integer httpStatusCode, String httpForwarding, Boolean supportsRc4,
			Boolean rc4withModern, Boolean rc4only, Integer forwardSecrecy,
			Simdetails sims_info, Boolean heartbleed, Boolean heartbeat,
			Integer openSslCcs, Boolean poodle, Integer poodleTls,
			Boolean fallbackScsv, Boolean freak, Integer hasSct,
			Set<String> dhPrimes, Integer dhUsesKnownPrimes, Boolean dhYsReuse,
			Boolean logjam, Boolean chaCha20preference, Hstspolicy hstsPolicy_info,
			Set<Hstspreload> hstsPreloads, Hpkppolicy hpkpPolicy_info, Hpkppolicy hpkpRoPolicy_info) {
		this.id = id;
		this.host = host.getHost();
		this.ip = endpoint.getIpAddress();
		this.hostStartTime = hostStartTime;
		this.key_info = key_info;
		this.keyString = key_info.toString();
		this.cert_info = cert_info;
		this.certString = cert_info.toString();
		this.chain_info = chain_info;
		this.chainString = chain_info.toString();
		this.protocols = protocols;
		this.protocolsString = protocols.toString();
		this.suites_info = suites_info;
		this.suitesString = suites_info.toString();
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
		this.sims_info = sims_info;
		this.simsString = sims_info.toString();
		this.heartbleed = heartbleed;
		this.heartbeat = heartbeat;
		this.openSslCcs = openSslCcs;
		this.poodle = poodle;
		this.poodleTls = poodleTls;
		this.fallbackScsv = fallbackScsv;
		this.freak = freak;
		this.hasSct = hasSct;
		this.dhPrimes = dhPrimes;
		this.dhPrimeString = dhPrimes.toString();
		this.dhUsesKnownPrimes = dhUsesKnownPrimes;
		this.dhYsReuse = dhYsReuse;
		this.logjam = logjam;
		this.chaCha20preference = chaCha20preference;
		this.hstsPolicy_info = hstsPolicy_info;
		this.hstsPolicyString = hstsPolicy_info.toString();
		this.hstsPreloads = hstsPreloads;
		this.hstsPreloadsString = hstsPreloads.toString();
		this.hpkpPolicy_info = hpkpPolicy_info;
		this.hpkpPolicyString = hpkpPolicy_info.toString();
		this.hpkpRoPolicy_info = hpkpRoPolicy_info;
		this.hpkpRoPolicyString = hpkpRoPolicy_info.toString();
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


	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="host_id")*/
	@Column(name="host")
	public String getHost() {
		return this.host;
	}
	public void setHost(Host host) {
		this.host = host.getHost();
	}


	@Column(name = "hostStartTime")
	public Long getHostStartTime() {
		return this.hostStartTime;
	}

	public void setHostStartTime(Long hostStartTime) {
		this.hostStartTime = hostStartTime;
	}

	public Key getKey_info() {
		return key_info;
	}

	public void setKey_info(Key key_info) {
		this.key_info = key_info;
	}

	public Cert getCert_info() {
		return this.cert_info;
	}

	public void setCert_info(Cert cert_info) {
		this.cert_info = cert_info;
	}


	public Chain getChain_info() {
		return this.chain_info;
	}

	public void setChain_info(Chain chain_info) {
		this.chain_info = chain_info;
	}


	@ElementCollection(targetClass=Protocol.class)
	public Set<Protocol> getProtocols() {
		return this.protocols;
	}
	public void setProtocols(Set<Protocol> protocols) {
		this.protocols = protocols;
	}


	public Suites getSuites_info() {
		return this.suites_info;
	}

	public void setSuites_info(Suites suites_info) {
		this.suites_info = suites_info;
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


	public Simdetails getSims_info() {
		return this.sims_info;
	}

	public void setSims_info(Simdetails sims_info) {
		this.sims_info = sims_info;
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

	public Set<String> getDhPrimes() {
		return this.dhPrimes;
	}

	public void setDhPrimes(Set<String> dhPrimes) {
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
	
	public Hstspolicy getHstsPolicy_info() {
		return this.hstsPolicy_info;
	}
	public void setHstsPolicy_info(Hstspolicy hstsPolicy_info) {
		this.hstsPolicy_info = hstsPolicy_info;
	}

	@ElementCollection(targetClass=Hstspreload.class)
	public Set<Hstspreload> getHstsPreloads() {
		return this.hstsPreloads;
	}
	public void setHstsPreloads(Set<Hstspreload> hstsPreloads) {
		this.hstsPreloads = hstsPreloads;
	}

	public Hpkppolicy getHpkpPolicy_info() {
		return this.hpkpPolicy_info;
	}
	public void setHpkpPolicy_info(Hpkppolicy hpkpPolicy_info) {
		this.hpkpPolicy_info = hpkpPolicy_info;
	}

	public Hpkppolicy getHpkpRoPolicy_info() {
		return this.hpkpRoPolicy_info;
	}
	public void setHpkpRoPolicy_info(Hpkppolicy hpkpRoPolicy_info) {
		this.hpkpRoPolicy_info = hpkpRoPolicy_info;
	}

	
/*	@OneToOne(mappedBy="details")
	@JoinColumn(name="endpoint_id")
	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}*/

	@Column(name="ip")
	public String getIp() {
		return ip;
	}
	public void setIp(Endpoint endpoint) {
		this.ip = endpoint.getIpAddress();
	}

    @Column(name="key_info")
	public String getKeyString() {
		return keyString;
	}
	public void setKeyString() {
		this.keyString = key_info.toString();
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "cert_info", columnDefinition="TEXT")
	public String getCertString() {
		return certString;
	}
	public void setCertString() {
		this.certString = cert_info.toString();
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "chain_info", columnDefinition="LONGTEXT")
	public String getChainString() {
		return chainString;
	}
	public void setChainString() {
		this.chainString = chain_info.toString();
	}

	
	@Column(name = "protocols")
	public String getProtocolsString() {
		return protocolsString;
	}
	public void setProtocolsString() {
		this.protocolsString = protocols.toString();
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "suites_info", columnDefinition="TEXT")
	public String getSuitesString() {
		return suitesString;
	}
	public void setSuitesString() {
		this.suitesString = suites_info.toString();
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "sims_info", columnDefinition="LONGTEXT")
	public String getSimsString() {
		return simsString;
	}
	public void setSimsString() {
		this.simsString = sims_info.toString();
	}

	@Type(type="text")
	@Column(name = "dhPrimes")
	public String getDhPrimeString() {
		return dhPrimeString;
	}
	public void setDhPrimeString() {
		this.dhPrimeString = dhPrimes.toString();
	}


	@Column(name = "hstsPolicy_info")
	public String getHstsPolicyString() {
		return hstsPolicyString;
	}
	public void setHstsPolicyString() {
		this.hstsPolicyString = hstsPolicy_info.toString();
	}

	@Type(type="text")
	@Column(name = "hstsPreloads")
	public String getHstsPreloadsString() {
		return hstsPreloadsString;
	}
	public void setHstsPreloadsString() {
		this.hstsPreloadsString = hstsPreloads.toString();
	}

	@Column(name = "hpkpPolicy_info")
	public String getHpkpPolicyString() {
		return hpkpPolicyString;
	}
	public void setHpkpPolicyString() {
		this.hpkpPolicyString = hpkpPolicy_info.toString();
	}

	@Column(name = "hpkpRoPolicy_info")
	public String getHpkpRoPolicyString() {
		return hpkpRoPolicyString;
	}
	public void setHpkpRoPolicyString() {
		this.hpkpRoPolicyString = hpkpRoPolicy_info.toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "dfsd";
	}

}
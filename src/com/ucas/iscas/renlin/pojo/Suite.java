package com.ucas.iscas.renlin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Suite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "suite", catalog = "ssllabs")
public class Suite implements java.io.Serializable {

	// Fields

	private Integer iid;
	private Integer id;
	private String name;
	private Integer cipherStrength;
	private Integer dhStrength;
	private Integer dhP;
	private Integer dhG;
	private Integer dhYs;
	private Integer ecdhBits;
	private Integer ecdhStrength;
	private Boolean q;

	// Constructors

	/** default constructor */
	public Suite() {
	}

	/** minimal constructor */
	public Suite(Integer iid) {
		this.iid = iid;
	}

	/** full constructor */
	public Suite(Integer iid, Integer id, String name, Integer cipherStrength,
			Integer dhStrength, Integer dhP, Integer dhG, Integer dhYs,
			Integer ecdhBits, Integer ecdhStrength, Boolean q) {
		this.iid = iid;
		this.id = id;
		this.name = name;
		this.cipherStrength = cipherStrength;
		this.dhStrength = dhStrength;
		this.dhP = dhP;
		this.dhG = dhG;
		this.dhYs = dhYs;
		this.ecdhBits = ecdhBits;
		this.ecdhStrength = ecdhStrength;
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

	@Column(name = "cipherStrength")
	public Integer getCipherStrength() {
		return this.cipherStrength;
	}

	public void setCipherStrength(Integer cipherStrength) {
		this.cipherStrength = cipherStrength;
	}

	@Column(name = "dhStrength")
	public Integer getDhStrength() {
		return this.dhStrength;
	}

	public void setDhStrength(Integer dhStrength) {
		this.dhStrength = dhStrength;
	}

	@Column(name = "dhP")
	public Integer getDhP() {
		return this.dhP;
	}

	public void setDhP(Integer dhP) {
		this.dhP = dhP;
	}

	@Column(name = "dhG")
	public Integer getDhG() {
		return this.dhG;
	}

	public void setDhG(Integer dhG) {
		this.dhG = dhG;
	}

	@Column(name = "dhYs")
	public Integer getDhYs() {
		return this.dhYs;
	}

	public void setDhYs(Integer dhYs) {
		this.dhYs = dhYs;
	}

	@Column(name = "ecdhBits")
	public Integer getEcdhBits() {
		return this.ecdhBits;
	}

	public void setEcdhBits(Integer ecdhBits) {
		this.ecdhBits = ecdhBits;
	}

	@Column(name = "ecdhStrength")
	public Integer getEcdhStrength() {
		return this.ecdhStrength;
	}

	public void setEcdhStrength(Integer ecdhStrength) {
		this.ecdhStrength = ecdhStrength;
	}

	@Column(name = "q")
	public Boolean getQ() {
		return this.q;
	}

	public void setQ(Boolean q) {
		this.q = q;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: " + iid + ", name: " + name + ", cipherStrength: " + cipherStrength + ", dhStrength: " + dhStrength + ", dhP: " + dhP + ", dhG: " + dhG + ", dhYs: " + dhYs + ", ecdhBits: " + ecdhBits + ", ecdhStrength: " + ecdhStrength + ", q: " + q;
	}

}
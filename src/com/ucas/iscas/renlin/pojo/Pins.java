package com.ucas.iscas.renlin.pojo;

public class Pins {
	private String hashFunction;
	private String value;

	public Pins(String hashFunction, String value) {
		super();
		this.hashFunction = hashFunction;
		this.value = value;
	}
	
	
	public String getHashFunction() {
		return hashFunction;
	}
	public void setHashFunction(String hashFunction) {
		this.hashFunction = hashFunction;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pins [hashFunction=" + hashFunction + ", value=" + value + "]";
	}
}

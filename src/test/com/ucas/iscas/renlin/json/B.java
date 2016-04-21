package test.com.ucas.iscas.renlin.json;

import java.util.List;

public class B {
	
	private Long l;
	private String s;
	private List<C> c;
	
	public B() {
	}
	public B(Long l, String s, List<C> c) {
		this.l = l;
		this.s = s;
		this.c = c;
	}
	public Long getL() {
		return l;
	}
	public void setL(Long l) {
		this.l = l;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public List<C> getC() {
		return c;
	}
	public void setC(List<C> c) {
		this.c = c;
	}
	

}

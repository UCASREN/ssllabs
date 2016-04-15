package com.ucas.iscas.renlin.ssllabs;

import java.io.Serializable;

public class FetchInformation {
	public boolean equal(double num1, double num2) {
		if ((num1 - num2) > 1e-6 && (num1 - num2) < 1e6)
			return true;
		else
			return false;
	}

}

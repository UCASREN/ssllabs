package test.com.ucas.iscas.renlin.json;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class testGson {
	@Test
    public void testC(){
        String c = "{'bb':true, 'll':33}";
	    C cc = new Gson().fromJson(c, C.class);
	    System.out.println(cc.getBb());
    }
    
    @Test
    public void testB(){
    	String b = "{'l': 22, 's':'b class', 'c':[{'bb':true, 'll':33},{'bb':false, 'll':44}]}";
    	B bb = new Gson().fromJson(b, B.class);
    	System.out.println(bb.getL());
    }
    
    @Test
    public void testA(){
    	String a = "{'n':11, 'b':{'l': 22, 's':'b class', 'c':[{'bb':true, 'll':33},{'bb':false, 'll':44}]}}";
 	    A aa = new Gson().fromJson(a, A.class);
 	    System.out.println(aa.getN());
 	    System.out.println(aa.getB().getC().get(0).getLl());
    }

}

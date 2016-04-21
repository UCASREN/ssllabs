package test.com.ucas.iscas.renlin.json;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sun.corba.se.impl.orb.ParserTable.TestBadServerIdHandler;

import net.sf.json.JSONObject;

public class testJson {

	

    @Test
    public void testC(){
        String c = "{'bb':true, 'll':33}";
	    JSONObject obj = JSONObject.fromObject(c);
	    System.out.println(obj);
	    C cc = (C) JSONObject.toBean(obj, C.class);
	    System.out.println(cc.getBb());
    }
    
    @Test
    public void testB(){
    	String b = "{'l': 22, 's':'b class', 'c':[{'bb':true, 'll':33},{'bb':false, 'll':44}]}";
    	JSONObject obj = JSONObject.fromObject(b);
    	System.out.println(obj);
    	/*Map<String, Class> classMap = new HashMap<String, Class>();
    	classMap.put("c", C.class);*/
    	B bb = (B) JSONObject.toBean(obj, B.class);
    	System.out.println(bb.getL());
    }
    
    @Test
    public void testA(){
    	String a = "{'n':11, 'b':{'l': 22, 's':'b class', 'c':[{'bb':true, 'll':33},{'bb':false, 'll':44}]}}";
    	JSONObject obj = JSONObject.fromObject(a);
 	    System.out.println(obj);
 	    Map<String, Class> classMap = new HashMap<String, Class>();  
 	    classMap.put("b", B.class);
 	    classMap.put("c", C.class);
 	    A aa = (A) JSONObject.toBean(obj, A.class, classMap);
 	    System.out.println(aa.getN());
 	    System.out.println(aa.getB().getC().get(0).getLl());
    }

}

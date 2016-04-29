package com.ucas.iscas.renlin.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utilities {
	
	// 初始化数据库
    public static void initialDB(){
    	Configuration cfg = new Configuration().configure();
    	SchemaExport se = new SchemaExport(cfg);
    	//第一个参数 是否生成ddl脚本  第二个参数  是否执行到数据库中
    	se.create(true, true);
    }

	// 将JSON转化为Map
	public static Map<String, Object> jsonToMap(JSONObject json)
			throws JSONException {
		Map<String, Object> retMap = new HashMap<String, Object>();

		if (json != JSONObject.NULL) {
			retMap = toMap(json);
		}
		return retMap;
	}

	public static Map<String, Object> toMap(JSONObject object)
			throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();

		Iterator<String> keysItr = object.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);

			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			list.add(value);
		}
		return list;
	}

	// 获取数据库连接
	public static Connection getConnectedWithMysql() {
		String db_user = "root";
		String db_password = "123456";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost/ssllabs?useUnicode=true&characterEncoding=utf8&useSSL=true",
							db_user, db_password);
		} catch (ClassNotFoundException e) {
			System.out.println("没有引入驱动！" + e.toString());
		} catch (SQLException e) {
			System.out.println("Mysql执行错误！");
			e.printStackTrace();
		}
		return con;
	}
	
	// 将JSONObject转化为POJO对象
	@SuppressWarnings({ "deprecation", "unused", "unchecked" })  
    private Object fromJsonToJava(JSONObject json,Class pojo) throws Exception{  
        // 首先得到pojo所定义的字段  
        Field [] fields = pojo.getDeclaredFields();  
        // 根据传入的Class动态生成pojo对象  
        Object obj = pojo.newInstance();  
        for(Field field: fields){  
            // 设置字段可访问（必须，否则报错）  
            field.setAccessible(true);  
            // 得到字段的属性名  
            String name = field.getName();  
            // 这一段的作用是如果字段在JSONObject中不存在会抛出异常，如果出异常，则跳过。  
            try{  
                    json.get(name);  
            }catch(Exception ex){  
                continue;  
            }  
            if(json.get(name) != null && !"".equals(json.getString(name))){  
                // 根据字段的类型将值转化为相应的类型，并设置到生成的对象中。  
                if(field.getType().equals(Long.class) || field.getType().equals(long.class)){  
                    field.set(obj, Long.parseLong(json.getString(name)));  
                }else if(field.getType().equals(String.class)){  
                    field.set(obj, json.getString(name));  
                } else if(field.getType().equals(Double.class) || field.getType().equals(double.class)){  
                    field.set(obj, Double.parseDouble(json.getString(name)));  
                } else if(field.getType().equals(Integer.class) || field.getType().equals(int.class)){  
                    field.set(obj, Integer.parseInt(json.getString(name)));  
                } else if(field.getType().equals(java.util.Date.class)){  
                    field.set(obj, Date.parse(json.getString(name)));  
                }else{  
                    continue;  
                }  
            }  
        }  
        return obj;  
    }  
}

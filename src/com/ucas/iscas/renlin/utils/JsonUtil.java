package com.ucas.iscas.renlin.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;

import test.com.ucas.iscas.renlin.ssllabs.ApiTest;


public class JsonUtil {

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 *            json字符串
	 * 
	 * @param pojoCalss
	 *            java对象的class
	 * 
	 * @return
	 */

	@Test
	public static Object jsonString2Object(String jsonString, Class pojoCalss) {

		Object pojo;

		JSONObject jsonObject = JSONObject.fromObject(jsonString);

		pojo = JSONObject.toBean(jsonObject, pojoCalss);

		return pojo;

	}

	/**
	 * 
	 * 将java对象转换成json字符串<br>
	 * 支持复杂类型：Java bean 中既有属性又有list
	 * 
	 * @param javaObj
	 * 
	 * @return
	 */

	public static String object2JsonString(Object javaObj) {

		JSONObject json;

		json = JSONObject.fromObject(javaObj);

		return json.toString();

	}

	/**
	 * 
	 * 从json对象集合表达式中得到一个java对象列表
	 * 
	 * @param jsonString
	 * 
	 * @param pojoClass
	 * 
	 * @return
	 */

	public static List jsonList2JavaList(String jsonString, Class pojoClass) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);

		JSONObject jsonObject;

		Object pojoValue;

		List list = new ArrayList();

		for (int i = 0; i < jsonArray.size(); i++) {

			jsonObject = jsonArray.getJSONObject(i);

			pojoValue = JSONObject.toBean(jsonObject, pojoClass);

			list.add(pojoValue);

		}

		return list;

	}
	 
	public static void main(String[] args) {
		ApiTest.testFetchHostInformation();

	}

}

package com.ucas.iscas.renlin.ssllabs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/**
 * Java-SSLLabs-API
 * 
 * This Java library provides basic access to the SSL Labs API and is build upon
 * the official API documentation at
 * https://github.com/ssllabs/ssllabs-scan/blob/master/ssllabs-api-docs.md
 * 
 * @author Björn Roland <https://github.com/bjoernr-de>
 * @license GNU GENERAL PUBLIC LICENSE v3
 */
public class Api {
	private static final String API_URL = "https://api.ssllabs.com/api/v2";
	private static final String VERSION = "0.0.1-SNAPSHOT";

	/**
	 * Fetch API information API Call: info
	 * 
	 * @return JSONObject
	 *         engineVersion：SSL Labs软件版本，如1.22.37
	 *         criteriaVersion：评分准则版本，如2009l maxAssessments &&
	 *         clientMaxAssessments：允许客户端同时发起的最大评估数量，25
	 *         currentAssessments：客户端已提交的正在进行评估的数量，0
	 *         newAssessmentCoolOff：发起每个评估时间间隔，1000ms，如果连续发起评估，会得到429错误码
	 *         messages：其它信息
	 * 
	 */
	public JSONObject fetchApiInfo() {
		String jsonString;
		JSONObject json = new JSONObject();

		try {
			jsonString = sendApiRequest("info", null);
			json = new JSONObject(jsonString);
		} catch (Exception ignored) {
		}

		return (json);
	}

	/**
	 * Fetch host information API Call: analyze
	 * 
	 * @param host
	 *            ：域名，必选
	 * @param publish
	 *            ：是否公开评估结果，默认off，可选
	 * @param startNew
	 *            ：是否忽略已缓存的评估结果而发起新的评估，在发起新的评估时，选on，可选
	 * @param fromCache
	 *            ：一般情况下，总会从服务器的缓存中获取评估结果，注意不能和startNew同时使用为on，默认off，可选
	 * @param maxAge
	 *            ：如果fromCache=on，maxAge表示最大的report age，以小时为单位，应该是该评估结果距离现在多久了？
	 * @param all
	 *            ：默认情况下，调用的返回结果是评估的摘要，all=on时，表示返回完整信息；all=done时，表示评估完成时才返回完整信息
	 * @param ignoreMismatch
	 *            ：当设置为on时，表示即使服务器证书与主机域名不匹配仍然进行评估过程，默认off，注意当返回的是缓存的评估结果时，
	 *            这个参数将被忽略。
	 * @return JSONObject
	 *            : Host Object
	 */
	public JSONObject fetchHostInformation(String host, boolean publish,
			boolean startNew, boolean fromCache, String maxAge, String all,
			boolean ignoreMismatch) {
		String jsonString;
		JSONObject json = new JSONObject();

		try {
			Map<String, String> parameters = new HashMap<String, String>();

			parameters.put("host", host);
			parameters.put("publish", booleanToOnOffString(publish));
			parameters.put("startNew", booleanToOnOffString(startNew));
			parameters.put("fromCache", booleanToOnOffString(fromCache));
			parameters.put("maxAge", maxAge);
			parameters.put("all", all);
			parameters.put("ignoreMismatch",
					booleanToOnOffString(ignoreMismatch));

			jsonString = sendApiRequest("analyze", parameters);
			json = new JSONObject(jsonString);
		} catch (Exception ignored) {
		}

		return (json);
	}

	/**
	 * Same as fetchHostInformation() but prefer caching fetchHostInformation()
	 * with proper parameters can also be used API Call: analyze
	 * 
	 * @param host
	 * @param maxAge
	 * @param publish
	 * @param ignoreMismatch
	 * @return JSONObject
	 */
	public JSONObject fetchHostInformationCached(String host, String maxAge,
			boolean publish, boolean ignoreMismatch) {
		return (fetchHostInformation(host, publish, false, true, maxAge,
				"done", ignoreMismatch));
	}

	/**
	 * Fetch endpoint data API Call: getEndpointData
	 * 
	 * @param host
	 *            ：域名
	 * @param s
	 *            ：域名的IP地址
	 * @param fromCache
	 *            ：是否从缓存中获取评估结果
	 * @return JSONObject
	 *            ：Endpoint object()
	 */
	public JSONObject fetchEndpointData(String host, String s, boolean fromCache) {
		String jsonString;
		JSONObject json = new JSONObject();

		try {
			Map<String, String> parameters = new HashMap<String, String>();

			parameters.put("host", host);
			parameters.put("s", s);
			parameters.put("fromCache", booleanToOnOffString(fromCache));

			jsonString = sendApiRequest("getEndpointData", parameters);
			json = new JSONObject(jsonString);
		} catch (Exception ignored) {
		}

		return (json);
	}

	/**
	 * Fetch status codes API Call: getStatusCodes
	 * 
	 * @return JSONObject
	 */
	public JSONObject fetchStatusCodes() {
		String jsonString;
		JSONObject json = new JSONObject();

		try {
			jsonString = sendApiRequest("getStatusCodes", null);
			json = new JSONObject(jsonString);
		} catch (Exception ignored) {
		}

		return (json);
	}

	/**
	 * Send custom API request and return API response
	 * 发送一个自定义的API请求，并返回API调用的响应
	 * @param apiCall
	 * @param parameters
	 * @return String
	 */
	public String sendCustomApiRequest(String apiCall,
			Map<String, String> parameters) {
		String jsonString = "";

		try {
			jsonString = sendApiRequest(apiCall, parameters);
		} catch (Exception ignored) {
		}

		return (jsonString);
	}

	/**
	 * Sends an api request and return api response
	 * 发送一个API请求，并返回API响应的结果。
	 * @param apiCall
	 *               ：API请求名称
	 * @param parameters
	 *               ：请求参数 
	 * @return String
	 *               ：返回响应的结果
	 * @throws IOException
	 */
	private String sendApiRequest(String apiCall, Map<String, String> parameters)
			throws IOException {
		URL url = new URL(API_URL + "/" + apiCall);

		if (parameters != null) {
			url = new URL(url.toString() + buildGetParameterString(parameters));
		}

		InputStream is = url.openStream();
		int nextByteOfData = 0;

		StringBuffer apiResponseBuffer = new StringBuffer();

		while ((nextByteOfData = is.read()) != -1) {
			apiResponseBuffer.append((char) nextByteOfData);
		}

		is.close();

		return (apiResponseBuffer.toString());
	}

	/**
	 * Helper function to build GET parameter string
	 * 辅助函数：用来创建URL请求的参数
	 * @param parameters
	 * @return String
	 */
	private String buildGetParameterString(Map<String, String> parameters) {
		String getParameterString = "";

		for (Map.Entry<String, String> param : parameters.entrySet()) {
			if (param.getValue() == null) {
				continue;
			}

			getParameterString += (getParameterString.length() < 1) ? ("?")
					: ("&");

			getParameterString += param.getKey() + "=" + param.getValue();
		}

		return (getParameterString);
	}

	/**
	 * Helper function to cast boolean to on/off string
	 * 
	 * @param boolean b
	 * @return String on|off
	 */
	private String booleanToOnOffString(boolean b) {
		return (b == true) ? "on" : "off";
	}

	/**
	 * Getter for API_URL
	 * 
	 * @return String
	 */
	public static String getApiUrl() {
		return API_URL;
	}

	/**
	 * Getter for VERSION
	 * 
	 * @return String
	 */
	public static String getVersion() {
		return VERSION;
	}
}
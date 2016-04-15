package test.com.ucas.iscas.renlin.ssllabs;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.junit.Assert;

public class ApiAssert extends Assert
{
	public static void assertApiDataFetched(JSONObject apiData)
	{
		// 断言返回结果不为空，否则抛出异常AssertionError:Could not fetch data from API
		Assert.assertTrue("Could not fetch data from API", apiData.toString().length() > 2);
	}
	
	public static void assertApiResponseCode(String apiUrl, int expected)
	{
		int responseCode = -1;
				
		try
		{
			URL url = new URL(apiUrl);
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			responseCode = conn.getResponseCode();
			
			conn.disconnect();
		}
		catch(Exception ignored){}
		
		Assert.assertFalse("Failure in assertApiResponseCode method", responseCode == -1);
		Assert.assertTrue("ResponseCode is not the expected one. (IS: " + responseCode + "; SHOULD BE: " + expected + ")", responseCode == expected);
	}
}

package test.com.ucas.iscas.renlin.ssllabs;

import java.util.Map;

import com.ucas.iscas.renlin.ssllabs.Api;
import com.ucas.iscas.renlin.utils.Utilities;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;



public class ApiTest 
{
	@Test
	public void testFetchApiInformation()
	{
		Api api = new Api();
		JSONObject apiInformation = api.fetchApiInfo();
		System.out.println(apiInformation);
		ApiAssert.assertNotNull("JSONObject is null", apiInformation);
		ApiAssert.assertApiDataFetched(apiInformation);
	}
	
	@Test
	public void testFetchHostInformation() throws JSONException
	{
		Api api = new Api();
		JSONObject hostInformation = api.fetchHostInformation("baidu.com", false, false, false, null, "done", true);
		Map<String, Object> result = Utilities.jsonToMap(hostInformation);
		
		System.out.println(hostInformation);
		System.out.println(result.get("status"));
		ApiAssert.assertApiDataFetched(hostInformation);
		
		//TODO: Check API response "host" with requested host
	}
	
	@Test
	public void testFetchHostInformationCached()
	{
		Api api = new Api();
		JSONObject hostInformationCached = api.fetchHostInformationCached("https://www.sslabs.com", null, false, false);
		
		ApiAssert.assertApiDataFetched(hostInformationCached);
	}
	
	@Test
	public void testFetchEndpointData()
	{
		Api api = new Api();
		JSONObject endpointData = api.fetchEndpointData("https://www.ssllabs.com", "64.41.200.100", false);
		System.out.println(endpointData);
		ApiAssert.assertApiDataFetched(endpointData);
	}
	
	@Test
	public void testFetchStatusCodes()
	{
		Api api = new Api();
		JSONObject statusCodes = api.fetchStatusCodes();
		System.out.println(statusCodes);
		ApiAssert.assertApiDataFetched(statusCodes);
	}
	
	@Test
	public void testFailedCustomApiRequest()
	{
		Api api = new Api();
		
		ApiAssert.assertApiResponseCode(api.getApiUrl() + "/bjoernr-de-java-ssllabs-api-test", 404);
	}
}
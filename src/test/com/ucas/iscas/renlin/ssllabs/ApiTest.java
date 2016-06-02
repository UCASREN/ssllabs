package test.com.ucas.iscas.renlin.ssllabs;


import java.io.IOException;

import com.google.gson.Gson;
import com.ucas.iscas.renlin.pojo.Host;
import com.ucas.iscas.renlin.ssllabs.Api;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class ApiTest {
	@Test
	public void testFetchApiInformation() throws JSONException {
		Api api = new Api();
		JSONObject apiInformation = api.fetchApiInfo();
		System.out.println(apiInformation);
		System.out.println("currentAssessments: " + apiInformation.getInt("currentAssessments"));
		ApiAssert.assertNotNull("JSONObject is null", apiInformation);
		ApiAssert.assertApiDataFetched(apiInformation);
	}

	@Test
	public void testFetchHostInformation(){
		Api api = new Api();
		JSONObject hostInformation = api.fetchHostInformation("https://www.facebook.com/", false, false, false, null, "done", true);
		System.out.println(hostInformation);
		/*
		 * Map<String, Class> classMap = new HashMap<String, Class>();
		 * classMap.put("endpoints", Endpoint.class); classMap.put("details",
		 * Endpointdetails.class); classMap.put("key", Key.class);
		 * classMap.put("cert", Cert.class); classMap.put("chain", Chain.class);
		 * classMap.put("certs", Chaincert.class); classMap.put("protocols",
		 * Protocol.class); classMap.put("suites", Suites.class);
		 * classMap.put("list", Suite.class); classMap.put("sims",
		 * Simdetails.class); classMap.put("results", Simulation.class);
		 * classMap.put("client", Simclient.class); classMap.put("hstsPreloads",
		 * Hstspreload.class); classMap.put("hpkpPolicy", Hpkppolicy.class);
		 * classMap.put("hpkpRoPolicy", Hpkppolicy.class);
		 * classMap.put("hstsPolicy", Hstspolicy.class); Host test = (Host)
		 * JSONObject.toBean(hostInformation, Host.class, classMap);
		 */
		Host test = new Gson().fromJson(hostInformation.toString(), Host.class);
		System.out.println("+++++++"+test.getHost());
		System.out.println(test.getStatus());
		//System.out.println(test.getEndpoints().size());

		//ApiAssert.assertApiDataFetched(hostInformation);

		// TODO: Check API response "host" with requested host
	}

	@Test
	public void testFetchHostInformationCached(){
		Api api = new Api();
		JSONObject hostInformationCached = api.fetchHostInformationCached("https://www.sslabs.com", null, false, false);

		ApiAssert.assertApiDataFetched(hostInformationCached);
	}

	@Test
	public void testFetchEndpointData() throws IOException {
		Api api = new Api();
		JSONObject endpointData = api.fetchEndpointData("https://www.ssllabs.com", "64.41.200.100", false);
		System.out.println(endpointData);
		ApiAssert.assertApiDataFetched(endpointData);
	}

	@Test
	public void testFetchStatusCodes() throws IOException {
		Api api = new Api();
		JSONObject statusCodes = api.fetchStatusCodes();
		System.out.println(statusCodes);
		ApiAssert.assertApiDataFetched(statusCodes);
	}

	@Test
	public void testFailedCustomApiRequest() {
		Api api = new Api();

		ApiAssert.assertApiResponseCode(api.getApiUrl()
				+ "/bjoernr-de-java-ssllabs-api-test", 404);
	}
}
package com.ucas.iscas.renlin.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import com.ucas.iscas.renlin.utils.Utilities;

public class AssessmentResults {
	

	public static boolean saveAssessmentResults(JSONObject obj) throws JSONException, SQLException{
		Map<String, Object> result = Utilities.jsonToMap(obj);
		saveHost(result);
		saveEndpoint(result);
		saveEndpointDetails(result);
		return true;
	}
	
	public static void saveHost(Map<String, Object> result) throws SQLException{
		Connection conn = Utilities.getConnectedWithMysql();
	    PreparedStatement pstmt = null;
	    String sql = "INSERT INTO host(host,port,protocol,isPublic,status,statusMessage,startTime,testTime,engineVersion,criteriaVersion,cacheExpiryTime,endpoints,certHostnames) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, (String) result.get("host"));
	    pstmt.setInt(2, (int) result.get("port"));
	    pstmt.setString(3, (String) result.get("protocol"));
	    pstmt.setString(4, String.valueOf(result.get("isPublic")));
	    pstmt.setString(5, (String) result.get("status"));
	    pstmt.setString(6, (String) result.get("statusMessage"));
	    pstmt.setLong(7, (long) result.get("startTime"));
	    pstmt.setLong(8, (long) result.get("testTime"));
	    pstmt.setString(9, (String) result.get("engineVersion"));
	    pstmt.setString(10, (String) result.get("criteriaVersion"));
	    pstmt.setLong(11, result.get("cacheExpiryTime") == null ? 0 : (long) result.get("cacheExpiryTime"));
	    pstmt.setString(12, result.get("endpoints").toString());
	    pstmt.setString(13, (String) result.get("certHostnames"));
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	}
	
	public static void saveEndpoint(Map<String, Object> obj) throws SQLException{
		String host = (String) obj.get("host");
		ArrayList<Map<String, Object>> rs = (ArrayList<Map<String, Object>>) obj.get("endpoints");
		String sql = "INSERT INTO endpoint(host, ipAddress, serverName, statusMessage, statusDetails, statusDetailsMessage, grade, gradeTrustIgnored, hasWarnings, isExceptional, progress, duration, eta, delegation, details)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = Utilities.getConnectedWithMysql();
	    PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		for (Map<String, Object> result : rs){
			pstmt.setString(1, host);
		    pstmt.setString(2, (String) result.get("ipAddress"));
		    pstmt.setString(3, (String) result.get("serverName"));
		    pstmt.setString(4, (String) result.get("statusMessage"));
		    pstmt.setString(5, (String) result.get("statusDetails"));
		    pstmt.setString(6, (String) result.get("statusDetailsMessage"));
		    pstmt.setString(7, (String) result.get("grade"));
		    pstmt.setString(8, (String) result.get("gradeTrustIgnored"));
		    pstmt.setString(9, String.valueOf(result.get("hasWarnings")));
		    pstmt.setString(10, String.valueOf(result.get("isExceptional")));
		    pstmt.setInt(11, (int) result.get("progress"));
		    pstmt.setInt(12, (int) result.get("duration"));
		    pstmt.setInt(13, (int) result.get("eta"));
		    pstmt.setInt(14, (int) result.get("delegation"));
		    pstmt.setString(15, result.get("details").toString());
			pstmt.executeUpdate();
		}
	    pstmt.close();
	    conn.close();
	}
	
	public static void saveEndpointDetails(Map<String, Object> obj) throws SQLException{
		String host = (String) obj.get("host");
		ArrayList<Map<String, Object>> rs = (ArrayList<Map<String, Object>>) obj.get("endpoints");
		String sql = "INSERT INTO endpointdetails(host, ipAddress, hostStartTime, key, cert, chain, protocols, suites, serverSignature, prefixDelegation, nonPrefixDelegation, vulnBeast, renegSupport, sessionResumption, compressionMethods, supportsNpn, npnProtocols, sessionTickes, ocspStapling, staplingRevocationStatus, staplingRevocationErrorMessage, sniRequired, httpStatusCode, httpForwarding, supportsRc4, rc4WithModern, rc4Only, forwardSecrecy, sims, heartbleed, heartbeat, openSslCcs, poodle, poodleTls, fallbackScsv, freak, hasSct, dhPrimes, dhUsesKnownPrimes, dhYsReuse, logjam, chaCha20Preference, hstsPolicy, hstsPreloads, hpkpPolicy, hpkpRoPolicy)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = Utilities.getConnectedWithMysql();
	    PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		for (Map<String, Object> r : rs){
			String ip = (String) r.get("ipAddress");
			Map<String, Object>  result = (Map<String, Object>) r.get("details");
			pstmt.setString(1, host);
		    pstmt.setString(2, ip);
		    pstmt.setLong(3, (long) result.get("hostStartTime"));
		    pstmt.setString(4, result.get("key").toString());
		    pstmt.setString(5, result.get("cert").toString());
		    pstmt.setString(6, result.get("chain").toString());
		    pstmt.setString(7, result.get("protocols").toString());
		    pstmt.setString(8, result.get("suites").toString());
		    pstmt.setString(9, (String) result.get("serverSignature"));
		    pstmt.setString(10, String.valueOf(result.get("prefixDelegation")));
		    pstmt.setString(11, String.valueOf(result.get("nonPrefixDelegation")));
		    pstmt.setInt(12, (int) result.get("vulnBeast"));
		    pstmt.setInt(13, (int) result.get("renegSupport"));
		    pstmt.setInt(14, (int) result.get("sessionResumption"));
		    pstmt.setString(15, result.get("compressionMethods").toString());
		    pstmt.setString(16, result.get("supportsNpn"));
		    pstmt.setString(2, result.get("npnProtocols"));
		    pstmt.setString(3, (String) result.get("sessionTickes"));
		    pstmt.setString(4, (String) result.get("ocspStapling"));
		    pstmt.setString(5, (String) result.get("staplingRevocationStatus"));
		    pstmt.setString(6, (String) result.get("staplingRevocationErrorMessage"));
		    pstmt.setString(7, (String) result.get("sniRequired"));
		    pstmt.setString(8, (String) result.get("httpStatusCode"));
		    pstmt.setString(9, String.valueOf(result.get("httpForwarding")));
		    pstmt.setString(10, String.valueOf(result.get("supportsRc4")));
		    pstmt.setInt(11, (int) result.get("rc4WithModern"));
		    pstmt.setInt(12, (int) result.get("rc4Only"));
		    pstmt.setInt(13, (int) result.get("forwardSecrecy"));
		    pstmt.setInt(14, (int) result.get("sims"));
		    pstmt.setString(15, result.get("heartbleed").toString());
		    pstmt.setString(1, result.get("heartbeat"));
		    pstmt.setString(2, result.get("openSslCcs"));
		    pstmt.setString(3, (String) result.get("poodle"));
		    pstmt.setString(4, (String) result.get("poodleTls"));
		    pstmt.setString(5, (String) result.get("fallbackScsv"));
		    pstmt.setString(6, (String) result.get("freak"));
		    pstmt.setString(7, (String) result.get("hasSct"));
		    pstmt.setString(8, (String) result.get("dhPrimes"));
		    pstmt.setString(9, String.valueOf(result.get("dhUsesKnownPrimes")));
		    pstmt.setString(10, String.valueOf(result.get("dhYsReuse")));
		    pstmt.setInt(11, (int) result.get("logjam"));
		    pstmt.setInt(12, (int) result.get("chaCha20Preference"));
		    pstmt.setInt(13, (int) result.get("hstsPolicy"));
		    pstmt.setInt(14, (int) result.get("hstsPreloads"));
		    pstmt.setString(15, result.get("hpkpPolicy").toString());
		    pstmt.setString(46, result.get("hpkpRoPolicy"));
			pstmt.executeUpdate();
		}
	    pstmt.close();
	    conn.close();
	}

}

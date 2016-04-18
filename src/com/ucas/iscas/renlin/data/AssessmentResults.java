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
	
	public static void saveEndpoint(Map<String, Object> obj) throws JSONException, SQLException{
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

}

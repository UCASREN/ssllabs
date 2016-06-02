package com.ucas.iscas.renlin.url;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.iscas.tca.renlin.url.AzureSearchResultSet;
import com.iscas.tca.renlin.url.AzureSearchWebQuery;
import com.iscas.tca.renlin.url.AzureSearchWebResult;
import com.iscas.tca.renlin.url.Map;
import com.iscas.tca.renlin.util.ConnectedToMysql;

public class SubDomainNames {
	private static final String ACCOUNT_KEY = "JtJk37ov314fgNXXDweVL342qqwXFsNc2pbyLWaQ9bQ";

	public static String getSubDomainNames(String searchParam) {
		List<String> urls = new ArrayList();

		AzureSearchWebQuery aq = new AzureSearchWebQuery();
		aq.setAppid("JtJk37ov314fgNXXDweVL342qqwXFsNc2pbyLWaQ9bQ");
		aq.setQuery(searchParam);
		aq.setMarket("zh-CN");
		aq.setPerPage(Integer.valueOf(60));
		aq.doQuery();
		AzureSearchResultSet<AzureSearchWebResult> ars = aq.getQueryResult();
		for (Iterator<AzureSearchWebResult> iterator = ars.iterator(); iterator
				.hasNext();) {
			AzureSearchWebResult result = (AzureSearchWebResult) iterator
					.next();
			String temp_url = result.getUrl();
			if (temp_url.startsWith("https://")) {
				urls.add(temp_url);
			}
		}
		return urls.toString();
	}

	public static LinkedHashMap getDomainNames() {
		InputStream in = null;
		LinkedHashMap line = new LinkedHashMap();
		try {
			in = new FileInputStream("/Users/renlinhu/Desktop/test/topList");
			byte[] b = new byte[in.available()];
			in.read(b);
			String[] temp = new String(b).split("\\n");
			int rank = 0;
			for (int i = 0; i < temp.length; i++) {
				if (!line.containsKey(temp[i].trim())) {
					line.put(temp[i].trim(), Integer.valueOf(++rank));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

	public static void main(String[] args) {
		try {
			Connection conn = ConnectedToMysql.getConnectedWithMysql();
			PreparedStatement pstmt = null;

			String sql = "INSERT INTO url(url, sub_urls, rank) VALUES (?,?,?)";

			LinkedHashMap urls = getDomainNames();
			System.out.println(urls.size());
			Set<String> urls_done = getDomainNamesFromDB(conn);
			for (Iterator<String> it = urls_done.iterator(); it.hasNext();) {
				urls.remove(((String) it.next()).trim());
			}
			System.out.println(urls.size());
			for (Iterator it = urls.entrySet().iterator(); it.hasNext();) {
				Map.Entry e = (Map.Entry) it.next();
				String query = "https " + e.getKey();
				String sub_urls = getSubDomainNames(query);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, e.getKey().toString());
				pstmt.setString(2, sub_urls);
				pstmt.setString(3, e.getValue().toString());

				pstmt.executeUpdate();
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Mysql执行错误！");
			e.printStackTrace();
		}
	}

	private static Set<String> getDomainNamesFromDB(Connection conn) {
		Set<String> dbUrlSet = new LinkedHashSet();
		String sql = "select url from url";
		try {
			PreparedStatement query = conn.prepareStatement(sql);
			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				dbUrlSet.add(rs.getString("url"));
			}
			query.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbUrlSet;
	}

	private static void updateUrlWithRank(String url, int rank, Connection conn) {
		String sql = "update url set rank = ? where url = ?";
		try {
			PreparedStatement update = conn.prepareStatement(sql);
			update.setString(2, url);
			update.setInt(1, rank);
			update.executeUpdate();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

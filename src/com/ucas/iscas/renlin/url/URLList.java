package com.ucas.iscas.renlin.url;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iscas.tca.renlin.util.ConnectedToMysql;

public class URLList {
	private static FileOutputStream file = null;
	private static BufferedOutputStream Buff = null;

	public static void main(String[] args) {
		try {
			Connection conn = ConnectedToMysql.getConnectedWithMysql();
			PreparedStatement pstmt = null;

			String sql = "select sub_urls from url";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			file = new FileOutputStream(new File(
					"/Users/renlinhu/Desktop/test/urllist.txt"));
			Buff = new BufferedOutputStream(file);
			int index = 1;
			while (rs.next()) {
				String temp = rs.getString("sub_urls").substring(1,
						rs.getString("sub_urls").length() - 1);
				writeToFile(temp, file, index);
				index++;
			}
			Buff.flush();
			Buff.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Mysql执行错误！");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeToFile(String url, FileOutputStream fs, int index) {
		String[] urls = url.split(", ");
		try {
			for (int i = 0; i < urls.length; i++) {
				Buff.write((index + "_" + i + " " + urls[i] + "\r\n")
						.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

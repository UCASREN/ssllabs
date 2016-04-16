package com.ucas.iscas.renlin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileFind {
	public static List<String> getAllPath(String url, List<String> URLS,
			String ends) {
		File f = new File(url);
		if (f.isDirectory()) {
			File[] fs = f.listFiles();
			for (int i = 0; i < fs.length; i++) {
				URLS = getAllPath(fs[i].getPath(), URLS, ends);
			}
		} else if (f.getName().endsWith(ends)) {
			URLS.add(f.getAbsolutePath());
		}
		return URLS;
	}

	public static String getFileNameNoEx(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < filename.length())) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}

	public static String[] getRealSiteNames(String pathName) {
		byte[] b = null;
		try {
			InputStream in = new FileInputStream(pathName);
			b = new byte[in.available()];
			in.read(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] line = new String(b).split("\\n");
		return line;
	}

	public static List<String> getAllNames(String url, List<String> URLS,
			String ends) {
		File f = new File(url);
		if (f.isDirectory()) {
			File[] fs = f.listFiles();
			for (int i = 0; i < fs.length; i++) {
				URLS = getAllNames(fs[i].getPath(), URLS, ends);
			}
		} else if (f.getName().endsWith(ends)) {
			URLS.add(f.getName());
		}
		return URLS;
	}
}
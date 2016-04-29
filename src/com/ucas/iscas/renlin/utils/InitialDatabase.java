package com.ucas.iscas.renlin.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class InitialDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();
    	SchemaExport se = new SchemaExport(cfg);
    	//第一个参数 是否生成ddl脚本  第二个参数  是否执行到数据库中
    	se.create(true, true);
	}

}

package test.com.ucas.iscas.renlin.hibernate;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.json.JSONObject;
import org.junit.Test;

import com.google.gson.Gson;
import com.ucas.iscas.renlin.pojo.Endpoint;
import com.ucas.iscas.renlin.pojo.Endpointdetails;
import com.ucas.iscas.renlin.pojo.Host;
import com.ucas.iscas.renlin.ssllabs.Api;

import test.com.ucas.iscas.renlin.pojo.Grade;
import test.com.ucas.iscas.renlin.pojo.Student;


public class HibernateTest {

    @Test
    public void testCreateDB(){
    	Configuration cfg = new Configuration().configure();
    	SchemaExport se = new SchemaExport(cfg);
    	//第一个参数 是否生成ddl脚本  第二个参数  是否执行到数据库中
    	se.create(true, true);
    }
    
    @Test
    public void testSave(){
    	Session session = null;
    	Transaction tx = null;
    	try{
    		session = HibernateUtil.getSession();
    		tx = session.beginTransaction();
    		
    		Grade grade = new Grade();
    		grade.setName("基础");
    		
    		Student stu = new Student();
    		stu.setName("张三疯");
    		stu.setAge(20);
    		stu.setGrade(grade);
    		
    		Student stu1 = new Student();
    		stu1.setName("老五");
    		stu1.setAge(23);
    		stu1.setGrade(grade);
    		
    		grade.getStudents().add(stu);
    		grade.getStudents().add(stu1);
    		session.save(grade);
            
    		tx.commit();
    		
    	}catch(HibernateException e){
    		if (tx != null)
    			tx.rollback();
    		e.printStackTrace();
    		throw e;
    	}finally{
    		HibernateUtil.closeSession();
    	}
    }
    
    @Test
    public void testGet(){
    	Session session = null;
    	Transaction tx = null;
    	try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//取数据
			Grade grade = (Grade)session.get(Grade.class, 1);
			System.out.println("gradeName="+grade.getName());
			System.out.println("grade所对应的多的一端的数据");
			Iterator<Student> iter = grade.getStudents().iterator();
			for(;iter.hasNext();){
				Student temp = iter.next();
				System.out.println("name="+temp.getName()+"\tage="+temp.getAge());
			}
			System.out.println("========================");
			Student stu = (Student)session.get(Student.class, 1);
			System.out.println("studentname="+stu.getName()+"   gradeName="+stu.getGrade().getName());
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUtil.closeSession();
		}
    }
    
    @Test
    public void testSSL(){
    	Session session = null;
    	Transaction tx = null;
    	try{
    		session = HibernateUtil.getSession();
    		tx = session.beginTransaction();
    		Api api = new Api();
    		JSONObject hostInformation = api.fetchHostInformation("google.com", false, false, false, null, "done", true);
    		System.out.println(hostInformation);
    		Host host = new Gson().fromJson(hostInformation.toString(), Host.class);
    		Set<Endpoint> endpoints = host.getEndpoints();
    		Iterator<Endpoint> iterator = endpoints.iterator();
    		while (iterator.hasNext()){
    			Endpoint next = iterator.next();
    			next.setHost(host);
    			Endpointdetails details = next.getDetails_info();
    			details.setHost(host);
    			details.setIp(next);
    			session.save(next);
    			session.save(details);
    		}	
            session.save(host);
    		tx.commit();
    	}catch(HibernateException e){
    		if (tx != null)
    			tx.rollback();
    		e.printStackTrace();
    		throw e;
    	}finally{
    		HibernateUtil.closeSession();
    	}
    }

}

package test;



import java.util.Date;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import db.HibernateSessionFactory;
import entity.Students;

public class testStudents {

	@Test
	public void testSchemaExport(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).
				buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		SchemaExport export = new SchemaExport(config);
		
		export.create(true, true);
	}
	
	@Test
	public void testSaveStudents(){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx =  session.beginTransaction();
		
		Students s1 = new Students("002","ÕÅ2Ïþ","Å®2",new Date(),"chendu ");
		session.save(s1);
		
		tx.commit();

	}
}

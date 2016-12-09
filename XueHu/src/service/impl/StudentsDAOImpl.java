package service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.HibernateSessionFactory;
import entity.Students;
import service.StudentsDAO;

public class StudentsDAOImpl implements StudentsDAO {

	@Override
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		List<Students> list=null;
		Transaction tx = null;
		try {
//			 tx = session.beginTransaction();
			String hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		finally{
			if(tx!=null){
				((Session) tx).close();
			}
		}

	}

	@Override
	public Students queryStudentsBySid(String sid) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Students s =null;
		Transaction tx = null;
		try {
			 tx = session.beginTransaction();
			 s = (Students) session.get(Students.class, sid);
			 tx.commit();
			return s;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			if(tx!=null){
				  tx=null;
			}
		}
	}
	public Students queryStudentsBySname(String sname) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Students s =null;
		Transaction tx = null;
		String hql = "from Students where sname=?";
		try {
			 tx = session.beginTransaction();
		     Query query = session.createQuery(hql);
		     query.setString(0, sname);
			 s= (Students) query.uniqueResult();
			 tx.commit();
			return s;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			if(tx!=null){
				  tx=null;
			}
		}
	}

	@Override
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql ="";
		s.setSid(getNewSid());
		try {
			Session session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	@Override
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		Transaction tx = null;
	//	String hql ="";
		
		try {
			Session session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.merge(s);
	//		session.update(s);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	@Override
	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
	//	String hql ="";
		
		try {
			Session session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Students s = (Students) session.get(Students.class , sid);
			session.delete(s);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	public String getNewSid()
	{
		Transaction tx = null;
		String hql ="";
		String sid = null;
		try {
			Session session = HibernateSessionFactory.getSession();
	//		tx = session.beginTransaction();
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if(sid == null || "".equals(sid))
			{
				sid = "S00000001";
			}
			else
			{
				String temp = sid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				temp = String.valueOf(i);
				int len = temp.length();
				for(int j=0; j<7-len; j++){
					temp = "0"+temp;
				}
				sid = "S"+temp;
			}

	//		tx.commit();
			return sid;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	//		tx.commit();
			return null;
		}
		finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

}

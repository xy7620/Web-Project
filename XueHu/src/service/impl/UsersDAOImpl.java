package service.impl;

import java.util.List;

import org.hibernate.*;

import db.HibernateSessionFactory;
import service.UsersDAO;
import entity.*;

public class UsersDAOImpl implements UsersDAO{

	public boolean usersLogin(Users u){
		Transaction tx =null;
		String hql =" ";
		try{
			Session session = HibernateSessionFactory.getSession();
			tx =session.beginTransaction();
	//		tx.begin();
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = (List) query.list();
			tx.commit();
			if( list.size()>0  ){
				return true;
			}else{
				return false;
			}
			
		}
		catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
			if(tx != null){
			//	tx.commit();
				tx = null;
			}
		}
	}
}

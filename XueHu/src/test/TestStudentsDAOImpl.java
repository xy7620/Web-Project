package test;

import java.util.List;

import org.junit.Test;

import service.impl.StudentsDAOImpl;
import entity.Students;

public class TestStudentsDAOImpl {

	@Test
	public void testQueryAllStu(){
		List<Students> list = new StudentsDAOImpl().queryAllStudents();
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}
	@Test
	public void testGetNewSid()
	{
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		System.out.println(sdao.getNewSid());
	}
}

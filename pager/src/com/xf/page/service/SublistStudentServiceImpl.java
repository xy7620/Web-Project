package com.xf.page.service;

import com.xf.page.dao.StudentDao;
import com.xf.page.dao.SublistStudentDaoImpl;
import com.xf.page.model.Pager;
import com.xf.page.model.Student;


/**
 * @author XF
 * 使用subList（）实现分页
 */
public class SublistStudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public SublistStudentServiceImpl(){
		//创建类时再初始化Dao对象
		studentDao = new SublistStudentDaoImpl();
	}
	@Override
	public Pager<Student> findStudent(Student searchMode, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		Pager<Student> result = studentDao.findStudent(searchMode, pageNum, pageSize);
		return result;
	}

}

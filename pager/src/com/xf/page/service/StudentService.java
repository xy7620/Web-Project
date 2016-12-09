package com.xf.page.service;

import com.xf.page.model.Pager;
import com.xf.page.model.Student;

public interface StudentService {

/**
 * @author XF
 *	根据查询条件，查询学生分页信息
 */	
	public Pager<Student> findStudent(Student searchMode, int pageNum, int pageSize);
}

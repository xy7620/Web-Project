package com.xf.page.dao;

import com.xf.page.model.Pager;
import com.xf.page.model.Student;

public interface StudentDao {
	public Pager<Student> findStudent(Student searchModel, int pageNum, int pageSize);
}

package com.xf.page.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;






import com.xf.page.model.Pager;
import com.xf.page.model.Student;
import com.xf.page.util.JdbcUtil;

public class SublistStudentDaoImpl implements StudentDao {

	//调用方法getAllStudent，然后根据传入的参数，生成Pager对象，即结果。
	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		List<Student> allStudents = getAllStudent(searchModel);
		Pager<Student > pager = new Pager<Student>(pageNum, pageSize, allStudents);
		System.out.println("DaoImpl: pageNum= "+pageNum);
		return pager;
	}
	//查找所有满足条件的对象
	private List<Student> getAllStudent(Student searchModel){
		List<Student> result = new ArrayList<Student>();
		List<Object> paramList = new ArrayList<Object>();
		
		String stuName = searchModel.getName();
//		System.out.println("impl : name: "+stuName);
		int gender = searchModel.getGender();
		
		StringBuilder sql = new StringBuilder("select * from t_student where 1=1");
		if(stuName != null && !stuName.equals("")){
			sql.append(" and stu_name like ?");
			paramList.add("%"+stuName+"%");
		}
		if(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE){
			sql.append(" and gender = ?");
			paramList.add(gender);
		}
		
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection();
			List<Map<String, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			if(mapList != null){
				for(Map<String, Object> map:mapList){
					Student s = new Student(map);
	//				System.out.println("name: "+s.getName());
					result.add(s);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("查询所有数据异常!",e);
		}finally{
			if(jdbcUtil != null){
				jdbcUtil.releaseConn();
			}
		}
		
		return result;
	}
}

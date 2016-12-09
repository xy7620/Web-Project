package com.xf.page.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xf.page.model.Pager;
import com.xf.page.model.Student;
import com.xf.page.util.JdbcUtil;

/**
 * @author XF
 * 使用MySql数据库limit实现分页
 */
public class JdbcSqlStudentDaoImpl implements StudentDao {

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		Pager<Student> result = null;
		List<Object> paramList = new ArrayList<Object>();
		
		String stuName = searchModel.getName();
//		System.out.println("impl : name: "+stuName);
		int gender = searchModel.getGender();
		
		StringBuilder sql = new StringBuilder("select * from t_student where 1=1");
		//因为使用了limit，无法获取总条数，所以使用另一条sql语句来查询总条数
		StringBuilder countSql = new StringBuilder("select count(id) as totalRecord from t_student where 1=1 ");
		
		if(stuName != null && !stuName.equals("")){
			sql.append(" and stu_name like ?");
			countSql.append(" and stu_name like ?");
			paramList.add("%"+stuName+"%");
		}
		if(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE){
			sql.append(" and gender = ?");
			countSql.append(" and gender = ?");
			paramList.add(gender);
		}

		
		List<Student> studentList = new ArrayList<Student>(); 
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection();
			//获取总条数
			List<Map<String, Object>> countResult = jdbcUtil.findResult(countSql.toString(), paramList);
			Map<String, Object> countMap =  countResult.get(0);
			int totalRecord = ((Number)countMap.get("totalRecord")).intValue();
			//计算总页数
			int totalPage = totalRecord / pageSize;
			//非整除+1
			if(totalRecord % pageSize != 0) totalPage +=1;
			//将pageNum限制在合理范围
			if(pageNum > totalPage) pageNum = totalPage;
			if(pageNum<1) pageNum = 1;
			int fromIndex = pageSize*(pageNum -1 );
			sql.append(" limit "+fromIndex+","+pageSize);
			//获取查询的学生记录
			List<Map<String, Object>> studentResult = jdbcUtil.findResult(sql.toString(), paramList);
			if(studentResult != null){
				for(Map<String, Object> map:studentResult){
					Student s = new Student(map);
					studentList.add(s);
				}
			}

			
			result = new Pager<Student>(pageSize, pageNum, totalRecord, totalPage, studentList);
			
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

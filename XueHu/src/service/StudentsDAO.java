package service;

import java.util.List;

import entity.Students;

public interface StudentsDAO {

	public List<Students> queryAllStudents();
	
	public Students queryStudentsBySid(String sid);
	
	public boolean addStudents(Students s);
	
	public boolean updateStudents(Students s);
	
	public boolean deleteStudents(String sid);
}

package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entity.Students;
import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

public class StudentsAction extends SuperAction{

	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		if(list != null && list.size()>0)
		{
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	public String get(){
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		String sname = request.getParameter("sname");
		Students s = sdao.queryStudentsBySname(sname);
		if(s != null )
		{
			session.setAttribute("students", s);
		}
		return "get_success";
	}
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
		
	}
	public String add() throws ParseException
	{
		Students s = new Students();
		StudentsDAO sdao = new StudentsDAOImpl();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		String birthday = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(birthday);
		s.setBirthday(date);
		s.setAddress(request.getParameter("address"));
		sdao.addStudents(s);
		return "add_success";
	}
	public String modify()
	{
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	 public String save() throws ParseException
	 {
			Students s = new Students();
			StudentsDAO sdao = new StudentsDAOImpl();
			s.setSname(request.getParameter("sname"));
			s.setSid(request.getParameter("sid"));
			s.setGender(request.getParameter("gender"));
			String birthday = request.getParameter("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(birthday);
			s.setBirthday(date);
			s.setAddress(request.getParameter("address"));
			sdao.updateStudents(s);
			return "save_success";
	 }
}

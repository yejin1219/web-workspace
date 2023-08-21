package model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import model.dao.StudentDAO;
import model.vo.StudentVO;

public class StudentService {
   public List<StudentVO> showStudent(String word){
	   SqlSession sqlsession = Template.getsqlSession();
	  List <StudentVO> list =  new StudentDAO().showStudent(sqlsession,word);
	  sqlsession.close();
	return list;
	   
   }
}

package czxy.qsgl.dao;

import java.util.List;

import czxy.qsgl.entity.Student;


public interface studentDao {
	int save(Student student);  //增加学生
	int updata(Student student);//修改信息
	int delete(String studentId);//删除学生
	List<Student> search(String name);
	List<Student> findAll(String department);
	Student findById(String studentId);
	
}

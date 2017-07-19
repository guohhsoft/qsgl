package czxy.qsgl.dao;

import java.util.List;
import java.util.Map;

import czxy.qsgl.entity.Dormitory;
import czxy.qsgl.entity.Student;

public interface DormitoryDao {
	int save(Dormitory dm);
	int update(Dormitory dd);
	List<Dormitory> find(String louhao);
	List<Dormitory> search(Map<String,String> map);
	int saveStudent(Student student);
	List<Student> chakan(Map<String,String> map);
	int louhao();
}
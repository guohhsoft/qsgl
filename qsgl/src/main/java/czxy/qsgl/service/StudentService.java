package czxy.qsgl.service;

import java.util.List;

import czxy.qsgl.entity.Student;
import czxy.qsgl.util.NoteResult;

public interface StudentService {
	NoteResult<List<Student>> findAll(String department);
	NoteResult<List<Student>> search(String name);
	NoteResult<String> save(String studentId,String name,String sex,String addr,String department,String louhao,String sushehao);
	NoteResult<String>updata(String studentId,String name,String sex,String addr,String department,String louhao,String sushehao);
	NoteResult<String> delete(String studentId);
}

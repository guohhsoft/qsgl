package czxy.qsgl.service;

import java.util.List;

import czxy.qsgl.entity.Dormitory;
import czxy.qsgl.entity.Student;
import czxy.qsgl.util.NoteResult;

public interface DormitoryService {
	NoteResult<List<Dormitory>> find(String louhao);
	NoteResult<List<Dormitory>> search(String louhao,String msg);
	NoteResult<String> save(String sushehao,String louhao,String department,int max,String depict);
	NoteResult<String> update(String sushehao,String louhao,String department,int max,String depict );
	//NoteResult<String> louhao();
	NoteResult<List<Student>> chakan(String louhao,String sushehao);
}

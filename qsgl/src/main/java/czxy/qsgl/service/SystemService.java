package czxy.qsgl.service;

import java.util.List;

import czxy.qsgl.entity.Department;
import czxy.qsgl.entity.Louhao;
import czxy.qsgl.util.NoteResult;

public interface SystemService {
	NoteResult<String> savelou(String louhao);
	NoteResult<String> savede(String department);
	
	NoteResult<String> deletelou(String louhao);
	NoteResult<String> deletede(String department);
	
	NoteResult<List<Louhao>> findAllLou();
	NoteResult<List<Department>> findAllDe();
}

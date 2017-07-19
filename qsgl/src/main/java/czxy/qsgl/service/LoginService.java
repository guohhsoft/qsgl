package czxy.qsgl.service;

import czxy.qsgl.entity.Manager;
import czxy.qsgl.util.NoteResult;

public interface LoginService {
	public NoteResult<Manager> checkLogin(String name ,String password);

}

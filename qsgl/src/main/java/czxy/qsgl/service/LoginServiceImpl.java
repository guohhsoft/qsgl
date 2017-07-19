package czxy.qsgl.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import czxy.qsgl.dao.loginDao;
import czxy.qsgl.entity.Manager;
import czxy.qsgl.util.NoteResult;
@Service("LoginService")
@Transactional
public class LoginServiceImpl implements LoginService{
	@Resource
	private loginDao dao;
	public NoteResult<Manager> checkLogin(String name, String password) {
		Manager manager = dao.findByName(name);
		System.out.println(manager);
		NoteResult<Manager> result = new NoteResult<Manager>();
		if(manager==null){
			result.setStatus(0);
			result.setMsg("账号不存在");
			return result;
		}else if(manager.getPassword().equals(password)==false){
			result.setMsg("密码错误");
			result.setStatus(1);
			return result;
		}else{
			result.setStatus(3);
			result.setData(manager);
		return result;
		}
}
}

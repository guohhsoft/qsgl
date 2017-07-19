package czxy.qsgl.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.qsgl.entity.Manager;
import czxy.qsgl.service.LoginService;
import czxy.qsgl.util.NoteResult;

@Controller
public class loginController {
	@Resource(name="LoginService")
	private LoginService service;
	@RequestMapping("/login.do")  
	@ResponseBody               
	public NoteResult<Manager> login(String name,String password){
		NoteResult<Manager> res = service.checkLogin(name, password);
		return res;
	}

}

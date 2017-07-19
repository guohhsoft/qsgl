package czxy.qsgl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.qsgl.entity.Manager;
import czxy.qsgl.service.ManagerService;
import czxy.qsgl.util.NoteResult;
@Controller
public class managerController {
	@Resource(name="ManagerService")
	private ManagerService service;
	@RequestMapping("/updatap.do") 
	@ResponseBody                
	public NoteResult<String> updatep(String name,String password,String tel){
		 NoteResult<String> res =service.updata(password, name, tel);
		return res;
	}
	@RequestMapping("/check.do")
	@ResponseBody
	public NoteResult<Manager> check(String name){
		 NoteResult<Manager> res =service.findByName(name);
		return res;
	}
	@RequestMapping("/findall.do")
	@ResponseBody
	public NoteResult<List<Manager>> findall(){
		NoteResult<List<Manager>> res =service.findByAll();
		return res;
	}
	@RequestMapping("/delete.do")
	@ResponseBody
	public NoteResult<String> delete(String name){
		NoteResult<String> res =service.delete(name);
		return res;
	}
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult<List<Manager>> search(String name ){
		NoteResult<List<Manager>> res = service.search(name);
		return res;
	}
	@RequestMapping("/addmanager.do")
	@ResponseBody
	public NoteResult<String> addmanager(String name,String password,String job,String louhao,int quanxian,String telephone,String sushehao){
		NoteResult<String> res = service.save(name, password, telephone, job, quanxian, louhao,sushehao);
		return res;
	}
	@RequestMapping("/updatem.do")
	@ResponseBody
	public NoteResult<String> updatem(String id,String name,String password,String job,String louhao,int quanxian,String telephone ){
		NoteResult<String> res = service.updatem(id,name, password, telephone, job, quanxian, louhao);
		return res;
	}
}

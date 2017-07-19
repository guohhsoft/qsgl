package czxy.qsgl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.qsgl.entity.Department;
import czxy.qsgl.entity.Louhao;
import czxy.qsgl.service.SystemService;
import czxy.qsgl.util.NoteResult;

@Controller
public class SystemController {
@Resource(name="systemService")
private SystemService service;

//楼号
	@RequestMapping("louhao/find.do")
	@ResponseBody
	public NoteResult<List<Louhao>> findAlllou(){
		NoteResult<List<Louhao>> res = service.findAllLou();
		return res;
		}
	@RequestMapping("louhao/delete.do")
	@ResponseBody
	public NoteResult<String> deletel(String louhao){
		NoteResult<String> res = service.deletelou(louhao);
		return res;
		}
	@RequestMapping("louhao/save.do")
	@ResponseBody
	public NoteResult<String> savelou(String louhao){
		NoteResult<String> res = service.savelou(louhao);
		return res;
		}
	
	
//系别
	@RequestMapping("department/find.do")
	@ResponseBody
	public NoteResult<List<Department>> findAllde(){
		NoteResult<List<Department>> res = service.findAllDe();
		return res;
		}
	@RequestMapping("department/delete.do")
	@ResponseBody
	public NoteResult<String> deleted(String department){
		NoteResult<String> res = service.deletede(department);
		return res;
		}
	@RequestMapping("department/save.do")
	@ResponseBody
	public NoteResult<String> savede(String department){
		NoteResult<String> res = service.savede(department);
		return res;
		}
}

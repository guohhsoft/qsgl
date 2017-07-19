package czxy.qsgl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.qsgl.entity.Dormitory;
import czxy.qsgl.entity.Student;
import czxy.qsgl.service.DormitoryService;
import czxy.qsgl.util.NoteResult;

@Controller
public class dormitoryController {
	@Resource(name="dormitoryService")
	private DormitoryService service;
	@RequestMapping("dormitory/save.do")
	@ResponseBody
	public NoteResult<String> save(String sushehao,String louhao,String department,int max,String depict){
		NoteResult<String> res = service.save(sushehao, louhao, department, max, depict);
		return res;
	}
	@RequestMapping("dormitory/search.do")
	@ResponseBody
	public NoteResult<List<Dormitory>> search(String sushehao,String louhao){
		System.out.println(sushehao+louhao);
		NoteResult<List<Dormitory>> res = service.search(louhao,sushehao);
		return res;
	}
	@RequestMapping("dormitory/find.do")
	@ResponseBody
	public NoteResult<List<Dormitory>> find(String louhao){
		NoteResult<List<Dormitory>> res = service.find(louhao);
		return res;
	}
	@RequestMapping("dormitory/update.do")
	@ResponseBody
	public NoteResult<String> update(String sushehao,String louhao,String department,String max,String depict){
		int size = Integer.parseInt(max);
		NoteResult<String> res = service.update(sushehao, louhao, department, size, depict);
		return res;
	}
	@RequestMapping("dormitory/findStudent.do")
	@ResponseBody
	public NoteResult<List<Student>> findStudent(String sushehao,String louhao){
		NoteResult<List<Student>> res = service.chakan(louhao, sushehao);
		return res;
	}
}

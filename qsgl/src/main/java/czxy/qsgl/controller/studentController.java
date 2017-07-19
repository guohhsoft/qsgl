package czxy.qsgl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.qsgl.entity.Student;
import czxy.qsgl.service.StudentService;
import czxy.qsgl.util.NoteResult;

@Controller
public class studentController {
	@Resource(name="StudentService")
	private StudentService service;

	@RequestMapping("/findsAll.do")  
	@ResponseBody                 
	public NoteResult<List<Student>> findsAll(String department){
		NoteResult<List<Student>> res = service.findAll(department);
		return res;
	}

	@RequestMapping("/serachstudent.do")  
	@ResponseBody               
	public NoteResult<List<Student>> serachstudent(String name){
		NoteResult<List<Student>> res = service.search(name);
		return res;
	}
	@RequestMapping("/savestudent.do")
	@ResponseBody
	public NoteResult<String> savestudent(String studentId, String name, String sex,
			String addr, String department, String louhao, String sushehao){
		NoteResult<String> res= service.save(studentId, name, sex, addr, department, louhao, sushehao);
		return res;
	}
	@RequestMapping("/updatestudent.do")
	@ResponseBody
	public NoteResult<String> updatestudent(String studentId, String name, String sex,
			String addr, String department, String louhao, String sushehao){
		NoteResult<String> res= service.updata(studentId, name, sex, addr, department, louhao, sushehao);
		return res;
	}
	@RequestMapping("/deletestudent.do")
	@ResponseBody
	public NoteResult<String> deletestudent(String studentId){
		NoteResult<String> res= service.delete(studentId);
		return res;
	}
}

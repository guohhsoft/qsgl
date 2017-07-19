package czxy.qsgl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import czxy.qsgl.dao.studentDao;
import czxy.qsgl.entity.Student;
import czxy.qsgl.util.NoteResult;
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
	@Resource
	private studentDao sd;
	public NoteResult<List<Student>> findAll(String department) {
		List<Student> list = sd.findAll(department);
		NoteResult<List<Student>> res = new NoteResult<List<Student>>();
		res.setMsg("查询成功");
		res.setData(list);
		return res;
	}

	public NoteResult<List<Student>> search(String name) {
		List<Student> list = sd.search(name);
		//System.out.println(list.size());
		//System.out.println("*************************************");
		NoteResult<List<Student>> res = new NoteResult<List<Student>>();
		if(list.size()!=0){
			res.setData(list);
			res.setMsg("搜查成功");
			res.setStatus(1);
		}else{
			res.setStatus(0);
		}
		return res;
	}

	public NoteResult<String> save(String studentId, String name, String sex,
			String addr, String department, String louhao, String sushehao) {
			NoteResult<String> res = new NoteResult<String>();
			List<Student> list =  sd.search(studentId);
			if(list.size()!=0){
				res.setStatus(0);
				res.setMsg("学号被占用");
				return res;
			}
			Student student = new Student();
			student.setStudentId(studentId);
			student.setAddr(addr);
			student.setDepartment(department);
			student.setLouhao(louhao);
			student.setSex(sex);
			student.setSushehao(sushehao);
			student.setName(name);
			int count = sd.save(student);
			if(count!=1){
				res.setStatus(0);
			}else{
				res.setMsg("添加成功");
				res.setStatus(1);
			}
			
			
		return res;
	}

	public NoteResult<String> updata(String studentId,String name, String sex, String addr,
			String department, String louhao, String sushehao) {
		Student s = sd.findById(studentId);
		s.setAddr(addr);
		s.setDepartment(department);
		s.setLouhao(louhao);
		s.setSex(sex);
		s.setSushehao(sushehao);
		s.setName(name);
		int count = sd.updata(s);
		NoteResult<String> res = new NoteResult<String>();
		if(count!=1){
			res.setStatus(0);
			res.setMsg("更新失败");
		}else{
			res.setStatus(1);
			res.setMsg("更新成功");
		}
		
			
		return res;
	}

	public NoteResult<String> delete(String studentId) {
		int count = sd.delete(studentId);
		NoteResult<String> res = new NoteResult<String>();
		if(count!=1){
			res.setStatus(0);
		}else{
			res.setStatus(1);
			res.setMsg("删除成功");
			
		}
		return res;
	}

}

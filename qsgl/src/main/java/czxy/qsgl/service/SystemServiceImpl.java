package czxy.qsgl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import czxy.qsgl.dao.systemDao;
import czxy.qsgl.entity.Department;
import czxy.qsgl.entity.Louhao;
import czxy.qsgl.util.NoteResult;
import czxy.qsgl.util.NoteUtil;
@Service("systemService")
public class SystemServiceImpl implements SystemService{
@Resource
private systemDao dao;
	public NoteResult<String> savelou(String louhao) {
		String id = NoteUtil.createId();
		Louhao lou = new Louhao();
		lou.setId(id);
		lou.setLouhao(louhao);
		int count =dao.savel(lou);
		NoteResult<String> res = new NoteResult<String>();
		if(count!=1){
			res.setMsg("保存失败");
		}else{
			res.setMsg("保存成功");
		}
		
				return res;
	}

	public NoteResult<String> savede(String department) {
		String id = NoteUtil.createId();
		Department de = new Department();
		de.setId(id);
		de.setDepartment(department);
		int count = dao.saved(de);
		NoteResult<String> res = new NoteResult<String>();
		if(count!=1){
			res.setMsg("保存失败");
		}else{
			res.setMsg("保存成功");
		}
		
				return res;
	}

	public NoteResult<String> deletelou(String louhao) {
		NoteResult<String> res = new NoteResult<String>();
		int count = dao.deletel(louhao);
		if(count!=1){
			res.setMsg("删除失败");
		}else{
			res.setMsg("删除成功");
		}
		return res;
	}

	public NoteResult<String> deletede(String department) {
		NoteResult<String> res = new NoteResult<String>();
		int count = dao.deleted(department);
		if(count!=1){
			res.setMsg("删除失败");
		}else{
			res.setMsg("删除成功");
		}
		return res;
	}

	public NoteResult<List<Louhao>> findAllLou() {
		List<Louhao> list = dao.findAlllou();
		NoteResult<List<Louhao>>  res = new NoteResult<List<Louhao>>();
		res.setData(list);
		return res;
	}

	public NoteResult<List<Department>> findAllDe() {
		List<Department> list = dao.findAllde();
		NoteResult<List<Department>>  res = new NoteResult<List<Department>>();
		res.setData(list);
		return res;
	}
	
}

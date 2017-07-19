package czxy.qsgl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.qsgl.dao.DormitoryDao;
import czxy.qsgl.entity.Dormitory;
import czxy.qsgl.entity.Student;
import czxy.qsgl.util.NoteResult;
import czxy.qsgl.util.NoteUtil;
@Service("dormitoryService")
public class DormitoryServiceImpl implements DormitoryService {
@Resource
private DormitoryDao dd;
//查询
	public NoteResult<List<Dormitory>> search(String louhao,String msg) {
		Map<String, String> map = new HashMap<String, String>();
		NoteResult<List<Dormitory>> res= new NoteResult<List<Dormitory>>();
		
		map.put("louhao",louhao);
		map.put("sushehao", msg);
		map.put("department", msg);
		System.out.println("*********************");
		System.out.println(map);
		List<Dormitory> list= dd.search(map);
		System.out.println(list.size());
		if(list.size()!=0){
			res.setStatus(1);
			res.setData(list);
		}else{
			res.setStatus(0);
		}
			
				return res;
	}
//增加
	public NoteResult<String> save(String sushehao, String louhao,String department, int max, String depict) {
		Dormitory dm = new Dormitory();
		String id = NoteUtil.createId();
		dm.setId(id);
		dm.setSushehao(sushehao);
		dm.setLouhao(louhao);
		dm.setDepartment(department);
		dm.setDepict(depict);
		dm.setMax(max);
		dm.setNow(0);
		NoteResult<String> res = new NoteResult<String>();
		int count= dd.save(dm);
		if(count!=1){
			res.setStatus(0);
			res.setMsg("保存失败");
		}else{
			res.setStatus(1);
			res.setMsg("保存成功");
		}
		
		return res;
	}
	public NoteResult<List<Dormitory>> find(String louhao) {
		NoteResult<List<Dormitory>> res = new NoteResult<List<Dormitory>>();
		List<Dormitory> list = dd.find(louhao);
		
		//List<Student> lists = dd.chakan(map);
		res.setStatus(1);
		res.setData(list);
		return res;
	}

	public NoteResult<String> update(String sushehao, String louhao ,String department, int max, String depict) {
		Map<String,String> map = new HashMap<String, String>();
		NoteResult<String> res = new NoteResult<String>();
		map.put("louhao", louhao);
		map.put("sushehao", sushehao);
		List<Dormitory> list = dd.search(map);
		Dormitory dt = list.get(0);
		dt.setDepartment(department);
		dt.setDepict(depict);
		dt.setMax(max);
		int count = dd.update(dt);
		if(count!=1){
			res.setStatus(0);
			res.setMsg("更新失败");
		}else{
			res.setStatus(1);
			res.setMsg("更新成功");
		}
		return res;
	}
	public NoteResult<List<Student>> chakan(String louhao, String sushehao) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sushehao", sushehao);
		map.put("louhao", louhao);
		List<Student> list = dd.chakan(map);
		NoteResult<List<Student>> res = new NoteResult<List<Student>>();
		res.setData(list);
		return res;
	}

}

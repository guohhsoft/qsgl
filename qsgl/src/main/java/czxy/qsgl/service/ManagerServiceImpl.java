package czxy.qsgl.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import czxy.qsgl.dao.managerDao;
import czxy.qsgl.entity.Manager;
import czxy.qsgl.util.NoteResult;
import czxy.qsgl.util.NoteUtil;
@Service("ManagerService")
@Transactional
public class ManagerServiceImpl implements ManagerService{
	@Resource
	private managerDao mg;
//修改密码(有个缺陷  不能验证原密码的正确性)
	public NoteResult<String> updata(String password,String name,String tel) {
		NoteResult<String> result = new NoteResult<String>();
		Manager m  = mg.findByName(name);
//		if(m.getPassword().equals(password)==false){
//			result.setStatus(1);
//			result.setMsg("原密码错误");
//			return result;
//		}
		m.setPassword(password);
		m.setTelephone(tel);
		int count  = mg.updata(m);
		if(count==1){
			result.setStatus(0);
			result.setMsg("更新成功");
		}
		else {
			result.setMsg("更新失败");
			result.setStatus(1);
		}
			return result;
	}

//删除管理员
	public NoteResult<String> delete(String name) {
		int count = mg.delete(name);
		NoteResult<String> result = new NoteResult<String>();
		if(count==1){
			result.setStatus(1);
			result.setMsg("删除成功");
		}
		else {
			result.setMsg("删除失败");
			result.setStatus(0);
		}
			return result;
		
	}
//查询管理员
	public NoteResult<Manager> findByName(String name) {
		Manager m = mg.findByName(name);
		NoteResult<Manager> result = new NoteResult<Manager>();
		if(m==null){
			result.setStatus(0);
			//result.setMsg("账号不存在");
			
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("账号存在");
			result.setData(m);
			return result;
		}
	}
////增加管理员
	public NoteResult<String> save(String name, String password, String telephone,
			String job, int quanxian,String louhao,String sushehao) {
		//创建id
		Manager manager = new Manager();
		String id = NoteUtil.createId();
		manager.setId(id);
		manager.setName(name);
		manager.setPassword(password);
		manager.setJob(job);
		manager.setQuanxian(quanxian);
		manager.setTelephone(telephone);
		manager.setLouhao(louhao);
		manager.setSushehao(sushehao);
		int count =mg.save(manager);
		NoteResult<String> result = new NoteResult<String>();
		if(count==1){
			result.setStatus(0);
			result.setMsg("保存成功");
		}
		else {
			result.setMsg("保存失败");
			result.setStatus(1);
		}
			return result;
	}
//超级管理员对管理员信息的修改
	public NoteResult<String> updatem(String id,String name,String password,String telephone,String job,int quanxian,String louhao) {
		Manager manager = new Manager();
		manager.setId(id);
		manager.setName(name);
		manager.setLouhao(louhao);
		manager.setJob(job);
		manager.setPassword(password);
		manager.setQuanxian(quanxian);
		manager.setTelephone(telephone);
		manager.setSushehao("101");
		int count = mg.updatem(manager);
		NoteResult<String> result = new NoteResult<String>();
		if(count==1){
			result.setStatus(0);
			result.setMsg("更新成功");
		}
		else {
			result.setMsg("更新失败");
			result.setStatus(1);
		}
			return result;
	}

//
//  查询全部的管理员信息    -------------用于加载每页的信息
	public NoteResult<List<Manager>> findByAll() {
		List<Manager> list = mg.findByAll();
		NoteResult<List<Manager>> res = new NoteResult<List<Manager>>();
		if(list.size()==0){
			res.setStatus(0);
			res.setMsg("查询出错");
		}else{
			res.setStatus(1);
			res.setMsg("查询成功");
			res.setData(list);
			
		}
		
		return res;
	}
//  查询信息
	public NoteResult<List<Manager>> search(String name) {
			NoteResult<List<Manager>> res = new NoteResult<List<Manager>>();
			List<Manager> list = mg.search(name);
			if(list.size()!=0){
				res.setStatus(1);
				res.setMsg("搜索成功");
				res.setData(list);
			}else{
				res.setStatus(0);
			}
		return res;
	}
}

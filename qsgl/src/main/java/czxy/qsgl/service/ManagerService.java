package czxy.qsgl.service;

import java.util.List;

import czxy.qsgl.entity.Manager;
import czxy.qsgl.util.NoteResult;

public interface ManagerService {
	NoteResult<String> save(String name,String password,String telephone,String job,int quanxian,String louhao,String sushehao);//增加管理员功能
	NoteResult<String>updata(String password,String name,String tel);//修改管理员功能
	NoteResult<String> delete(String name);//删除管理员
	NoteResult<Manager> findByName(String name);//通过名字查询管理员
	//超级管理员进行修改信息
	NoteResult<String> updatem(String id,String name,String password,String telephone,String job,int quanxian,String louhao);
	NoteResult<List<Manager>> findByAll();
	NoteResult<List<Manager>> search(String name);

}

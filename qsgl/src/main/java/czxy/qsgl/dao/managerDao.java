package czxy.qsgl.dao;

import java.util.List;

import czxy.qsgl.entity.Manager;
import czxy.qsgl.util.NoteResult;

public interface managerDao {
	int save(Manager manager);//增加管理员功能
	int updata(Manager manager);//修改管理员功能  +++++++（修改密码）+++++++++
	int delete(String name);//删除管理员 ++++++++++++++++++
	Manager findByName(String name);//通过名字查询管理员   +++++
	//管理员对信息进行修改
	int updatem(Manager manager);
	List<Manager> findByAll();//查询所有的管理员  +++++++++++
	List<Manager>  search(String name);//  搜索信息+++++++++++
}

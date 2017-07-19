package czxy.qsgl.dao;

import czxy.qsgl.entity.Manager;

public interface loginDao {
	  Manager findByName(String name);
	  void save(Manager manager);

}

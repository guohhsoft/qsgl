package czxy.qsgl.dao;

import java.util.List;

import czxy.qsgl.entity.Department;
import czxy.qsgl.entity.Louhao;

public interface systemDao {
	int savel(Louhao louhao);
	List<Louhao> findAlllou();
	int deletel(String louhao);
	
	int saved(Department department);
	List<Department> findAllde();
	int deleted(String department);
}

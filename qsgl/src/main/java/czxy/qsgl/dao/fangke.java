package czxy.qsgl.dao;

import java.util.List;
import java.util.Map;

import czxy.qsgl.entity.FangKe;

public interface fangke {
	int save(FangKe fangke);
	List<FangKe> search(String time);
	int delete(String time);
	List<FangKe> findAll();
	int update(Map<String,String> map);
}

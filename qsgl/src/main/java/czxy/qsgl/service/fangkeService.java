package czxy.qsgl.service;

import java.util.List;

import czxy.qsgl.entity.FangKe;
import czxy.qsgl.util.NoteResult;

public interface fangkeService {
	NoteResult<String> save(String LFname,String Idcard,String louhao,String sushehao,String BFname,String reson,String telephone);
	NoteResult<List<FangKe>> search(String time);
	NoteResult<String> delete(String time);
	NoteResult<List<FangKe>> findAll();
	NoteResult<String> update(String time);
}

package czxy.qsgl.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import czxy.qsgl.dao.fangke;
import czxy.qsgl.entity.FangKe;
import czxy.qsgl.util.NoteResult;
import czxy.qsgl.util.NoteUtil;
@Service("fangkeService")
public class fangkeServiceImpl implements fangkeService {
@Resource
private fangke fangke;
	public NoteResult<String> save(String LFname,String Idcard,String louhao,String sushehao,String BFname,String reson,String telephone) {
		NoteResult<String> res = new NoteResult<String>();
		FangKe fk = new FangKe();
		String id = NoteUtil.createId();
		fk.setId(id);
		fk.setIdcard(Idcard);
		fk.setBFname(BFname);
		fk.setLFname(LFname);
		fk.setReson(reson);
		fk.setTime1("");
		fk.setTelephone(telephone);
		fk.setLouhao(louhao+"号楼");
		fk.setSushehao(sushehao);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		fk.setTime(time);
		int count = fangke.save(fk);
		if(count!=1){
			res.setStatus(0);
			res.setMsg("保存失败");
		}else{
			res.setStatus(1);
			res.setMsg("保存成功");
		}
		
		return null;
	}

	public NoteResult<List<FangKe>> search(String time) {
		NoteResult<List<FangKe>> res = new NoteResult<List<FangKe>>();
		List<FangKe> list = fangke.search(time);
		if(list.size()!=0){
			res.setStatus(1);
			res.setData(list);
		}else{
			res.setStatus(0);
			res.setMsg("搜索失败");
		}
		return res;
	}
	public NoteResult<String> delete(String time) {
		NoteResult<String> res = new NoteResult<String>();
		int count = fangke.delete(time);
		if(count!=1){
			res.setStatus(0);
			res.setMsg("删除失败");
		}else{
			res.setStatus(1);
		}
		return res;
	}

	public NoteResult<List<FangKe>> findAll() {
		NoteResult<List<FangKe>> res = new NoteResult<List<FangKe>>();
		List<FangKe> list = fangke.findAll();
		if(list.size()!=0){
			res.setStatus(1);
			res.setData(list);
		}else{
			res.setStatus(0);
			res.setMsg("搜索失败");
		}
		return res;
	}

	public NoteResult<String> update(String time) {
		NoteResult<String> res = new NoteResult<String>();
		Map<String,String> map = new HashMap<String, String>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time1 = sdf.format(date);
		map.put("time", time);
		map.put("time1", time1);
		int count = fangke.update(map);
		if(count != 1){
			res.setMsg("记录失败");
		}else{
			res.setMsg("保存成功");
		}
		return res;
	}

}

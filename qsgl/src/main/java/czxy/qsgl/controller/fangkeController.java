package czxy.qsgl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czxy.qsgl.entity.FangKe;
import czxy.qsgl.service.fangkeService;
import czxy.qsgl.util.NoteResult;

@Controller
public class fangkeController {
	@Resource(name="fangkeService")
	private fangkeService service;
	@RequestMapping ("fangke/save.do")
	@ResponseBody
	public NoteResult<String> save(String LFname,String Idcard,String louhao,String sushehao,String BFname,String reson,String telephone){
		NoteResult<String> res = service.save(LFname, Idcard, louhao, sushehao, BFname, reson, telephone);
		return res;
	}
	@RequestMapping("fangke/search.do")
	@ResponseBody
	public NoteResult<List<FangKe>> search(String time){
		NoteResult<List<FangKe>> res = service.search(time);
		return res;
	}
	@RequestMapping("fangke/delete.do")
	@ResponseBody
  	public NoteResult<String> delete(String time){
		NoteResult<String> res = service.delete(time);
		return res;
	}
	@RequestMapping("fangke/findAll.do")
	@ResponseBody
	public NoteResult<List<FangKe>> findAll(){
		NoteResult<List<FangKe>> res = service.findAll();
		return res;
	}
	@RequestMapping("fangke/update.do")
	@ResponseBody
	public NoteResult<String> update(String time){
		NoteResult<String> res = service.update(time);
		return res;
	}
	}


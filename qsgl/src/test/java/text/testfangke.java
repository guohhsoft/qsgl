package text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import czxy.qsgl.dao.fangke;
import czxy.qsgl.entity.FangKe;
import czxy.qsgl.service.fangkeService;
import czxy.qsgl.util.NoteResult;

public class testfangke {
	String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
	@Test
	public void save(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		fangke fangke = ac.getBean("fangke",fangke.class);
		FangKe fk = new  FangKe();
		fk.setId("124");
		fk.setLFname("李四");
		fk.setIdcard("142622199407282828");
		fk.setBFname("瑞瑞");
		fk.setLouhao("6号楼");
		fk.setSushehao("602");
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		System.out.println(time);
		fk.setTime(time);
		fk.setReson("学习经验");
		fk.setTelephone("110");
		fangke.save(fk);
		
		
	}
	@Test
	public void search(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		fangke fangke = ac.getBean("fangke",fangke.class);
		List<FangKe> list= fangke.search("2017-05-16");
		System.out.println(list.size());
	}
	@Test
	public void searchs(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		fangkeService  fs = ac.getBean("fangkeService",fangkeService.class);
		NoteResult<List<FangKe>> res= fs.search("2017-05-16");
		System.out.println(res.getStatus());
		for(FangKe f : res.getData()){
			System.out.println(f);
		}
	}
}

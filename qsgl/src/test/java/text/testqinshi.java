package text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import czxy.qsgl.controller.dormitoryController;
import czxy.qsgl.dao.DormitoryDao;
import czxy.qsgl.dao.fangke;
import czxy.qsgl.entity.Dormitory;
import czxy.qsgl.entity.FangKe;
import czxy.qsgl.service.DormitoryService;
import czxy.qsgl.util.NoteResult;

public class testqinshi {
	String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
	@Test
	public void search(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DormitoryDao dd = ac.getBean("dormitoryDao",DormitoryDao.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("louhao", "1");
		map.put("sushehao", "101");
		map.put("department", "101");
		System.out.println(map);
		System.out.println("##############33");
		List<Dormitory> list= dd.search(map);
		System.out.println(list.size());
		for(Dormitory d :list){
			System.out.println(d);
		}
	}
	
	@Test
	public void update(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DormitoryDao dd = ac.getBean("dormitoryDao",DormitoryDao.class);
		Dormitory ddd = new Dormitory();
		ddd.setDepartment("hdas");
		ddd.setId("111111");
		ddd.setLouhao("2");
		ddd.setSushehao("101");
		ddd.setMax(100);
		ddd.setNow(123);
		ddd.setDepict("dasda");
		int count = dd.update(ddd);
		System.out.println(count);
		
		
	}
	@Test
	public void searchs(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DormitoryService ds = ac.getBean("dormitoryService",DormitoryService.class);
		NoteResult<List<Dormitory>> res = ds.search("1", "101");
		System.out.println(res.getData().size());

	}
	@Test
	public void findlou(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DormitoryService ds = ac.getBean("dormitoryService",DormitoryService.class);
		NoteResult<List<Dormitory>> res = ds.find("1");
		System.out.println(res.getData().size());
		for(Dormitory d :res.getData()){
			System.out.println(d);
		}

	}
	@Test
	public void uo(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DormitoryService ds = ac.getBean("dormitoryService",DormitoryService.class);
		NoteResult<List<Dormitory>> res = ds.find("1");
		System.out.println(res.getData().size());
		for(Dormitory d :res.getData()){
			System.out.println(d);
		}

	}
}

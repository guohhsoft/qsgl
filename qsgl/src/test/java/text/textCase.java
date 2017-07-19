package text;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import czxy.qsgl.dao.loginDao;
import czxy.qsgl.dao.managerDao;
import czxy.qsgl.entity.Manager;
import czxy.qsgl.service.LoginService;
import czxy.qsgl.service.ManagerService;
import czxy.qsgl.util.NoteResult;


public class textCase {
	String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
	@Test
	public void testLoginDao(){
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	loginDao dao  = ac.getBean("loginDao",loginDao.class);
	Manager man = dao.findByName("admin");
	System.out.println(man);
	}
	@Test
	public void testsave(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Manager m = new Manager();
		m.setId("000");
		m.setName("haha");
		m.setJob("主任");
		m.setPassword("123");
		m.setTelephone("110");
		m.setQuanxian(0);
		m.setLouhao("111");
		System.out.println(m);
		managerDao dao  = ac.getBean("managerDao",managerDao.class);
		int count= dao.save(m);
		System.out.println(count);
		
	}
	@Test
	public void testService(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        LoginService login = ac.getBean("LoginService",LoginService.class);
		NoteResult<Manager> man = login.checkLogin("ain", "admin");
		System.out.println(man.getData());
		
	}
	@Test
	public void testManager(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
       managerDao m = ac.getBean("managerDao",managerDao.class);
		Manager mmm= m.findByName("张三");
		System.out.println(mmm);
	}
	@Test
	public void testM2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	       managerDao m = ac.getBean("managerDao",managerDao.class);
		   Manager man = m.findByName("张三");
		   System.out.println(man);
		   man.setPassword("111111");
		   man.setTelephone("999999");
		   m.updata(man);
		   Manager mmm= m.findByName("张三");
		   System.out.println(mmm);
		
	}
	@Test
	public void textAll(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	       managerDao m = ac.getBean("managerDao",managerDao.class);
	       List<Manager> list = m.findByAll();
	       for(Manager mm:list){
	    	   System.out.println(mm);
	       }
	}
	@Test
	public void textdel(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	       managerDao m = ac.getBean("managerDao",managerDao.class);
	     int count = m.delete("haha");
	     System.out.println(count);
	}
	@Test
	public void textAllservice(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	       ManagerService ms = ac.getBean("ManagerService",ManagerService.class);
	       NoteResult<List<Manager>> res  = ms.findByAll();
	       System.out.println(res.getMsg());
	}
	@Test
	public void textdelservice(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	       ManagerService ms = ac.getBean("ManagerService",ManagerService.class);
	       NoteResult<String> res  = ms.delete("张三");
	       System.out.println(res.getMsg());
	}
	@Test
	public void textsea(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	       managerDao m = ac.getBean("managerDao",managerDao.class);
	      List<Manager> res = m.search("国宏宏");
	       System.out.println(res.size());
	       Manager manager = res.get(0);
	       System.out.println(manager);
	}
	@Test
	public void textseaservice(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	       ManagerService ms = ac.getBean("ManagerService",ManagerService.class);
	       NoteResult<List<Manager>> res = ms.search("国宏宏");
	       System.out.println(res.getStatus());
	}
	@Test
	public void textaddservice(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		  ManagerService ms = ac.getBean("ManagerService",ManagerService.class);
		  NoteResult<String> res = ms.save("哈哈哈哈啊哈哈", "123456", "100", "主任", 0, "6","101");
		  System.out.println(res.getMsg());
		
	}
	@Test
	public void testM(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	       managerDao m = ac.getBean("managerDao",managerDao.class);
		   Manager man = m.findByName("张三");
		   System.out.println(man);
		   man.setPassword("111111");
		   man.setTelephone("999999");
		   man.setQuanxian(0);
		   m.updatem(man);
		   Manager mmm= m.findByName("张三");
		   System.out.println(mmm);
		
	}
}

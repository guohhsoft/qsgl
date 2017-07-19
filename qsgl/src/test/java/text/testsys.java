package text;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import czxy.qsgl.dao.systemDao;
import czxy.qsgl.entity.Department;
import czxy.qsgl.entity.Louhao;

public class testsys {
	String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	systemDao dao = ac.getBean("systemDao",systemDao.class);
	@Test
	public void savel(){
		Louhao lou = new Louhao();
		lou.setId("1");
		lou.setLouhao("1号楼");
		int count = dao.savel(lou);
		System.out.println(count);
		
	}
	@Test
	public void saved(){
		Department de = new Department();
		de.setId("1");
		de.setDepartment("计算机系");
		int count = dao.saved(de);
		System.out.println(count);
		
	}
	@Test
	public void findAlllou(){
		List<Louhao> list = dao.findAlllou();
		System.out.println(list.size());
		for(Louhao lou :list){
			System.out.println(lou);
		}
		
	}
	@Test
	public void del(){
		
		int count = dao.deletel("1号楼");
		System.out.println(count);
		
	}
}

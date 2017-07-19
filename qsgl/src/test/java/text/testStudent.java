package text;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import czxy.qsgl.entity.Student;
import czxy.qsgl.service.StudentService;
import czxy.qsgl.util.NoteResult;


public class testStudent {
	String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
	@Test
	public void studentfindAll(){
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	StudentService ss = ac.getBean("StudentService",StudentService.class);
	NoteResult<List<Student>> res = ss.findAll("计算机");
	System.out.println(res.getMsg());
	System.out.println(res.getData().size());
	for(Student s :res.getData()){
		System.out.println(s);
	}
	}
	@Test
	public void studentsearch(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		StudentService ss = ac.getBean("StudentService",StudentService.class);
		String msg ="张三";
		NoteResult<List<Student>> res = ss.search(msg);
		for(Student s : res.getData()){
			System.out.println(s);
		}
		
	}
	@Test
	public void studentsave(){
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	StudentService ss = ac.getBean("StudentService",StudentService.class);
	NoteResult<String> res = ss.save("13407255","张娟", "女", "山西省晋中市", "计算机", "100", "5");
	System.out.println(res.getMsg());
	}
	@Test
	public void studentdel(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		StudentService ss = ac.getBean("StudentService",StudentService.class);
		NoteResult<String> res = ss.delete("13407255");
		System.out.println(res.getMsg());
	}
	@Test
	public void studentup(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		StudentService ss = ac.getBean("StudentService",StudentService.class);
		NoteResult<String> res = ss.updata("13407255", "瑞瑞", "男", "山西省忻州市", "外语系", "6", "611");
		System.out.println(res.getMsg());
	}
}

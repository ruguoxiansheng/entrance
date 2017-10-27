package myAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAnnotationTest {

	public static void main(String[] args) {
		 AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext("myAnnotation");
		 
		 // 设置扫描路径
//		 acc.scan("myAnnotation");
//		 acc.refresh();
		 HelloClass injectClass = acc.getBean(HelloClass.class);
		 injectClass.print();


	}

}

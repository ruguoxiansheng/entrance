package mydefineComponent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyDefineComponentTest {

	public static void main(String[] args) {
		 AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext("mydefineComponent");
		 ScanClass1 scanClass = acc.getBean(ScanClass1.class);
		 scanClass.print();
	}

}

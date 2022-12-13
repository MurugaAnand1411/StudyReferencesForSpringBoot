package spring.training.trdmthdemo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.training.trdmthdemo.services.MyDeskService;

@SpringBootApplication
public class trdMthDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(trdMthDemoApplication.class, args);
		
		ApplicationContext context = (ApplicationContext) SpringApplication.run(trdMthDemoApplication.class, args);
		MyDeskService service = ((BeanFactory) context).getBean(MyDeskService.class);
		
		service.modifyEntities();
		
		service.queryEntities();
		
	}

}

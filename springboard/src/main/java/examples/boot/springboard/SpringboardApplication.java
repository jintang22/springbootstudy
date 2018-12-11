package examples.boot.springboard;


import examples.boot.ServerInfo;
import examples.boot.springboard.application.MyListner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;

/**
 * @SpringBootApplication 어노테이션이 설정된 class의 하위 패키지의 bean을 검색해서 설정한다.
 * - dispatcher 도 이때 설정
 */
@SpringBootApplication
public class SpringboardApplication implements CommandLineRunner {

	@Autowired
	ServerInfo serverInfo;

//	@Bean
//	ServerInfo serverInfo() {
//		ServerInfo serverInfo = new ServerInfo();
//		serverInfo.setPort(1111);
//		serverInfo.setAddress("111.111.111.111");
//		return serverInfo;
//	}


	@Override
	public void run(String... args) throws Exception {

		System.out.println("----------------------");
		System.out.println(serverInfo.getPort());
		System.out.println(serverInfo.getAddress());
		System.out.println("----------------------");


	}

	public static void main(String[] args) {


		SpringApplication springApplication = new SpringApplication(SpringboardApplication.class);

		// application.properties 파일에 다음을 설정
		// spring.id.file=test.pid
		springApplication.addListeners(new ApplicationPidFileWriter());
		springApplication.addListeners(new MyListner());
		springApplication.run(args);

		//SpringApplication.run(SpringboardApplication.class, args);
	}
}

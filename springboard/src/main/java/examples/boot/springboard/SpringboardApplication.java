package examples.boot.springboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 어노테이션이 설정된 class의 하위 패키지의 bean을 검색해서 설정한다.
 * - dispatcher 도 이때 설정
 */
@SpringBootApplication
public class SpringboardApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringboardApplication.class, args);
	}
}

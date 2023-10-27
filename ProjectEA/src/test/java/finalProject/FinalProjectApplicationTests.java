package finalProject;

import finalProject.controller.CustomerControllerTest;
import finalProject.repository.CustomerRepositoryTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({

		CustomerControllerTest.class,
//		CustomerServiceTest.class,
		CustomerRepositoryTest.class
})
@SpringBootTest
class FinalProjectApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

}



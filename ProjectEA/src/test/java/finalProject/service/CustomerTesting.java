package finalProject.service;

import finalProject.domain.Customer;
import finalProject.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTesting {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepo;

    @Before
    public void setUp() {
        String email = "email1@email.com";
        Optional<Customer> customer = Optional.of(new Customer(email));
        Mockito.when(customerRepo.findByEmail(email))
                .thenReturn(customer);
    }

    @Test
    public void whenValidEmail() {
        String email = "email1@email.com";
        Optional<Customer> found = customerService.findByEmail(email);
        if (found.isPresent())
         assertThat(found.get().getEmailAddress(), equalTo(email));
        else assertThat(true, equalTo(false));

    }

}

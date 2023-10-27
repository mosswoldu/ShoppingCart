package finalProject.controller;

import finalProject.domain.Customer;
import finalProject.dto.CustomerDTO;
import finalProject.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.security.auth.login.AccountException;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountException.class)
public class CustomerControllerTest {
    @Autowired
    MockMvc mock;

    @MockBean
    CustomerService customerService;

    @Test
    public void testGetCustomer() throws Exception {

        Customer customer = new Customer("mail");
        Mockito.when(customerService.findByEmail("email"))
                .thenReturn(Optional.of(customer));

        mock.perform(get("/customers/mail"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetCustomerById() throws Exception {
        CustomerDTO customer = new CustomerDTO();
        customer.setId(1);
        Mockito.when(customerService.getCustomerById(1))
                .thenReturn(customer);

        mock.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }
}

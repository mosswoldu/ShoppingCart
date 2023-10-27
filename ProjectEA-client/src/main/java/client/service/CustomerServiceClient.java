package client.service;

import client.dto.CustomerDTO;
import client.dto.CustomersDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceClient {
    RestTemplate restTemplate = new RestTemplate();
    @Value("${api-client.url}")
    private String serverUrl;

    public CustomersDTO getCustomers() {
        CustomersDTO accountDTO = restTemplate.getForObject(serverUrl + "customers", CustomersDTO.class);
        return accountDTO;
    }

    public CustomerDTO getCustomerById(int id){
        CustomerDTO customer = restTemplate.getForObject(serverUrl+"customers/{id}", CustomerDTO.class, id);
        return customer;
    }

    public CustomerDTO saveCustomer(CustomerDTO customer){
        restTemplate.postForLocation(serverUrl + "customers", customer);
        return customer;
    }

}

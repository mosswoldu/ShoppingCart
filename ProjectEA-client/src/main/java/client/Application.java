package client;

import client.dto.*;
import client.service.CustomerServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	CustomerServiceClient customerServiceClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		saveCustomerMain();
		CustomersDTO customer = customerServiceClient.getCustomers();
		customer.getCustomerDTOList().stream().forEach(System.out::println);
		CustomerDTO customerFind = customerServiceClient.getCustomerById(customer.getCustomerDTOList().get(0).getId());
		System.out.println(customerFind);
	}

	private void saveCustomerMain() {
		PersonalDTO personal = new PersonalDTO();
		personal.setTypeCustomer("personal");
		personal.setEmailAddress("mymail24@mail.com");
		personal.setFirstname("John");
		personal.setLastname("Smith");

		List<AddressDTO> addressList = new ArrayList<>();
		//First Address
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setStateAddress("1000Nth Street");
		addressDTO.setCountry("USA");
		addressDTO.setCity("Fairfield");
		addressDTO.setState("IA");
		addressDTO.setZipCode("52556");
		addressDTO.setDefault(true);

		AddressTypeDTO addressType = new AddressTypeDTO();
		addressType.setName("billing");
		addressType.setId(1);
		addressDTO.setAddressType(addressType);
		addressList.add(addressDTO);

		//Second Address
		addressDTO = new AddressDTO();
		addressDTO.setStateAddress("4000Cathedral Avenue");
		addressDTO.setCountry("USA");
		addressDTO.setCity("Fairfield");
		addressDTO.setState("IA");
		addressDTO.setZipCode("52556");
		addressDTO.setDefault(true);

		addressType = new AddressTypeDTO();
		addressType.setName("shipping");
		addressType.setId(2);
		addressDTO.setAddressType(addressType);
		addressList.add(addressDTO);

		//Third Address
		addressDTO = new AddressDTO();
		addressDTO.setStateAddress("4000Cathedral Avenue");
		addressDTO.setCountry("USA");
		addressDTO.setCity("Washington DC");
		addressDTO.setState("NW");
		addressDTO.setZipCode("20009");
		addressDTO.setDefault(false);

		addressType = new AddressTypeDTO();
		addressType.setName("shipping");
		addressType.setId(2);
		addressDTO.setAddressType(addressType);
		addressList.add(addressDTO);

		//First Credit Card
		CreditCardDTO creditCardDTO = new CreditCardDTO();
		creditCardDTO.setCardNumber(1234567890);
		creditCardDTO.setExpirationDate("07/27");
		creditCardDTO.setSecurityCode("123-9889-0098");

		List<CreditCardDTO> creditCardList = new ArrayList<>();
		creditCardList.add(creditCardDTO);

		creditCardDTO = new CreditCardDTO();
		creditCardDTO.setCardNumber(87965784);
		creditCardDTO.setExpirationDate("07/28");
		creditCardDTO.setSecurityCode("123-9889-1198");
		creditCardList.add(creditCardDTO);

		personal.setAddress(addressList);
		personal.setCreditCard(creditCardList);
		customerServiceClient.saveCustomer(personal);
	}
}

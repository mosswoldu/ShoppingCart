package finalProject.service;

import finalProject.domain.Customer;
import finalProject.domain.Order;
import finalProject.dto.CustomerDTO;
import finalProject.dto.OrderDTO;

import java.util.List;

public interface ICustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    OrderDTO saveOrderByCustomer(int idCustomer, OrderDTO orderDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(int idCustomer);

    List<OrderDTO> getOrderByCustomer(int idCustomer);
    double getTotalByOrder(int idCustomer, int idOrder);

    CustomerDTO updateCustomerById(int idCustomer, CustomerDTO customerDTO);
  
    Customer deleteCustomerById(int idCustomer);

    OrderDTO updateOrderByCustomer(int idCustomer, int idOrder, OrderDTO orderDTO);

    public Order deleteOrderById(int idOrder);
}

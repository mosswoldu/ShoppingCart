package finalProject.service;

import finalProject.config.ExceptionMessage;
import finalProject.domain.*;
import finalProject.dto.*;
import finalProject.repositories.AddressRepository;
import finalProject.repositories.CustomerRepository;
import finalProject.repositories.ItemRepository;
import finalProject.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    AddressRepository addressRepository;

    @Override
    @Transactional
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customerInput;
        if (!validateAddress(customerDTO)) {
            return null;
        }
        if (customerDTO.getClass().getSimpleName().equals("PersonalDTO")) {
            customerInput = mapper.map(customerDTO, Personal.class);
        } else {
            customerInput = mapper.map(customerDTO, Corporate.class);
        }
        Customer customer = customerRepository.save(customerInput);
        return mapper.map(customer, CustomerDTO.class);
    }

    private boolean validateAddress(CustomerDTO customerDTO) {
        long numberShipping = customerDTO.getAddress().stream()
                .filter(a -> a.isDefault() == true && a.getAddressType().getName().equals("shipping")).count();
        if (numberShipping > 1) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public OrderDTO saveOrderByCustomer(int idCustomer, OrderDTO orderDTO) throws ExceptionMessage{
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if(customer == null){
            throw new ExceptionMessage("The customer doesn't exist");
        }
        if(!validateOrderLine(orderDTO)){
            throw new ExceptionMessage("The Item is duplicated in the same Order");
        }
        Order order = mapper.map(orderDTO, Order.class);
        if(!validateOrderLineQuantity(order)){
            throw new ExceptionMessage("The quantity of stock is incorrect");
        }
        order.getOrderLineList().stream().forEach(ol -> {
            Optional<Item> item =itemRepository.findById(ol.getItem().getId());
            if(item.isPresent()){
                if(ol.getQuantity() <= item.get().getQuantityStock()){
                    ol.setItem(item.get());
                }
                else{
                    throw new ExceptionMessage("The quantity is greater than quantity stock");
                }
            }
        });
        customer.getOrderList().add(order);
        Customer orderDb = customerRepository.save(customer);
        return orderDTO;
    }

    private boolean validateOrderLineQuantity(Order order) {
        for(OrderLine ol : order.getOrderLineList()) {
            Optional<Item> item = itemRepository.findById(ol.getItem().getId());
            if(item.isPresent()){
                if(ol.getQuantity() > item.get().getQuantityStock()){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    private boolean validateOrderLine(OrderDTO orderDTO) {
        Set<Integer> items = orderDTO.getOrderLine().stream()
                .map(x -> x.getItem().getId())
                .collect(Collectors.toSet());

        return items.size() == orderDTO.getOrderLine().size();
    }
    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> listCustomer = customerRepository.findAll();
        List<CustomerDTO> list = new ArrayList<>();
        listCustomer.forEach(c -> {
            if(c.getClass().getSimpleName().equals("Personal")){
                list.add(mapper.map(c, PersonalDTO.class));
            }
            else{
                list.add(mapper.map(c, CorporateDTO.class));
            }
        });
        return list;
    }

    @Override
    public CustomerDTO getCustomerById(int idCustomer) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if (customer != null) {
                return mapper.map(customer, CustomerDTO.class);
            }
            return null;
        }


    @Override
    public List<OrderDTO> getOrderByCustomer(int idCustomer) {
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        if(customer.isPresent()){
            List<Order> orderList = customer.get().getOrderList();
            List<OrderDTO> list = new ArrayList<>();
            orderList.forEach(o ->{
                list.add(mapper.map(o, OrderDTO.class));
            });
            return list;
        }
        return null;
    }

    @Override
    public double getTotalByOrder(int idCustomer, int idOrder) {
        return 0;
    }

    @Transactional
    @Override
    public CustomerDTO updateCustomerById(int idCustomer, CustomerDTO customerDTO) { // update email needs
        Customer customer= customerRepository.findById(idCustomer).orElse(null);

        if(customer!=null){
            customer.setEmailAddress(customerDTO.getEmailAddress());
        }
        customerRepository.save(customer);

        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public Customer deleteCustomerById(int idCustomer) {
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        if (customer.isPresent()) {
            customerRepository.deleteById(idCustomer);
            return customer.get();
        }
        return null;
    }

    @Override
    public OrderDTO updateOrderByCustomer(int idCustomer, int idOrder, OrderDTO orderDTO) throws ExceptionMessage{
        List<OrderDTO> list = getOrderByCustomer(idCustomer);
        Optional<OrderDTO> orderDTO1 = list.stream().filter(id -> id.getId() == idOrder).findFirst();
        if (orderDTO1.isPresent()) {
            if(orderDTO1.get().getStatus().getStatus().equals("placed")){
                return null;
            }
            if(orderDTO.getStatus().getStatus().equals(("placed")))
                orderDTO.getOrderLine().stream().forEach(ol -> {
                Optional<Item> item =itemRepository.findById(ol.getItem().getId());
                if(item.isPresent()){
                    if(ol.getQuantity() <= item.get().getQuantityStock()){
                        item.get().setQuantityStock(item.get().getQuantityStock() - ol.getQuantity());
                        ol.setItem(mapper.map(item.get(), ItemDTO.class));
                    }
                    else{
                        throw new ExceptionMessage("The quantity is greater than quantity stock");
                    }
                }
                else{
                    throw new ExceptionMessage("The item doesn't exist");
                }
            });
            orderDTO.setId(orderDTO1.get().getId());
            Order order = mapper.map(orderDTO, Order.class);
            Order orderDB = orderRepository.save(order);
            return mapper.map(orderDB, OrderDTO.class);
        }
        return null;
    }

    @Override
    public Order deleteOrderById(int idOrder) {
        Optional<Order> order = orderRepository.findById(idOrder);
        if (order.isPresent()) {
            orderRepository.deleteById(idOrder);
            return order.get();
        }
        return null;
    }


    public Optional<Customer> findByEmail(String email) {

        return customerRepository.findByEmail(email);
    }
}

package finalProject.service;

import finalProject.config.ExceptionMessage;
import finalProject.domain.Customer;
import finalProject.domain.Item;
import finalProject.domain.Order;
import finalProject.dto.ItemDTO;
import finalProject.dto.OrderDTO;
import finalProject.repositories.CustomerRepository;
import finalProject.repositories.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Item findItemById(int itemId) {
        return mapper.map(itemRepository.findById(itemId).get(),
                Item.class);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> listItems = itemRepository.findAll();
        listItems.stream().map(e -> mapper.map(e, ItemDTO.class));
        return listItems.stream().map(e -> mapper.map(e, ItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int itemId, int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()){
            List<Order> orderList = customer.get().getOrderList();
            List<OrderDTO> list = new ArrayList<>();
            orderList.forEach(o ->{
                list.add(mapper.map(o, OrderDTO.class));
            });
            if (!list.isEmpty()) {
                int count = (int) list.stream().filter(e -> e.getId() == itemId).count();
                if (count < 1) {
                    itemRepository.deleteById(itemId);
                } else {
                    throw new ExceptionMessage("There is an Order");
                }
            }
        } else {
            itemRepository.deleteById(itemId);
        }
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item = itemRepository.save(mapper.map(itemDTO, Item.class));
        return mapper.map(item, ItemDTO.class);
    }

    @Override
    @Transactional
    public Item updateItemById(int id, ItemDTO itemDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
        if(itemDTO.getName() != null) {
            item.setName(itemDTO.getName());
        }
        if(itemDTO.getPrice() != 0) {
            item.setPrice(itemDTO.getPrice());
        }
        if(itemDTO.getBarcodeNumber() != null) {
            item.setBarcodeNumber(itemDTO.getBarcodeNumber());
        }
        if(itemDTO.getImage() != null) {
            item.setImage(itemDTO.getImage());
        }
        if(itemDTO.getDescription() != null) {
            item.setDescription(itemDTO.getDescription());
        }
        if(itemDTO.getQuantityStock() != 0) {
            item.setQuantityStock(itemDTO.getQuantityStock());
        }
        return itemRepository.save(item);
    }
}

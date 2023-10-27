package finalProject.service;

import finalProject.domain.Item;
import finalProject.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    Item findItemById(int id);
  
    List<ItemDTO> getAllItems();
  
    void deleteById(int id, int customerId);

    ItemDTO addItem(ItemDTO item);

    Item updateItemById(int id, ItemDTO itemDTO);

}

package finalProject.controller;

import finalProject.domain.Item;
import finalProject.dto.ItemsDTO;
import finalProject.service.ItemService;
import finalProject.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<?> findAllItems() {
        List<ItemDTO> itemDTOList = itemService.getAllItems();
        ItemsDTO items = new ItemsDTO();
        items.setItemDTOList(itemDTOList);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.findItemById(id);
    }

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody ItemDTO itemDTO){
        itemService.addItem(itemDTO);
        return new ResponseEntity<>(itemDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItemById(@PathVariable int id, @RequestBody ItemDTO itemDTO) {
        Item item = itemService.updateItemById(id, itemDTO);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}/{customerId}")
    public ResponseEntity<?> deleteItem(@PathVariable int itemId, @PathVariable int customerId) {
        itemService.deleteById(itemId, customerId);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}

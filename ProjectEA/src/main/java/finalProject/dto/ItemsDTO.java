package finalProject.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemsDTO {
    private List<ItemDTO> itemDTOList = new ArrayList<>();
    public void setListDTOList(List<ItemDTO> itemDTOList) {
        this.itemDTOList = itemDTOList;
    }
}

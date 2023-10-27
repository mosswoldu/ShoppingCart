package client.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemDTO {
    private int id;
    private String name;
    private String description;
    private double price;
    private String image;//TODO
    private String barcodeNumber;
    private int quantityStock;

    private List<ReviewDTO> reviewList;
    private List<ItemDTO> itemList = new ArrayList<ItemDTO>();
    private List<ItemDTO> itemDTOList = new ArrayList<>();

    public void setListDTOList(List<ItemDTO> itemDTOList) {
        this.itemDTOList = itemDTOList;
    }
}

package domain;

import dto.ItemData;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Item {

    private String itemName;
    private ItemData itemData;
    private List<ItemData> itemDataList;

    @Builder
    public Item(String itemName, ItemData itemData, List<ItemData> itemDataList) {
        this.itemName = itemName;
        this.itemData = itemData;
        this.itemDataList = itemDataList;
    }
}

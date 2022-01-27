package infra;

import domain.Item;
import dto.ItemData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {

    ItemMapper instance = Mappers.getMapper(ItemMapper.class);

    @Mapping(source = "itemName", target = "itemName")
    ItemData mappingItemToDTO(Item item);
}

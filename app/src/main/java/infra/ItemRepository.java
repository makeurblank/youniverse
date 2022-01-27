package infra;

import domain.Item;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemRepository {

    List<Item> findAll();

    Optional<Item> findByitemName();

    Item add(Item item);

    void delete(Item item);

}

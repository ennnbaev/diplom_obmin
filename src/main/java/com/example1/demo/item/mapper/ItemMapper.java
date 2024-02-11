package com.example1.demo.item.mapper;

import com.example1.demo.item.domain.Item;
import com.example1.demo.item.dto.ItemDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto toDto (Item item);

    Item toModel(ItemDto itemDto);

    List<ItemDto> toDtoList(Iterable<Item> items);
}

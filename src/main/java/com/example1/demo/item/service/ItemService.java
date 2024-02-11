package com.example1.demo.item.service;

import com.example1.demo.item.domain.Item;
import com.example1.demo.item.dto.ItemDto;
import com.example1.demo.item.dto.ItemOffer;
import com.example1.demo.item.mapper.ItemMapper;
import com.example1.demo.item.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    EmailService emailService;

    public void createItem(ItemDto itemDto) {
        itemRepository.save(itemMapper.toModel(itemDto));
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(Long.parseLong(id));
    }

    public void updateItem(String id, ItemDto itemDto) throws Exception {
        itemRepository.findById(Long.parseLong(id)).orElseThrow(Exception::new);
        Item item = itemMapper.toModel(itemDto);
        item.setId(Long.parseLong(id));
        itemRepository.save(item);
    }

    public void createOfferForChange(ItemOffer itemOffer) throws MessagingException {
        Item item = itemRepository.findById(Long.parseLong(itemOffer.getItemId())).orElseThrow();
        String htmlBody = "<h1>Hello!</h1><p>It's message from Gamer changer. User wants to change you, please write him if it's ok </p>";
        emailService.sendEmail(itemOffer.getOwnerId(), "Exchange", htmlBody);

    }

    public List<ItemDto> getAllItems(String category, String name) {
        if (!category.isBlank() && !name.isBlank()) {
            return itemMapper.toDtoList(itemRepository.findByNameAndCategory(name, category));
        } else if (!category.isBlank()) {
            return itemMapper.toDtoList(itemRepository.findByCategory(category));
        } else if (!name.isBlank()) {
            return itemMapper.toDtoList(itemRepository.findByName(name));
        } else {
            return itemMapper.toDtoList(itemRepository.findAll());
        }
    }

    public ItemDto getItemInfo(String id) {
        return itemMapper.toDto(itemRepository.findById(Long.parseLong(id)).orElseThrow());
    }
}

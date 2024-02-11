package com.example1.demo.item.controller;

import com.example1.demo.item.dto.ItemDto;
import com.example1.demo.item.dto.ItemOffer;
import com.example1.demo.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("info/{id}")
    public ItemDto getItemInfo(@PathVariable String id) {
        return itemService.getItemInfo(id);
    }

    @GetMapping("info")
    public List<ItemDto> getAllItems(@RequestParam String category, @RequestParam String name) {
        return itemService.getAllItems(category,name);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }

    @PostMapping
    public void createItem(@RequestBody ItemDto itemDto) {
        itemService.createItem(itemDto);
    }

    @PostMapping("offer")
    public void createOfferForChange(@RequestBody ItemOffer itemOffer) throws MessagingException {
        itemService.createOfferForChange(itemOffer);
    }

    @PatchMapping("{id}")
    public void updateItem(@PathVariable String id, @RequestBody ItemDto itemDto) throws Exception {
        itemService.updateItem(id,itemDto);
    }

}

package com.example1.demo.item.repo;

import com.example1.demo.item.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByName(String name);

    List<Item> findByCategory(String category);

    List<Item> findByNameAndCategory(String name, String category);
}

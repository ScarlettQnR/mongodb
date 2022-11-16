package com.example.mongodb.repository;

import com.example.mongodb.model.BookItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends MongoRepository<BookItem, String> {

    @Query("{title:'?0'}")
    BookItem findItemByTitle(String title);

    @Query(value="{publisher:'?0'}")
    List<BookItem> findAllByPublisher(String publisher);

}

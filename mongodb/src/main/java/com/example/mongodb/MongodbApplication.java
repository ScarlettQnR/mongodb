package com.example.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.example.mongodb.model.BookItem;
import com.example.mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbApplication implements CommandLineRunner {


	@Autowired
	BookRepository bookRepository;

	//CREATE
	void createBookItems() {
		System.out.println("Data creation started...");
		bookRepository.save(new BookItem("1", "For Whom The Bell Tolls", "Ernest Hemingway", "Polirom"));
		bookRepository.save(new BookItem("2", "Divine Comedy", "Dante Alighieri", "Litera"));
		bookRepository.save(new BookItem("3", "Ulysse", "James Joyce", "Humanitas"));
		bookRepository.save(new BookItem("4", "Crime And Punishment", "F. Dostoevsky", "cpt"));
		bookRepository.save(new BookItem("5", "Fleurs du mal", "Charles Baudelaire, ", "Litera"));
		bookRepository.save(new BookItem("6", "Anna Karenina", "Leo Tolstoy, ", "Librex"));
		System.out.println("Data creation complete...");
	}

	// READ
	// 1. Show all the data
	public void showAllBookItems() {
		bookRepository.findAll().forEach(item -> System.out.println(getItemDetails(item)));
	}

	// 2. Get item by title
	public void getBookItemByTitle(String title) {
		System.out.println("Getting item by title: " + title);
		BookItem item = bookRepository.findItemByTitle(title);
		System.out.println(getItemDetails(item));
	}

	// 3. Get title and author of a all items of a particular publisher
	public void getItemsByPublisher(String publisher) {
		System.out.println("Getting items for the publisher " + publisher);
		List<BookItem> list = bookRepository.findAllByPublisher(publisher);

		list.forEach(item -> System.out.println("Title: " + item.getTitle() + ", Author: " + item.getAuthor()));
	}

	// Print details in readable form

	public String getItemDetails(BookItem item) {

		System.out.println(
				"Title: " + item.getTitle() +
						", \nAuthor: " + item.getAuthor() +
						", \nPublisher: " + item.getPublisher()
		);

		return "";
	}

	// UPDATE
	public void updatePublisher(String publisher) {

		// Change to this new value
		String newPublisher = "RAO";

		// Find all the books with the old publisher
		List<BookItem> list = bookRepository.findAllByPublisher(publisher);

		list.forEach(item -> {
			// Update the publisher in each book
			item.setPublisher(newPublisher);
		});

		// Save all the books in database
		List<BookItem> itemsUpdated = bookRepository.saveAll(list);

		if(itemsUpdated != null)
			System.out.println("Successfully updated " + itemsUpdated.size() + " books.");
	}

	// DELETE
	public void deleteBookItem(String id) {
		bookRepository.deleteById(id);
		System.out.println("Book with id " + id + " deleted...");
	}


	@Override
	public void run(String... args) {

		System.out.println("-------------CREATE BOOKS-------------------------------\n");

		createBookItems();

		System.out.println("\n------------SHOW ALL BOOKS---------------------------\n");

		showAllBookItems();

		System.out.println("\n--------------GET BOOK BY TITLE-----------------------------------\n");

		getBookItemByTitle("Divine Comedy");

		System.out.println("\n-----------GET BOOKS BY PUBLISHER---------------------------------\n");

		getItemsByPublisher("Litera");

		System.out.println("\n-----------UPDATE PUBLISHER FOR LITERA----------------\n");

		updatePublisher("Litera");

		showAllBookItems();

	}

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

}

package kg.alatoo.bookstore;

import kg.alatoo.bookstore.entities.Book;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);

        val HELLO = "Hello";
        var bye = "Good bye";

//        Book hello = new Book(1, "Hello", null, null, null, null);

        Book book = Book.builder()
                .id(1)
                .title("Hello")
                .build();

        Book book2 = new Book()
                .setTitle("Good bye")
                .setAuthor("Alatoo");

        System.out.println(book);


    }

}

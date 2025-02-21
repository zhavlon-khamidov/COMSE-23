package kg.alatoo.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);

//        val HELLO = "Hello";
//        var bye = "Good bye";

//        Book hello = new Book(1, "Hello", null, null, null, null);

        /*Book book = Book.builder()
                .id(1l)
                .title("Hello")
                .build();

        System.out.println(book);*/

    }

}

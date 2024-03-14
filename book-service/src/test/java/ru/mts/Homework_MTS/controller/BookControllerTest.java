package ru.mts.Homework_MTS.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import ru.mts.Homework_MTS.Book;
import ru.mts.Homework_MTS.dto.BookRequestToCreate;
import ru.mts.Homework_MTS.dto.BookRequestToUpdate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class BookControllerTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    void e2eTest() {
        BookRequestToCreate bookRequestToCreate = new BookRequestToCreate("Michael", "Brand new book", new HashSet<>());
        ResponseEntity<Book> createBookResponse =
                rest.postForEntity("/api/books", bookRequestToCreate, Book.class);
        assertTrue(createBookResponse.getStatusCode().is2xxSuccessful(), "Unexpected status code: " + createBookResponse.getStatusCode());
        Book createBookResponseGetBody = createBookResponse.getBody();
        long id = createBookResponseGetBody.getId();

        ResponseEntity<Book> getBookResponseGet =
                rest.getForEntity("/api/books/{id}", Book.class, Map.of("id", id));
        assertTrue(getBookResponseGet.getStatusCode().is2xxSuccessful(), "Unexpected status code: " + getBookResponseGet.getStatusCode());
        Book getBookResponseBody = getBookResponseGet.getBody();
        assertEquals("Michael", getBookResponseBody.getAuthor());
        assertEquals("Brand new book", getBookResponseBody.getTitle());

        BookRequestToUpdate bookRequestToUpdate = new BookRequestToUpdate("John", "New Title", new HashSet<>());
        rest.put("/api/books/{id}", bookRequestToUpdate,  Map.of("id", id));
        ResponseEntity<Book> getBookResponseUpdate =
                rest.getForEntity("/api/books/{id}", Book.class, Map.of("id", id));
        Book getBookResponseUpdateBody = getBookResponseUpdate.getBody();
        assertEquals(getBookResponseUpdateBody.getAuthor(), "John");
        assertEquals(getBookResponseUpdateBody.getTitle(), "New Title");

        rest.delete("/api/books/{id}", Map.of("id", id));
        ResponseEntity<Book> getBookResponseDelete =
                rest.getForEntity("/api/books/{id}", Book.class, Map.of("id", id));
        Book getBookResponseDeleteBody = getBookResponseDelete.getBody();
        assertNull(getBookResponseDeleteBody.getAuthor());
        assertNull(getBookResponseDeleteBody.getTitle());
        assertNull(getBookResponseDeleteBody.getTags());
    }
}

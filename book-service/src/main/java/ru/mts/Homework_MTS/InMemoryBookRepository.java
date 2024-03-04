package ru.mts.Homework_MTS;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Component
public class InMemoryBookRepository implements BookRepository {
    private final List<Book> books;

    public InMemoryBookRepository() {
        books = new CopyOnWriteArrayList<>();
        books.add(new Book("Петров А.В.", "Основы кройки и шитья", new HashSet<>()));
        books.add(new Book("Мошкина А.В", "Введение в архитектурный дизайн", new HashSet<>()));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Book save(Book book) {
        if (book.getId().equals((long) books.size() + 1)) {
            books.add(book);
            return book;
        }
        else {
            synchronized(this) {
                for (Book b : books) {
                    if (b.getId() == book.getId()) {
                        b.setAuthor(book.getAuthor());
                        b.setTitle(book.getTitle());
                        b.setTags(book.getTags());
                        return book;
                    }
                }
            }
            return book;
        }
    }

    @Override
    public Book deleteById(Long id) {
        books.get(id.intValue() - 1).setTitle(null);
        books.get(id.intValue() - 1).setAuthor(null);
        books.get(id.intValue() - 1).setTags(null);
        return books.get(id.intValue() - 1);
    }

    @Override
    public List<Book> findBooksByTag(String tag) {
        return books.stream()
                .filter(book -> book.getTags().contains(tag))
                .collect(Collectors.toList());
    }
}

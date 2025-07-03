package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring container with applicationContext.xml from classpath
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Fetch bookService bean by ID
        BookService bookService = (BookService) context.getBean("bookService");

        // Call service method
        bookService.showBooks();
    }
}

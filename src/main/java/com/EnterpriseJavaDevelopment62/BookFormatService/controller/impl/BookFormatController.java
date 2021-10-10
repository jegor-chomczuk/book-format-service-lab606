package com.EnterpriseJavaDevelopment62.BookFormatService.controller.impl;

import com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto.ReceivingBookDTO;
import com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto.SendingBookDTO;
import com.EnterpriseJavaDevelopment62.BookFormatService.dao.Book;
import com.EnterpriseJavaDevelopment62.BookFormatService.enums.Format;
import com.EnterpriseJavaDevelopment62.BookFormatService.interfaces.IBookFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableEurekaClient
@RequestMapping
public class BookFormatController {

    @Autowired
    private BookFormatRepository bookFormatRepository;

    @Autowired
    private IBookFormatService bookFormatService;

    //   Get a book by ISBN
    @GetMapping("/book/{isbn}")
    public Book findById(@PathVariable("isbn") String isbn) {
        return bookFormatRepository.findById(isbn).get();
    }

    //  Get all books
    @GetMapping("/books")
    public List<Book> findAllBook() {
        return bookFormatRepository.findAll();
    }

    //  Add a list of formats to a bookDTO and saves that book in BookFormatRepository
    @PostMapping("/book-format")
    public SendingBookDTO getBookFormat(@RequestBody ReceivingBookDTO receivingBookDTO) {
        return bookFormatService.getBookFormat(receivingBookDTO);
    }
}

package com.EnterpriseJavaDevelopment62.BookFormatService.controller.impl;

import com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto.*;
import com.EnterpriseJavaDevelopment62.BookFormatService.dao.Book;
import com.EnterpriseJavaDevelopment62.BookFormatService.enums.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;

@RestController
@EnableEurekaClient
@RequestMapping
public class BookFormatController {

    @Autowired
    private BookFormatRepository bookFormatRepository;

    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    @GetMapping("/random-format")
    public Format generateRandomBookFormat(){
        return randomEnum(Format.class);
    }

    @GetMapping("/book/{isbn}")
    public Book findById(@PathVariable("isbn") String isbn){
        return bookFormatRepository.findById(isbn).get();
    }

    @GetMapping("/books")
    public List<Book> findAllBook(){
        return bookFormatRepository.findAll();
    }

    @PostMapping("/book-format")
    public SendingBookDTO getBookFormat(@RequestBody ReceivingBookDTO receivingBookDTO){
        SendingBookDTO sendingBookDTO = new SendingBookDTO((randomEnum(Format.class)));
        Book book = new Book(receivingBookDTO.getIsbn(), sendingBookDTO.getFormat());
        bookFormatRepository.save(book);
        return sendingBookDTO;
    }

//    @GetMapping("/book-format")
//    public String getBookFormat(@RequestBody ReceivingBookDTO receivingBookDTO){
//        String format = (randomEnum(Format.class)).toString();
//        return format;
//
//        SendingBookDTO sendingBookDTO = new SendingBookDTO((randomEnum(Format.class)));
//        Book book = new Book(receivingBookDTO.getIsbn(), sendingBookDTO.getFormat());
//        bookFormatRepository.save(book);
//        return sendingBookDTO;
//    }
}

package com.EnterpriseJavaDevelopment62.BookFormatService.services;

import com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto.ReceivingBookDTO;
import com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto.SendingBookDTO;
import com.EnterpriseJavaDevelopment62.BookFormatService.controller.impl.BookFormatRepository;
import com.EnterpriseJavaDevelopment62.BookFormatService.dao.Book;
import com.EnterpriseJavaDevelopment62.BookFormatService.enums.Format;
import com.EnterpriseJavaDevelopment62.BookFormatService.interfaces.IBookFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookFormatService implements IBookFormatService {

    @Autowired
    private BookFormatRepository bookFormatRepository;

    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    //  Generates a list of random length (between 1 and 4) and populates it with random unique formats
    public List<Format> getRandomFormatList() {
        Random random = new Random();
        int randomNum = random.nextInt(1, 5);
        List<Format> formatList = new ArrayList(randomNum);
        for (int i = 0; i < randomNum; i++) {
            Format randomFormat = randomEnum(Format.class);
            if (!formatList.contains(randomFormat)) {
                formatList.add(randomFormat);
                randomFormat = randomEnum(Format.class);
            }
        }
        return formatList;
    }

    //  Add a list of formats to a bookDTO and saves that book in BookFormatRepository
    public SendingBookDTO getBookFormat(ReceivingBookDTO receivingBookDTO) {
        SendingBookDTO sendingBookDTO = new SendingBookDTO(getRandomFormatList());
        Book book = new Book(receivingBookDTO.getIsbn(), sendingBookDTO.getFormats());
        bookFormatRepository.save(book);
        return sendingBookDTO;
    }
}

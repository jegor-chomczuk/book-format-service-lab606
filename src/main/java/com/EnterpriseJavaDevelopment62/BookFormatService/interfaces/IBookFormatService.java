package com.EnterpriseJavaDevelopment62.BookFormatService.interfaces;

import com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto.ReceivingBookDTO;
import com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto.SendingBookDTO;
import com.EnterpriseJavaDevelopment62.BookFormatService.enums.Format;

import java.util.List;

public interface IBookFormatService {
    List<Format> getRandomFormatList();

    SendingBookDTO getBookFormat(ReceivingBookDTO receivingBookDTO);
}

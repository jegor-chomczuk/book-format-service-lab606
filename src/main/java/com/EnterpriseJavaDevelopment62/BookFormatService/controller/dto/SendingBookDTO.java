package com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto;

import com.EnterpriseJavaDevelopment62.BookFormatService.enums.Format;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendingBookDTO {

    @NonNull
    private Format format;
}

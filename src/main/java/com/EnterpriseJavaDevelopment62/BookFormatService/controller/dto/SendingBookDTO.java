package com.EnterpriseJavaDevelopment62.BookFormatService.controller.dto;

import com.EnterpriseJavaDevelopment62.BookFormatService.enums.Format;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendingBookDTO {

    @NonNull
    private List<Format> formats;
}

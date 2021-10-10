package com.EnterpriseJavaDevelopment62.BookFormatService.dao;

import com.EnterpriseJavaDevelopment62.BookFormatService.enums.Format;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_table")
public class Book {
    @Id
    private String isbn;

    @ElementCollection
    private List<Format> formats;

}

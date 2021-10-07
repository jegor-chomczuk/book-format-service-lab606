package com.EnterpriseJavaDevelopment62.BookFormatService.controller.impl;

import com.EnterpriseJavaDevelopment62.BookFormatService.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFormatRepository extends JpaRepository<Book, String> {
}

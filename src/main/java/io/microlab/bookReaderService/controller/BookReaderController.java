package io.microlab.bookReaderService.controller;

import io.microlab.bookReaderService.model.Book;
import io.microlab.bookReaderService.model.BookReader;
import io.microlab.bookReaderService.service.BookReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BookReaderController {

    @Autowired
    private BookReaderService bookReaderService;

    private static final Logger logger= LoggerFactory.getLogger(BookReaderService.class);

    @GetMapping("/api/reader/{personId}")
    public BookReader getAllInfo(@PathVariable Integer personId){
        logger.info("book stock service request sent at .. {}",new Date());
        List<Book> bookList=bookReaderService.getBookInfo(personId);
        logger.info("book stock service response came at .. {}",new Date());
        BookReader bookReader=new BookReader();
        bookReader.setId(personId);
        bookReader.setName("abc");
        bookReader.setEmailId("abc@gamil.com");
        bookReader.setHoldingBooks(bookList);
        bookReader.setStockTillDate(new Date());

        return  bookReader;
    }
}

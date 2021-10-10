package io.microlab.bookReaderService.model;


import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class BookReader {
    private int id;
    private String name;
    private String emailId;
    private List<Book> holdingBooks;
    private Date stockTillDate;

    public BookReader() {
    }

    public Date getStockTillDate() {
        return stockTillDate;
    }

    public void setStockTillDate(Date stockTillDate) {
        this.stockTillDate = stockTillDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Book> getHoldingBooks() {
        return holdingBooks;
    }

    public void setHoldingBooks(List<Book> holdingBooks) {
        this.holdingBooks = holdingBooks;
    }
}

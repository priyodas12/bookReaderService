package io.microlab.bookReaderService.service;

import io.microlab.bookReaderService.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.*;

@Service
public class BookReaderService {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger= LoggerFactory.getLogger(BookReaderService.class);

    ResponseEntity<List<Book>> responseEntity;

    public List<Book> getBookInfo(Integer readerId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        HttpEntity<Integer> requestEntity = new HttpEntity<>(headers);
        String endPoint="http://BOOK-SERVICE/api/books/"+readerId;
        try {
            responseEntity = restTemplate.exchange(endPoint, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Book>>() {
            });
        }catch (RestClientException e){
            logger.info("response entity {}",responseEntity);
            throw new RuntimeException("something went wrong! No data found from bookService");
        }
        logger.info("response status code {}",responseEntity.getStatusCode());
        return responseEntity.getBody();
    }
}

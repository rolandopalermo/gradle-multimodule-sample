package com.rolandopalermo.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rolandopalermo.sample.common.Error;
import com.rolandopalermo.sample.common.Errors;
import com.rolandopalermo.sample.dto.BookDTO;
import com.rolandopalermo.sample.repository.BookRepository;
import com.rolandopalermo.sample.repository.domain.Book;
import com.rolandopalermo.sample.service.common.ServiceResponse;

@Service("bookService")
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
//	private static final Logger logger = LogManager.getLogger(BookBO.class);

	public ServiceResponse<BookDTO, Errors> saveBook(BookDTO bookDTO) {
		try {
//			logger.debug(String.format("Saving book %s", bookDTO.toString()));
			if(bookDTO == null || StringUtils.isEmpty(bookDTO.getTitle()) || StringUtils.isEmpty(bookDTO.getDescription())) {
//				logger.error(String.format("Error trying to save Book %s", bookDTO.toString()));
				Errors errorResponse = new Errors();
				errorResponse.getErrors().add(new Error("Bad request", "400"));
				return ServiceResponse.of(null, errorResponse);
			}
			Book book = new Book();
			book.setTitle(bookDTO.getTitle());
			book.setDescription(bookDTO.getDescription());
			bookRepository.save(book);
			return buildResponse(book);
		} catch (Exception e) {
//			logger.error("saveBook", e);
			return ServiceResponse.of(null, buildError(e));
		}
	}
	
	public ServiceResponse<BookDTO, Errors> getBookById(Integer id) {
		try {
//			logger.debug(String.format("Searching book with id [%d]", id));
			Optional<Book> optBook = bookRepository.findById(id);
			if (optBook.isPresent()) {
				return buildResponse(optBook.get());
		    } else {
		    	Errors errorResponse = new Errors();
				errorResponse.getErrors().add(new Error(String.format("No book with id %d was found", id), "404"));
				return ServiceResponse.of(null, errorResponse);
		    }
		} catch (Exception e) {
//			logger.error("getBookById", e);
			return ServiceResponse.of(null, buildError(e));
		}
	}

	private ServiceResponse<BookDTO, Errors> buildResponse(Book book) {
		BookDTO dto = new BookDTO();
		dto.setId(book.getId());
		dto.setTitle(book.getTitle());
		dto.setDescription(book.getDescription());
		return ServiceResponse.of(dto, null);
	}
	
	private Errors buildError(Exception ex) {
		Errors errorResponse = new Errors();
		errorResponse.getErrors().add(new Error("Internal error", "500"));
		return errorResponse;
	}

}
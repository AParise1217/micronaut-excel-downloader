package com.parisesoftware.presentation.web.book;

import com.parisesoftware.core.component.book.application.repository.BookRepository;
import com.parisesoftware.core.component.book.application.service.BookSaveCommand;
import com.parisesoftware.core.component.book.application.service.BookUpdateCommand;
import com.parisesoftware.core.component.book.domain.book.Book;
import com.parisesoftware.core.paging.ListingArguments;
import com.parisesoftware.presentation.excel.core.component.book.application.BookExcelService;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.server.types.files.SystemFile;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller("/books")
public class BookController {

    protected final BookRepository bookRepository;
    protected final BookExcelService bookExcelService;

    public BookController(BookRepository bookRepository,
                          BookExcelService bookExcelService) {
        this.bookRepository = bookRepository;
        this.bookExcelService = bookExcelService;
    }

    @Get("/{id}")
    public Book show(Long id) {
        return bookRepository
                .findById(id)
                .orElse(null);
    }

    @Put("/")
    public HttpResponse update(@Body @Valid BookUpdateCommand command) {
        int numberOfEntitiesUpdated = this.bookRepository.update(command.getId(), command.getName(), command.getIsbn());
        return HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, location(command.getId()).getPath());
    }

    @Get("/list{?args}")
    public List<Book> list(@Valid ListingArguments args) {
        return this.bookRepository.findAll(args);
    }

    @Post("/")
    public HttpResponse<Book> save(@Body @Valid BookSaveCommand command) {
        Book book = bookRepository.save(command.getName(), command.getIsbn());

        return HttpResponse
                    .created(book)
                    .headers(headers -> headers.location(location(book.getId())));
    }

    @Delete("/{id}")
    public HttpResponse delete(Long id) {
        this.bookRepository.deleteById(id);
        return HttpResponse.noContent();
    }

    @Get("/excel{?args*}")
    SystemFile excel(@Valid ListingArguments args) {
        return bookExcelService.generateExcelFileFromBooks(this.bookRepository.findAll(args));
    }

    protected URI location(Long id) {
        return URI.create("/books/" + id);
    }

    protected URI location(Book book) {
        return location(book.getId());
    }

}

package com.parisesoftware.presentation.web;

import com.parisesoftware.core.component.book.application.repository.BookRepository;
import com.parisesoftware.presentation.excel.core.component.book.application.BookExcelService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.types.files.SystemFile;
import io.micronaut.views.View;

import java.util.HashMap;
import java.util.Map;

@Controller("/")
public class HomeController {

    protected final BookRepository bookRepository;
    protected final BookExcelService bookExcelService;

    public HomeController(BookRepository bookRepository,
                          BookExcelService bookExcelService) {
        this.bookRepository = bookRepository;
        this.bookExcelService = bookExcelService;
    }

    @View("index")
    @Get
    Map<String, String> index() {
        return new HashMap<>();
    }

    @Get("/excel")
    SystemFile excel() {
        return bookExcelService.generateExcelFileFromBooks(bookRepository.findAll());
    }

}

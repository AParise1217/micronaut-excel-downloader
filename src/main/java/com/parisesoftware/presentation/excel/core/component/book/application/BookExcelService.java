package com.parisesoftware.presentation.excel.core.component.book.application;

import com.parisesoftware.core.component.book.domain.book.Book;
import io.micronaut.http.server.types.files.SystemFile;

import java.util.List;

/**
 * Book Excel Service
 * <p>
 *     Encapsulation of the logic related to Excel sheet generation for
 *      {@link com.parisesoftware.core.component.book.domain.book.Book} instances
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
public interface BookExcelService {

    static final String SHEET_NAME = "Books";
    static final String HEADER_ISBN = "Isbn";
    static final String HEADER_NAME = "Name";
    static final String HEADER_EXCEL_FILE_SUFFIX = ".xlsx";
    static final String HEADER_EXCEL_FILE_PREFIX = "books";
    static final String HEADER_EXCEL_FILENAME = HEADER_EXCEL_FILE_PREFIX + HEADER_EXCEL_FILE_SUFFIX;

    /**
     * Generates an Excel File for the given Books
     * @param bookList to populate the Excel sheet with
     * @return {@code SystemFile} to indicate that the given file should
     *  be downloaded by the client rather than displayed
     */
    SystemFile generateExcelFileFromBooks(List<Book> bookList);

}

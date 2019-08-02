package com.parisesoftware.presentation.excel.core.component.book.application;

import builders.dsl.spreadsheet.builder.poi.PoiSpreadsheetBuilder;
import com.parisesoftware.core.component.book.domain.book.Book;
import io.micronaut.http.server.types.files.SystemFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * {@inheritDoc}
 * <p>
 *     Default Implementation of {@link BookExcelService}
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
@Singleton
class BookExcelServiceImpl implements BookExcelService {

    private static final Logger LOG = LoggerFactory.getLogger(BookExcelServiceImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public SystemFile generateExcelFileFromBooks(List<Book> bookList) {
        try {
            File file = File.createTempFile(HEADER_EXCEL_FILE_PREFIX, HEADER_EXCEL_FILE_SUFFIX);
            PoiSpreadsheetBuilder.create(file).build(w -> {
                w.apply(BookExcelStylesheet.class);
                w.sheet(SHEET_NAME, s -> {
                    s.row(r -> Stream.of(HEADER_ISBN, HEADER_NAME)
                            .forEach(header -> r.cell(cd -> {
                                        cd.value(header);
                                        cd.style(BookExcelStylesheet.STYLE_HEADER);
                                    })
                            ));
                    bookList.stream()
                            .forEach( book -> s.row(r -> {
                                r.cell(book.getIsbn());
                                r.cell(book.getName());
                            }));
                });
            });
            return new SystemFile(file).attach(HEADER_EXCEL_FILENAME);
        } catch (IOException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("File not found exception raised when generating excel file");
            }
        }
        return null;
    }

}

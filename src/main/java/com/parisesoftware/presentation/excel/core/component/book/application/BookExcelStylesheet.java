package com.parisesoftware.presentation.excel.core.component.book.application;

import builders.dsl.spreadsheet.api.FontStyle;
import builders.dsl.spreadsheet.builder.api.CanDefineStyle;
import builders.dsl.spreadsheet.builder.api.Stylesheet;

/**
 * Book Excel Stylesheet
 * <p>
 *     Externalized style configuration for generated Excel Sheets
 * </p>
 * @version 1.0
 * @since 1.0
 */
public class BookExcelStylesheet implements Stylesheet {

    public static final String STYLE_HEADER = "header";

    @Override
    public void declareStyles(CanDefineStyle stylable) {
        stylable.style(STYLE_HEADER, st -> st.font(f -> f.style(FontStyle.BOLD)));
    }

}

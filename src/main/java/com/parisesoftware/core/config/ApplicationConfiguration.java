package com.parisesoftware.core.config;

import javax.validation.constraints.NotNull;

/**
 * Application Configuration
 * <p>
 *     Encapsulation of Default Value Configuration
 * </p>
 */
public interface ApplicationConfiguration {

    @NotNull Integer getMax();

}

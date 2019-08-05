package com.parisesoftware.core.config.impl;

import com.parisesoftware.core.config.ApplicationConfiguration;
import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotNull;

/**
 * {@inheritDoc}
 * <p>
 *     Default implementation of {@link ApplicationConfiguration}
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
@ConfigurationProperties("application")
public class ApplicationConfigurationImpl implements ApplicationConfiguration {

    protected final Integer DEFAULT_MAX = 10;

    private Integer max = DEFAULT_MAX;

    @Override
    public @NotNull Integer getMax() {
        return this.max;
    }

    public void setMax(Integer max) {
        if(max != null) {
            this.max = max;
        }
    }

}

package org.geektimes.configuration.microprofile.config.convert;

import org.eclipse.microprofile.config.spi.Converter;

public class SimpleStringConverter implements Converter<String> {
    @Override
    public String convert(String s) throws IllegalArgumentException, NullPointerException {
        return s;
    }
}

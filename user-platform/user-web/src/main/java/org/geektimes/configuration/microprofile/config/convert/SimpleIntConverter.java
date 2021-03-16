package org.geektimes.configuration.microprofile.config.convert;

import org.eclipse.microprofile.config.spi.Converter;

public class SimpleIntConverter implements Converter<Integer> {
    @Override
    public Integer convert(String s) throws IllegalArgumentException, NullPointerException {
        return Integer.valueOf(s);
    }
}

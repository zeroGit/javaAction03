package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Map;
import java.util.Set;

public class JavaEnvPropertiesConfigSource implements ConfigSource {

    private final Map<String, String> env;

    public JavaEnvPropertiesConfigSource() {
        env = System.getenv();
    }

    @Override
    public Set<String> getPropertyNames() {
        return env.keySet();
    }

    @Override
    public String getValue(String s) {
        return env.get(s);
    }

    @Override
    public String getName() {
        return "Java Env Properties";
    }
}

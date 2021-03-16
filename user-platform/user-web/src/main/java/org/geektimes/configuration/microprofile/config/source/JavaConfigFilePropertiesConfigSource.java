package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

// 读取 classpath 下的 myapp.properties 文件
public class JavaConfigFilePropertiesConfigSource implements ConfigSource {

    private final Properties properties = new Properties();
    private final Set<String> names = new HashSet<>();

    public JavaConfigFilePropertiesConfigSource() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("myapp.properties");

        try {
            properties.load(resourceAsStream);

            properties.keySet().forEach(name -> {
                names.add((String) name);
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<String> getPropertyNames() {
        return names;
    }

    @Override
    public String getValue(String s) {
        return (String) properties.get(s);
    }

    @Override
    public String getName() {
        return "Java Myapp Properties";
    }
}

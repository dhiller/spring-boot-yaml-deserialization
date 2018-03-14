package de.dhiller.yaml_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import static java.util.Arrays.asList;

@SpringBootApplication
public class YamlTestApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(YamlTestApplication.class);

    private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

    @Override
    public void run(String... args) {
        if (args.length > 0 && args[0].equals("exitcode")) {
            throw new RuntimeException();
        }
        for (Class type : asList(
                JavaBeanYamlConfig.class,
                CreatorWithPropertyYamlConfig.class,
                BuilderYamlConfig.class)) {
            log.info("{} config value: {}", type, yamlConfig(type).getConfig());
        }
    }

    public <T extends YamlConfig> T yamlConfig(Class<T> type) {
        try {
            return objectMapper.readValue(getClass().getResource("/YamlConfig.yaml"), type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(YamlTestApplication.class, args);
    }

}

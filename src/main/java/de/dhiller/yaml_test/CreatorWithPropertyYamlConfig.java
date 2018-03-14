package de.dhiller.yaml_test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatorWithPropertyYamlConfig implements YamlConfig {

    private String config;

    @JsonCreator
    public CreatorWithPropertyYamlConfig(@JsonProperty("config") String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }

}

package de.dhiller.yaml_test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = BuilderYamlConfig.Builder.class)
public class BuilderYamlConfig implements YamlConfig {

    private final String config;

    @JsonCreator
    public BuilderYamlConfig(Builder builder) {
        this.config = builder.config;
    }

    public String getConfig() {
        return config;
    }

    public static final class Builder {

        private String config;

        public Builder withConfig(String config) {
            this.config = config;
            return this;
        }

        public BuilderYamlConfig build() {
            return new BuilderYamlConfig(this);
        }

    }

}

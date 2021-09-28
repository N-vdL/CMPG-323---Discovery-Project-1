package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import config.TranslaterConfig;

@Import({TranslaterConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.as.logic.flow"
})

public class LogicConfig {
}

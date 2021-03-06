package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(LogicConfig.class)
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.as.web.sb.controller",
        "za.ac.nwu.as.web.sb.exception"
})

public class WebConfig {
}

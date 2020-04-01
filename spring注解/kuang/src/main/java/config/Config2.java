package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author YZY
 * @date 2020/3/31 - 16:12
 */
@Configuration
@Import(Config.class)
public class Config2 {
}

package demo1.confing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("demo1")
@EnableAspectJAutoProxy
public class SpringConfig {
}

package tk.jingzing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 在配置文件中我们可以通过@ComponentScan配置来发现和创建bean，在关联类中通过@Autowired来注入bean。
 * 如果你的工程结构是按上一节中的建议来构建的（主函数配置与root package下），那么@ComponentScan就不需要配置任何参数。
 * 你应用中的所有配置的构建（@Component,@Service,@Repository,@Controller等）都会自动地被注册为Spring Bean
 *
 * Spring Boot自动配置的意图是根据项目中JAR的依赖关系自动配置你的Spring应用程序。例如：当HSQLDB在你的classpath中，
 * 并且你没有配置数据源的bean，那么spring boot会自动的为你配置一个嵌入式数据源。
 * 使用自动配置功能：需要在配置类上添加@EnableAutoConfiguration或者@SpringBootApplication注解。
 *
 * 支持远程调试 java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \-jar target/myproject-0.0.1-SNAPSHOT.jar
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

package job;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import job.demo.JobDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author vectorzhang
 * @desc
 * @date 2017/10/6 15:57
 */
@RestController
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 定义日志数据库事件溯源配置
        JobEventConfiguration jobEventRdbConfig = new JobEventRdbConfiguration(dataSource);
        new JobScheduler(JobDemo.createRegistryCenter(), JobDemo.createJobConfiguration(), jobEventRdbConfig).init();
    }

    @GetMapping("/")
    public String index() {
        return "hello world";
    }
}

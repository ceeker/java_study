package job;

import com.dangdang.ddframe.job.lite.api.JobScheduler;
import job.demo.JobDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vectorzhang
 * @desc
 * @date 2017/10/6 15:57
 */
@RestController
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        new JobScheduler(JobDemo.createRegistryCenter(), JobDemo.createJobConfiguration()).init();
    }

    @GetMapping("/")
    public String index() {
        return "hello world";
    }
}

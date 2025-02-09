package naztech.app.jesper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JesperApplication  {

    public static void main(String[] args) {
        SpringApplication.run(JesperApplication.class, args);
    }
    @GetMapping("/ok")
    public String hello(){
        return "NAZTECH";
    }
}

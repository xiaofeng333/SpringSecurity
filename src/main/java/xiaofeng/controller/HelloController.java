package xiaofeng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@EnableWebSecurity
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/say")
    public String say() {
        return "say: hello";
    }

    @GetMapping("/login")
    public String login() {
        logger.info("here you are");
        return "say: hello";
    }
}

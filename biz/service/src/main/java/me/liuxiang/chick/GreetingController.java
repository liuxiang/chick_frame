package me.liuxiang.chick;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * http://localhost:8080/
     *
     * @param name
     * @return
     */
    @RequestMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greeting(name);
    }

    /**
     * http://localhost:8080/greeting
     *
     * @param name
     * @return
     */
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template, name);
    }
}
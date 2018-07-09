package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;

@RestController
//@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
  
    
    /*
    @RequestMapping(value = {
    		"/ru",
    		"/re",
    		"/en"
    })
  */
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    /*
    //@RequestMapping("/en")
    public Greeting engreeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/ru")
    public Greeting rugreeting(@RequestParam(value="name", defaultValue="Mir") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
   */
    
    
}
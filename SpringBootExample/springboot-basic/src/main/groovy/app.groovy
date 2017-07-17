import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GroovySpringApp {
    @RequestMapping("/g")
    String home(){
        return "Hello World!"
    }
}
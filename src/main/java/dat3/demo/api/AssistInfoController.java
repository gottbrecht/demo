package dat3.demo.api;


import dat3.demo.dto.MyResponse;
import dat3.demo.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assistant")
@CrossOrigin(origins = "*")
public class AssistInfoController {

    private final String SYSTEM_MESSAGE="You are an event maker, that knows how to generate songs and entertain a crowd."
    +"The user is a Computer Science Student, who wants to have a good time, by prompting you a word, that you make into a song";


OpenAiService openAiService;

public AssistInfoController(OpenAiService openAiService) {this.openAiService = openAiService;}


@GetMapping
public MyResponse getSong(@RequestParam String topic) {
    return openAiService.makeRequest(topic,SYSTEM_MESSAGE);
}
}
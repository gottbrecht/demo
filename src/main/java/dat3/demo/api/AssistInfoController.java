package dat3.demo.api;


import dat3.demo.dto.MyResponse;
import dat3.demo.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/song")
@CrossOrigin(origins = "*")
public class AssistInfoController {

    private final String SYSTEM_MESSAGE="You are an event maker, that knows how to generate songs and entertain a crowd.";


OpenAiService openAiService;

public AssistInfoController(OpenAiService openAiService) {this.openAiService = openAiService;}


@GetMapping
public MyResponse getSong(@RequestParam String question) {
    return openAiService.makeRequest(question,SYSTEM_MESSAGE);
}
}
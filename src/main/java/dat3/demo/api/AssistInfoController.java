package dat3.demo.api;


import dat3.demo.dto.MyResponse;
import dat3.demo.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assistant")
@CrossOrigin(origins = "*")
public class AssistInfoController {


    private final String SYSTEM_MESSAGE="";

OpenAiService openAiService;

public AssistInfoController(OpenAiService openAiService) {this.openAiService = openAiService;}

/*
@GetMapping
public MyResponse getInfo(@RequestParam String question) {
    return openAiService.makeRequest(question,SYSTEM_MESSAGE);
}*/
}
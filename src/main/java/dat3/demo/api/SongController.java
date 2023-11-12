package dat3.demo.api;

import dat3.demo.dto.MyResponse;
import dat3.demo.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/song")
@CrossOrigin(origins =  "*")
public class SongController {

    private final OpenAiService openAiService;
    final static String SYSTEM_MESSAGE = "You are an event maker, that knows how to generate songs and entertain a crowd."+
            " The user is a Computer Science Student";

    @Autowired
    public SongController(OpenAiService openAiService) {this.openAiService = openAiService; }

    @PostMapping
    public MyResponse getSong(@RequestParam String topic) {
        return openAiService.makeRequest(topic,SYSTEM_MESSAGE);
    }
}

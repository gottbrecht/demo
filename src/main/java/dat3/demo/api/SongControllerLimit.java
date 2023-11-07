package dat3.demo.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/song2")
@CrossOrigin(origins = "http://youtube.com, http://google.com")
public class SongControllerLimit {
}

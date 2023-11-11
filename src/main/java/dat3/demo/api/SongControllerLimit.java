package dat3.demo.api;

import dat3.demo.dto.MyResponse;
import dat3.demo.service.OpenAiService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping("/api/song2")
@CrossOrigin(origins = "*")
public class SongControllerLimit {

    private final int BUCKET_CAPACITY = 2;
    private final int REFILL_AMOUNT = 2;
    private final int REFILL_TIME = 2;

    private OpenAiService openAiService;

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    public SongControllerLimit(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    private Bucket createNewBucket() {
        Bandwidth limit = Bandwidth.classic(BUCKET_CAPACITY, Refill.greedy(REFILL_AMOUNT, Duration.ofMinutes(REFILL_TIME)));
        return Bucket.builder().addLimit(limit).build();
    }

    private Bucket getBucket(String key) {
        return buckets.computeIfAbsent(key, k -> createNewBucket());
    }

    @GetMapping("/limit")
    public MyResponse getSongLimit(@RequestParam String topic, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        Bucket bucket = getBucket(ip);
        if (!bucket.tryConsume(1)) {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Too many requests, try again later");
        }
        return openAiService.makeRequest(topic, SongController.SYSTEM_MESSAGE);
    }
}


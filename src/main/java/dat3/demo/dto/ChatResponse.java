package dat3.demo.dto;

import com.google.protobuf.Message;
import lombok.Getter;
import lombok.Setter;
import org.jboss.jandex.TypeTarget;

import java.awt.*;

@Getter
@Setter
public class ChatResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List choices;
    private TypeTarget.Usage usage;

    @Getter
    @Setter
    public static class Choice {
        private int index;
        private Message message;
        private String finish_reason;
    }

    @Getter
    @Setter
    public static class Message {
        private String role;
        private String content;
    }

    @Getter
    @Setter
    public static class Usage {
        private int prompt_tokens;
        private int completion_tokens;
        private int total_tokens;
    }
}

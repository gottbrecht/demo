package dat3.demo.dto;


import com.google.protobuf.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ChatRequest {

    private String model;
    private List<Message> messages = new ArrayList<>();
    private double temperature;
    private int maxTokens;
    private int topP;
    private double frequencyPenalty;
    private double presencePenalty;

    @Getter
    @Setter
    public static class Message {
        private String role;
        private String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}

package dat3.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Service
public class OpenAiService {

   public static final Logger logger = LoggerFactory.getLogger(OpenAiService.class);

 //  @Value("${OPENAI_API_KEY}")
    private String OPENAI_API_KEY;


   public final static String URL = "https://api.openai.com/v1/chat/completions";

   public final static String MODEL = "gpt-3.5-turbo";
   public final static int TEMPERATURE = 1;
   public final static int MAX_TOKENS = 256;
   public final static double FREQUENCY_PENALTY = 0.0;
   public final static double TOP_P = 1.0;
   private WebClient client;

   //Constructor for testing
   public OpenAiService() {this.client = WebClient.create();}

   public OpenAiService(WebClient client) { this.client = client;}
   /*
   public MyResponse makeRequest(String userPrompt, String _systemMessage) {

      ChatRequest requestDto = new ChatRequest();
      requestDto.setModel(MODEL);
      requestDto.setTemperature(TEMPERATURE);
      requestDto.setMax_tokens(MAX_TOKENS);
      requestDto.setTop_p(TOP_P);
      requestDto.setFrequency_penalty(FREQUENCY_PENALTY);
      requestDto.getMessages().add(new ChatRequest.Message("system", _systemMessage));
      requestDto.getMessages().add(new ChatRequest.Message("user", userPrompt));

      ObjectMapper mapper = new ObjectMapper();
      String json = "";
      String error = null;
      try{
         json = mapper.writeValueAsString(requestDto);
         System.out.println(json);
         ChatResponse response = client.post()
                 .uri(new URI(URL))
                 .header("Authorization","Bearer " + OPENAI_API_KEY)
                 .contentType(MediaType.APPLICATION_JSON)
                */
      }



package dat3.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dat3.demo.dto.ChatRequest;
import dat3.demo.dto.ChatResponse;
import dat3.demo.dto.MyResponse;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import java.net.URI;
import java.net.URISyntaxException;


@Service
@Value
public class OpenAiService {

    public static final Logger logger = LoggerFactory.getLogger(OpenAiService.class);

    //  @Value("${OPENAI_API_KEY}")
    //  private String OPENAI_API_KEY;


    public final static String URL = "https://api.openai.com/v1/chat/completions";
    public final static String MODEL = "gpt-3.5-turbo";
    public final static int TEMPERATURE = 1;
    public final static int MAX_TOKENS = 256;
    public final static double FREQUENCY_PENALTY = 0.0;
    public final static double TOP_P = 1.0;

    WebClient client = WebClient.create();
}
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
                 .accept(MediaType.APPLICATION_JSON)
                 .body(BodyInserters.fromValue(json))
                 .retrieve()
                 .bodyToMono(ChatResponse.class) //
                 .block();
         String responseMsg = response.getChoices().get(0).getM
         )
         int tokenUsed = response.getUsage().getTotal_tokens();
          System.out.println("Tokens used: " +tokenUsed);
          System.out.println("Cost");
          System.out.println("");
          return new MyResponse(responseMsg);
      }
      catch (WebClientException | JsonProcessingException exception) {

      } catch (URISyntaxException e) {
          throw new RuntimeException(e);
      }
*/


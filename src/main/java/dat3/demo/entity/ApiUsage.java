package dat3.demo.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
public class ApiUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String promptTokens;
    private int completionTokens;
    private int totalTokens;

    private String prompt;

    @CreationTimestamp
    LocalDateTime created;

}
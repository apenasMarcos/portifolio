package br.com.marcos.portifolios.model;

import br.com.marcos.portifolios.model.dto.MessageForm;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String sender;
    private String phone;
    private String messageContent;

    public Message(MessageForm form) {
        this.name = form.name();
        this.sender = form.sender();
        this.phone = form.phone();
        this.messageContent = form.messageContent();
    }
}

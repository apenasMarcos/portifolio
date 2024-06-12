package br.com.marcos.portifolios.model;

import br.com.marcos.portifolios.model.dto.MessageForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "message")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

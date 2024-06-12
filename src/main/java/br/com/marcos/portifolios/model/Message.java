package br.com.marcos.portifolios.model;

import br.com.marcos.portifolios.model.dto.MensagemForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "mensagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Mensagem {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String remetente;
    private String celular;
    private String mensagem;

    public Mensagem(MensagemForm form) {
        this.nome = form.nome();
        this.remetente = form.remetente();
        this.celular = form.celular();
        this.mensagem = form.mensagem();
    }
}

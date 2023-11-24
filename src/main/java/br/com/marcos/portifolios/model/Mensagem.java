package br.com.marcos.portifolios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "mensagem")
@Entity(name = "mensagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Mensagem {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String remetente;
    private String celular;
    private String mensagem;
}

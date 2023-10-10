package br.com.marcos.portifolios.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailForm {

    private String nome;
    private String remetente;
    private String celular;
    private String mensagem;

}

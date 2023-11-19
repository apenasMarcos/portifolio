package br.com.marcos.portifolios.repository;

import br.com.marcos.portifolios.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public class MensagemRepository extends JpaRepository<Mensagem, UUID>{
}

package br.com.marcos.portifolios.repository;

import br.com.marcos.portifolios.model.Message;
import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID>{
}

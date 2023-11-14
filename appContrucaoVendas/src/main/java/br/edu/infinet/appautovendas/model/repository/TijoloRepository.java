package br.edu.infinet.appautovendas.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infinet.appautovendas.model.domain.Tijolo;

@Repository
public interface TijoloRepository extends CrudRepository<Tijolo, Integer> {

}

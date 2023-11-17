package br.com.dianome.entregadores.repository;

import br.com.dianome.entregadores.models.EntregadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadoresRepository extends JpaRepository<EntregadorModel, Integer> {

}

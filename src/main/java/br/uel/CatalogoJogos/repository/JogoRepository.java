package br.uel.CatalogoJogos.repository;

import br.uel.CatalogoJogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}


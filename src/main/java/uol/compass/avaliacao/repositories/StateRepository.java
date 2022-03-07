package uol.compass.avaliacao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import uol.compass.avaliacao.entities.State;
import uol.compass.avaliacao.entities.Regions;

public interface StateRepository extends JpaRepository<State, Long> {

	Page<State> findByRegiao(Regions regiao, Pageable paginacao);

}

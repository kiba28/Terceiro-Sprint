package uol.compass.avaliacao.resources;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import uol.compass.avaliacao.entities.State;
import uol.compass.avaliacao.entities.Regions;
import uol.compass.avaliacao.repositories.StateRepository;
import uol.compass.avaliacao.resources.dto.StateDto;
import uol.compass.avaliacao.resources.form.UpdateStateForm;
import uol.compass.avaliacao.resources.form.StateForm;

@RestController
@RequestMapping("/api/states")
public class StateController {

	@Autowired
	private StateRepository estadoRespository;

	@GetMapping
	public Page<StateDto> listar(@RequestParam(required = false) String regiao,
			@PageableDefault(sort = "id", direction = Direction.ASC) Pageable paginacao) {

		if (regiao == null) {
			Page<State> states = estadoRespository.findAll(paginacao);
			return StateDto.converter(states);
		} else {
			Page<State> states = estadoRespository.findByRegiao(Regions.valueOf(regiao), paginacao);
			return StateDto.converter(states);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<StateDto> cadastrar(@RequestBody @Valid StateForm stateForm,
			UriComponentsBuilder uriBuilder) {
		State state = stateForm.converter();
		estadoRespository.save(state);

		URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
		return ResponseEntity.created(uri).body(new StateDto(state));
	}

	@GetMapping("/{id}")
	public ResponseEntity<StateDto> detalhar(@PathVariable Long id) {
		Optional<State> optional = estadoRespository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.ok(new StateDto(optional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<StateDto> altualizar(@PathVariable Long id, @RequestBody @Valid UpdateStateForm form) {
		Optional<State> optional = estadoRespository.findById(id);
		if (optional.isPresent()) {
			State state = form.atualizar(id, estadoRespository);
			return ResponseEntity.ok(new StateDto(state));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable long id) {
		Optional<State> optional = estadoRespository.findById(id);
		if (optional.isPresent()) {
			estadoRespository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}

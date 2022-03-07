package uol.compass.avaliacao.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import uol.compass.avaliacao.entities.Regions;
import uol.compass.avaliacao.entities.State;
import uol.compass.avaliacao.repositories.StateRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private StateRepository stateRepository;

	@Override
	public void run(String... args) throws Exception {

		State s1 = new State("Paraíba", Regions.Nordeste, 4059905, "João Pessoa", 56.467, LocalDate.parse("1585-08-05"),
				436);
		State s2 = new State("Rio Grande do Norte", Regions.Nordeste, 3560903, "Natal", 52.809,
				LocalDate.parse("1822-09-07"), 199);

		stateRepository.saveAll(Arrays.asList(s1, s2));
	}
}

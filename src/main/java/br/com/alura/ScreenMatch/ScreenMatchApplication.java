package br.com.alura.ScreenMatch;

import br.com.alura.ScreenMatch.model.DadosEpsodios;
import br.com.alura.ScreenMatch.model.DadosSerie;
import br.com.alura.ScreenMatch.model.DadosTemporada;
import br.com.alura.ScreenMatch.service.ConsumoApi;
import br.com.alura.ScreenMatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenMatchApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("\"https://omdbapi.com/?t=gilmore+girls&season=1&apikey=8c350aed");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		json = consumoApi.obterDados("\"https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=8c350aed");
		DadosEpsodios dadosEpsodios = conversor.obterDados(json, DadosEpsodios.class);
		System.out.println(dadosEpsodios);

		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int  i = 1; i<=dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=8c350aed");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
	}
}

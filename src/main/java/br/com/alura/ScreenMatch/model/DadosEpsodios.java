package br.com.alura.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpsodios(@JsonAlias("Title") String tituloSerie,
                            @JsonAlias("Runtime") String duracaoEpisodios,
                            @JsonAlias("Episodes") Integer numero,
                            @JsonAlias ("imdbRating") String avaliacao,
                            @JsonAlias ("Released") String dataLacancamento) {
}

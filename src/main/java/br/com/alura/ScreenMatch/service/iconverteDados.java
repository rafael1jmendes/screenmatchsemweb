package br.com.alura.ScreenMatch.service;

public interface iconverteDados {
    <T> T obterDados (String json, Class<T> classe);
}

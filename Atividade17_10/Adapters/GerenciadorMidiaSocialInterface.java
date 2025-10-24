package Adapters;

import Models.*;

public interface GerenciadorMidiaSocialInterface {
    public void publicar(String usuario, Conteudo conteudo);
    public Estatisticas getEstatisticas(String usuario);
}

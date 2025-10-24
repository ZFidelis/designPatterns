package Adapters;

import APIs.InstagramApiSimulator;
import Models.Conteudo;
import Models.Estatisticas;

public class InstagramAdapter implements GerenciadorMidiaSocialInterface {
    private InstagramApiSimulator instagramAPI = new InstagramApiSimulator();

    @Override
    public void publicar(String usuario, Conteudo conteudo) {
        instagramAPI.publicarFoto(conteudo.getTexto(), conteudo.getImagemUrl());
    }

    @Override
    public Estatisticas getEstatisticas(String usuario) {
        int[] dados = instagramAPI.obterEstatisticasPost();
        return new Estatisticas(dados[0], dados[1], dados[2]);
    }
}

package Adapters;

import APIs.TiktokApiSimulator;
import Models.Conteudo;
import Models.Estatisticas;

public class TiktokAdapter implements GerenciadorMidiaSocialInterface {
    private TiktokApiSimulator tikTokAPI = new TiktokApiSimulator();

    @Override
    public void publicar(String usuario, Conteudo conteudo) {
        tikTokAPI.postarVideo(conteudo.getTexto(), conteudo.getImagemUrl());
    }

    @Override
    public Estatisticas getEstatisticas(String usuario) {
        int[] dados = tikTokAPI.obterEstatisticasVideo();
        return new Estatisticas(dados[0], dados[1], dados[2]);
    }
    
}

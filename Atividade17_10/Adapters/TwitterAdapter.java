package Adapters;

import APIs.TwitterApiSimulator;
import Models.Conteudo;
import Models.Estatisticas;

public class TwitterAdapter implements GerenciadorMidiaSocialInterface {
    private TwitterApiSimulator twitterApi = new TwitterApiSimulator();

    @Override
    public void publicar(String usuario, Conteudo conteudo) {
        twitterApi.postarTweet(conteudo.getTexto());
    }

    @Override
    public Estatisticas getEstatisticas(String usuario) {
        int[] dados = twitterApi.obterEstatisticasTweet();
        return new Estatisticas(dados[0], dados[1], dados[2]);
    }
}

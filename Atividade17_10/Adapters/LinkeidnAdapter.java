package Adapters;

import APIs.LinkedinApiSimulator;
import Models.Conteudo;
import Models.Estatisticas;

public class LinkeidnAdapter implements GerenciadorMidiaSocialInterface {
    private LinkedinApiSimulator linkedinAPI = new LinkedinApiSimulator();

    @Override
    public void publicar(String usuario, Conteudo conteudo) {
        linkedinAPI.compartilharPost(conteudo.getTexto());
    }

    @Override
    public Estatisticas getEstatisticas(String usuario) {
        int[] dados = linkedinAPI.obterMetricasPost();
        return new Estatisticas(dados[0], dados[1], dados[2]);
    }
}

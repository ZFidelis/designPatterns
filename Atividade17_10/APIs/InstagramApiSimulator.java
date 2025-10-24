package APIs;

public class InstagramApiSimulator {
    public void publicarFoto(String legenda, String imagemUrl) {
        System.out.println("[Instagram] Publicando foto: " + imagemUrl + " com legenda: " + legenda);
    }

    public int[] obterEstatisticasPost() {
        return new int[]{250, 80, 20};
    }
}

package APIs;

public class TiktokApiSimulator {
    public void postarVideo(String descricao, String videoUrl) {
        System.out.println("[TikTok] Publicando vídeo: " + videoUrl + " com descrição: " + descricao);
    }

    public int[] obterEstatisticasVideo() {
        return new int[]{500, 120, 60};
    }
}

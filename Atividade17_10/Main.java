import Adapters.GerenciadorMidiaSocialInterface;
import Models.Conteudo;

public class Main {
    public static void main(String[] args) {
        Conteudo conteudo = new Conteudo("Novo vídeo educativo!", "video.mp4");

        GerenciadorMidiaSocialInterface twitter = SocialMediaFactory.criar("twitter");
        GerenciadorMidiaSocialInterface instagram = SocialMediaFactory.criar("instagram");
        GerenciadorMidiaSocialInterface linkedin = SocialMediaFactory.criar("linkedin");
        GerenciadorMidiaSocialInterface tiktok = SocialMediaFactory.criar("tiktok");

        twitter.publicar("isaac", conteudo);
        instagram.publicar("isaac", conteudo);
        linkedin.publicar("isaac", conteudo);
        tiktok.publicar("isaac", conteudo);

        System.out.println("\n=== Estatísticas ===");
        System.out.println("Twitter -> " + twitter.getEstatisticas("isaac"));
        System.out.println("Instagram -> " + instagram.getEstatisticas("isaac"));
        System.out.println("LinkedIn -> " + linkedin.getEstatisticas("isaac"));
        System.out.println("TikTok -> " + tiktok.getEstatisticas("isaac"));
    }
}
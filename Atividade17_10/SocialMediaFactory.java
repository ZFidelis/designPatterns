import Adapters.*;

public class SocialMediaFactory {
    public static GerenciadorMidiaSocialInterface criar(String plataforma) {
        return switch (plataforma.toLowerCase()) {
            case "twitter" -> new TwitterAdapter();
            case "instagram" -> new InstagramAdapter();
            case "linkedin" -> new LinkeidnAdapter();
            case "tiktok" -> new TiktokAdapter();
            default -> null;
        };
    }
}

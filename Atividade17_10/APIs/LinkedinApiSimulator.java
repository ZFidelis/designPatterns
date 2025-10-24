package APIs;

public class LinkedinApiSimulator {
    public void compartilharPost(String conteudo) {
        System.out.println("[LinkedIn] Compartilhando post: " + conteudo);
    }

    public int[] obterMetricasPost() {
        return new int[]{90, 25, 10};
    }
}

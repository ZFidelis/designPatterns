package Atividades29_08.SistemaBiblioteca;

public class DigitalMedia extends LibraryItem {
    public String fileFormat;

    public DigitalMedia(String title, String author, int publicationYear, String fileFormat) {
        super(title, author, publicationYear);
        this.fileFormat = fileFormat;
    }

    public void play() {
        System.out.println("Rodando arquivo tipo: " + fileFormat);
    }

    public void showData() {
        super.showData();
        System.out.println(fileFormat);
    }

}
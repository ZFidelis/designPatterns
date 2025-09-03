package Atividades29_08.SistemaBiblioteca;

public class Book extends LibraryItem {
    public String genre;
    
    public Book(String title, String author, int publicationYear, String genre) {
        super(title, author, publicationYear);
        this.genre = genre;
    }

    public void readSample() {
        System.out.println("Ao ler uma parte do livro, nota que o mesmo é do gênero: " + genre);
    }

    public void showData() {
        super.showData();
        System.out.println(genre);
    }
    
}

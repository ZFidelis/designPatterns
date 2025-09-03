package Atividades29_08.SistemaBiblioteca;

public abstract class LibraryItem implements Borrowable {
    public String title;
    public String author;
    public int publicationYear;
    public boolean available;

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public void showData() {
        System.out.println(title);
        System.out.println(author);
        System.out.println(publicationYear);
        if (available) {
            System.out.println("Disponível");
        }
        else {
            System.out.println("Emprestado");
        }
    }

    @Override
    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Midia emprestado com sucesso!");
        }
        else {
            System.out.println("Midia não está disponível!");
        }
    }

    @Override
    public void returnItem() {
        if (!available) {
            available = true;
            System.out.println("Midia devolvido com sucesso!");
        }
        else {
            System.out.println("Midia já foi devolvido!");
        }
    }

}

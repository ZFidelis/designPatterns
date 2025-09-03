package Atividades29_08.SistemaBiblioteca;

public class Magazine extends LibraryItem {
    public int issueNumber;

    public Magazine(String title, String author, int publicationYear, int issueNumber) {
        super(title, author, publicationYear);
        this.issueNumber = issueNumber;
    }

    public void flipPages() {
        System.out.println("Folhando as páginas, você encontra o número de serial: " + issueNumber);
    }

    public void showData() {
        super.showData();
        System.out.println(issueNumber);
    }

}

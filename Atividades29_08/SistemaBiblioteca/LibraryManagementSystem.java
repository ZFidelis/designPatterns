package Atividades29_08.SistemaBiblioteca;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        LibraryItem bk1 = new Book("Livro Legal 1!", "Super Autor", 2020, "ação");
        LibraryItem mg1 = new Magazine("Revista Legal 1!", "Super Autor", 2020, 12344);
        LibraryItem dm1 = new DigitalMedia("Media Digital Legal 1!", "Super Autor", 2020, ".mp3");
    
        LibraryItem[] itens = { bk1, mg1, dm1 };
        
        bk1.borrow();
        
        for (LibraryItem item : itens) {
            System.out.println("=====");
            item.showData();
            System.out.println("=====");
        }

        mg1.borrow();
        mg1.returnItem();

        ((Book) bk1).readSample();
        ((Magazine) mg1).flipPages();
        ((DigitalMedia) dm1).play();
    }
}

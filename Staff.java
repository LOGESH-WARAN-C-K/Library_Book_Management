public class Staff {
    private String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void processPurchase(Book book) {
        System.out.println("Book purchased: " + book.getTitle());
    }

    public void processReturn(User user, Book book) {

        System.out.println("Book returned by " + user.getName() + ": " + book.getTitle());
    }
}

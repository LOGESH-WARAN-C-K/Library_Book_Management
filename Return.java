public class Return {
    public void returnBookToLibrary(User user, Book book) {
        System.out.println("Book returned by " + user.getName() + ": " + book.getTitle());
    }
}

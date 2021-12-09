package Task1;

public class UncheckedException {
    public static void main(final String[] args) {
        final String firstName = "Mark";
        final String lastName = "Black99";

        try {
            final User user = new User(firstName, lastName, 20, "mark@gmail.com", "Poland, Warsaw");
        } catch(final UserException e) {

            System.out.println(e.getMessage());
            System.out.println("Error code: " + e.getErrorCode());

        }
    }
}
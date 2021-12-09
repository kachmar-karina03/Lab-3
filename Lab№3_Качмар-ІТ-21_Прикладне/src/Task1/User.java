package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Address address;

    public User(final String firstName, final String lastName, final int age, final String email, final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.address = new Address(address);

        validate();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    public void validate() {
        final List<String> exceptionsMessages = new ArrayList<>();

        if(this.firstName == "") {
            exceptionsMessages.add("First name is empty");
        }
        if(Pattern.matches(".*\\d+.*", this.firstName)) {
            exceptionsMessages.add("First name contains numbers");
        }
        if(this.firstName.indexOf(" ") != -1) {
            exceptionsMessages.add("First name contains space");
        }
        if(this.lastName == "") {
            exceptionsMessages.add("Last name is empty");
        }
        if(Pattern.matches(".*\\d+.*", this.lastName)) {
            exceptionsMessages.add("Last name contains numbers");
        }
        if(this.lastName.indexOf(" ") != -1) {
            exceptionsMessages.add("Last name contains space");
        }
        if(this.age < 1) {
            exceptionsMessages.add("Age < 1");
        }
        if(this.email == "") {
            exceptionsMessages.add("Email is empty");
        }
        if(this.email.indexOf("@") == -1) {
            exceptionsMessages.add("Email does not contain @");
        }
        if(this.email.indexOf(".") == -1) {
            exceptionsMessages.add("Email does not contain .");
        }
        if(this.address.equals("")) {
            exceptionsMessages.add("Address is empty");
        }

        if(!exceptionsMessages.isEmpty()) {
            throw new UserException(exceptionsMessages, ErrorCode.ERROR_400);
        }

    }
}
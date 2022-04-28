package com.globant.data;

public class ProfileInfo {

    private final String[] firstNames = {"jose", "luis", "camilo", "pablo", "carlos"};
    private final String[] lastNames = {"tarazona", "florez", "quintero", "rodriguez", "garcia"};


    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public ProfileInfo() {

        this.firstName = firstNames[Utilities.getRandomNumber()];
        this.lastName = lastNames[Utilities.getRandomNumber()];
        this.email = this.firstName + "." + this.lastName + Utilities.getRandomNumber() + Utilities.getRandomNumber() + "@gmail.com";
        this.password = this.firstName + "123?";

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

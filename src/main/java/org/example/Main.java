package org.example;

public class Main {
    public static void main(String[] args) {
        System.setProperty("MYSQL_ROOT_PASSWORD", "1234");

        Login login = new Login();
        login.setVisible(true);
    }
}
package org.example;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Optinal {
    public static void main(String[] args){
        List<User> users = List.of (
                new User ("taras@gmail.com", "Taras Halynskyi", "password123", 30),
                new User ("taras@gmail.com", "Taras Halynskyi", "password123", 30),
                new User ("taras@gmail.com", "Taras Halynskyi", "password123", 30));

    }
    public static Optional<User> findUser(){
        return Optional.ofNullable (new User ("taras@gmail.com", "Taras Halynskyi", "password123", 30));
    }
}

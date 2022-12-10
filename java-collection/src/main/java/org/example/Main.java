package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println ("Hello world!");
        User user1 = new User ("taras@gmail.com", "Taras Halynskyi", "password123", 30);
        User user2 = new User ("taras@gmail.com", "Taras Halynskyi", "password123", 16);
        User user3 = new User ("taras@gmail.com", "Taras Halynskyi", "password123", 30);
        System.out.println ("List:");
        List<User> userList = new LinkedList<> (  );
        userList.add (user1);
        userList.add (user2);
        userList.add (user3);
        userList.remove (1);
        System.out.println (userList);

        userList.stream ().filter ((User user) -> {
            return user.getAge () > 18;
        }).collect(Collectors.toList ());

        Set<User> userSet = new HashSet<> (  );
        userSet.add (user1);
        userSet.add (user2);
        userSet.add (user3);
        userSet.remove (user2);
        System.out.println (userSet);

        System.out.println ("Map:");
        Map<String, User> usersMap = new HashMap<> (  );
        usersMap.put (user1.getEmail (), user1);
        usersMap.put (user2.getEmail (), user2);
        usersMap.put (user3.getEmail (), user3);
        usersMap.put ("xxx", user3);
    }
}
class User {
    private final String email;
    private String name;
    private String password;
    private int age;

    public User(String email, String name ,String password, int age){
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
    }
    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass ()!= o.getClass ())return false;
        User user = (User) o;
        if(age != user.age) return false;
        if(!email.equals(user.email)) return false;
        if(!Objects.equals(name, user.name))return false;
        return Objects.equals (password, user.password);
    }
    @Override
    public int hashCode(){
        int result = email.hashCode ();
        result = 31 * result + (name != null ? name.hashCode () : 0);
        result = 31 * result + (password != null ? password.hashCode () : 0);
        result = 31 * result + age;
        return result;
    }


}
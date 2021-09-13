package telran.string.controller;

import telran.string.user.User;

public class UserAppl {
    public static void main(String[] args) {
        User user =new User("rasalex@gmail.com", "J!qq5h8h5v");
        System.out.println(user);
        user.setEmail("Mary.Jones@gmail.com.");

    }
}

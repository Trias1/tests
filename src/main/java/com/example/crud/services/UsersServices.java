package com.example.crud.services;


import com.example.crud.model.UsersModel;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {

    @Autowired
    private UserRepository userRepository;

    public UsersServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersModel RegiserUser(String login, String password, String email){
        if (login == null && password == null){
            return null;
        }else {
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return userRepository.save(usersModel);
        }
    }

    public UsersModel authenticate(String login, String password){
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }

}

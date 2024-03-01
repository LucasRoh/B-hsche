package net.ict.campus.boesche.controller.services;

import net.ict.campus.boesche.controller.repositories.UserRepository;
import net.ict.campus.boesche.model.models.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCrypt;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCrypt) {
        this.userRepository = userRepository;
        this.bCrypt = bCrypt;
    }
    public User findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(EntityNotFoundException::new);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public void signUp(User user){
        user.setPassword(bCrypt.encode(user.getPassword()));
        userRepository.save(user);
    }
    public void updateUser(User user){
       user.setPassword(bCrypt.encode(user.getPassword()));
        userRepository.save(user);
    }
    public User findByName(String Name){
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(Name)) {
                return user;
            }
        }
        throw new EntityNotFoundException("Could not find user with name: " + Name + "");
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }
}

package com.maria.ejercicio.service.implementation;

import java.util.Optional;

import com.maria.ejercicio.model.User;
import com.maria.ejercicio.model.UserDocu;
import com.maria.ejercicio.repository.UserRepo;
import com.maria.ejercicio.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    
    @Autowired
    private UserRepo userRepository;

    @Override
    public Iterable<User> retrieveAll(){
        return userRepository.findAll();
    }

    @Autowired 
    private JdbcTemplate template;

    @Override 
    public Iterable<UserDocu> retrieveAllInfo(){
        String query = "SELECT * FROM USERS INNER JOIN DOCUMENTS ON USERS.USER_ID = DOCUMENTS.USER_ID";

        Iterable<UserDocu> userDocu = template.query(
            query,
            (data,rowNum) -> {
                return new UserDocu(
                    data.getLong("USERS.USER_ID"),
                    data.getString("USERS.USER"),
                    data.getString("USERS.COMMENT"),
                    data.getLong("DOCUMENTS.DOC_ID"),
                    data.getString("DOCUMENTS.DOC")
                );
            }
        );

        return userDocu;
    }


    @Override
    public User create(User user) {
        user.setId(null);
        return userRepository.save(user);
    }
        
    @Override 
    public User retrieve(Long id){
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return null;
        }
        return user.get();
    }
    @Override
    public void delete(Long id){
        User user = retrieve(id);
        userRepository.delete(user);
    }


    @Override
    public User update(User user, Long id){
        if (!user.getId().equals(id)) {
            return null;
        }

        return userRepository.save(user);
    }

}

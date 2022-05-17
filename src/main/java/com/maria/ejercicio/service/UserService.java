package com.maria.ejercicio.service;



import com.maria.ejercicio.model.User;
import com.maria.ejercicio.model.UserDocu;

public interface UserService {
    Iterable<User> retrieveAll();
    Iterable<UserDocu> retrieveAllInfo();
    User create(User user);
    void delete(Long id);
    User retrieve(Long id);
    User update(User user, Long id);

}

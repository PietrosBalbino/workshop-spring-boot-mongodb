package com.pietros.workshopmongo.services;

import com.pietros.workshopmongo.domain.User;
import com.pietros.workshopmongo.dto.UserDTO;
import com.pietros.workshopmongo.repository.UserRepository;
import com.pietros.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return repo.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }
//      vai receber um objeto e o id separados --eu criei--
//    public User update(String id, User user) {
//        User entity = findById(id);
//        updateData(entity, user);
//        return repo.save(entity);
//    }

    // aula
    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
    }
}

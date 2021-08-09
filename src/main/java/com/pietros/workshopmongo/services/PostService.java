package com.pietros.workshopmongo.services;

import com.pietros.workshopmongo.domain.Post;
import com.pietros.workshopmongo.domain.User;
import com.pietros.workshopmongo.dto.UserDTO;
import com.pietros.workshopmongo.repository.PostRepository;
import com.pietros.workshopmongo.repository.UserRepository;
import com.pietros.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}


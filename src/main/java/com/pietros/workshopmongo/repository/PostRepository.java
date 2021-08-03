package com.pietros.workshopmongo.repository;

import com.pietros.workshopmongo.domain.Post;
import com.pietros.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
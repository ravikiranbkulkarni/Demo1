package com.example.demo.repositories;



import com.example.demo.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;



public interface AuthorRepository extends JpaRepository <Author,Long>{



    List<Author> findByFirstNameOrderByLastNameDesc(String firstName);

}


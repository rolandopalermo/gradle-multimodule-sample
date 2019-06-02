package com.rolandopalermo.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolandopalermo.sample.repository.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
package com.example.demo.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T add(T t);
    void delete(Long id);
}

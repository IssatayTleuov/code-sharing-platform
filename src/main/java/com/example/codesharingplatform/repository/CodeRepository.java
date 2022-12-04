package com.example.codesharingplatform.repository;

import com.example.codesharingplatform.model.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeRepository extends CrudRepository<Code, String> {
    @Override
    <S extends Code> S save(S entity);

    @Override
    <S extends Code> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Code> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    Iterable<Code> findAll();

    @Override
    Iterable<Code> findAllById(Iterable<String> strings);

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    void delete(Code entity);

    @Override
    void deleteAllById(Iterable<? extends String> strings);

    @Override
    void deleteAll(Iterable<? extends Code> entities);

    @Override
    void deleteAll();
}

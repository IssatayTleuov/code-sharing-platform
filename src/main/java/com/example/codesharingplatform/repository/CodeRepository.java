package com.example.codesharingplatform.repository;

import com.example.codesharingplatform.model.Code;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {
    @Override
    <S extends Code> S save(S entity);

    @Override
    <S extends Code> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Code> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Code> findAll();

    @Override
    Iterable<Code> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Code entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Code> entities);

    @Override
    void deleteAll();
}

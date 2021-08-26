package com.th.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity,Integer> {
    CountryEntity findFirstById(Integer id);

    @Override
    List<CountryEntity> findAll();

    @Override
    void deleteById(Integer integer);
}

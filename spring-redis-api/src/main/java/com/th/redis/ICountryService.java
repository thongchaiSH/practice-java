package com.th.redis;

import java.util.List;

public interface ICountryService {
    CountryEntity save(CountryEntity countryEntity);
    CountryEntity findById(Integer id);
    List<CountryEntity> delete(Integer id);
}

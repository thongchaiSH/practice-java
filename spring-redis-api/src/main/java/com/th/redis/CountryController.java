package com.th.redis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final ICountryService countryService;

    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }
    @PostMapping(value = "/save")
    public ResponseEntity<CountryEntity> save(@RequestBody CountryEntity request) throws RuntimeException {
        return new ResponseEntity<>(countryService.save(request), HttpStatus.OK);
    }

    @GetMapping(value = "/findById")
    public ResponseEntity<CountryEntity> findById(@RequestParam Integer id) throws RuntimeException {
        return new ResponseEntity<>(countryService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/deleteById")
    public ResponseEntity<List<CountryEntity>> deleteById(@RequestParam Integer id) throws RuntimeException {
        return new ResponseEntity<>(countryService.delete(id), HttpStatus.OK);
    }
}

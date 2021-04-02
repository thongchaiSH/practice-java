package com.iths.userservice.api.users.service;

import java.util.ArrayList;
import java.util.List;

import com.iths.userservice.api.users.data.AlbumsServiceClient;
import com.iths.userservice.api.users.data.UserEntity;
import com.iths.userservice.api.users.data.UsersRepository;
import com.iths.userservice.api.users.shared.UserDto;

import com.iths.userservice.ui.model.AlbumResponseModel;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersServiceImpl implements UsersService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    UsersRepository usersRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    RestTemplate restTemplate;
    Environment environment;
    AlbumsServiceClient albumsServiceClient;

    @Autowired
    public UsersServiceImpl(AlbumsServiceClient albumsServiceClient, Environment environment, UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RestTemplate restTemplate) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.restTemplate = restTemplate;
        this.environment = environment;
        this.albumsServiceClient = albumsServiceClient;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
        // TODO Auto-generated method stub
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        usersRepository.save(userEntity);

        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {
        UserEntity userEntity = usersRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        return new ModelMapper().map(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = usersRepository.findByUserId(userId);
        if (userEntity == null) throw new UsernameNotFoundException("User not found");
        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

//        String albumsUrl = String.format(environment.getProperty("albums.url"), userId);
//        ResponseEntity<List<AlbumResponseModel>> albumsListResponse = restTemplate.exchange(albumsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumResponseModel>>() {
//        });
//        List<AlbumResponseModel> albumsList = albumsListResponse.getBody();
    /*
        List<AlbumResponseModel> albumsList=null;
        try {
            albumsList = albumsServiceClient.getAlbums(userId);
        }catch (FeignException e){
            logger.error(e.getLocalizedMessage());
        }
*/
        logger.info("Before call albumsServiceClient");
        List<AlbumResponseModel> albumsList = albumsServiceClient.getAlbums(userId);
        logger.info("After call albumsServiceClient");

        userDto.setAlbums(albumsList);
        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByEmail(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
    }
}

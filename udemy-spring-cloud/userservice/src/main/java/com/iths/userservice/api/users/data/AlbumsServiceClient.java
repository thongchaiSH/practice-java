package com.iths.userservice.api.users.data;

import com.iths.userservice.ui.model.AlbumResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "albums-ws",fallbackFactory = AlbumsFallbackFactory.class)
public interface AlbumsServiceClient {

    @GetMapping("/users/{id}/albums")
    List<AlbumResponseModel> getAlbums(@PathVariable String id);
}

@Component
class AlbumsFallbackFactory implements FallbackFactory<AlbumsServiceClient>{

    @Override
    public AlbumsServiceClient create(Throwable cause) {
        return new AlbumsFallback(cause);
    }
}


class AlbumsFallback implements AlbumsServiceClient{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Throwable cause;

    public  AlbumsFallback(Throwable cause){
        this.cause=cause;
    }

    @Override
    public List<AlbumResponseModel> getAlbums(String id) {
        logger.error("Error Here!!!");
        return  new ArrayList<>();
    }
}
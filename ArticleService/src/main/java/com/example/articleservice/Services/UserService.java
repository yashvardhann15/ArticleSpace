package com.example.articleservice.Services;

import com.example.articleservice.Configuration.FeignClientConfig;
import com.example.articleservice.Dto.UserServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(
        name = "UserServiceJWT",
        url = "${application.config.UserServiceJWT}",
        configuration = FeignClientConfig.class
)
public interface UserService {

    @GetMapping("/u")
    ResponseEntity<UserServiceDTO> getUser(@RequestParam("email") String email);
}

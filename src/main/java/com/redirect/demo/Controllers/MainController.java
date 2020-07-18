package com.redirect.demo.Controllers;

import com.redirect.demo.Exception.Error;
import com.redirect.demo.Model.WebKeyDTO;
import com.redirect.demo.Service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MainController {

    private KeyService keyService;

    @GetMapping("/{key}")
    public RedirectView redirectWithKey(@PathVariable String key){
        String mainRedirect = keyService.mainRedirect(key);
        String http = "http://";
        return  new RedirectView(http+mainRedirect);

    }

    @PostMapping()
    public String StoreWebKey(@RequestBody WebKeyDTO dto){
        if (dto.getKey().isEmpty() || dto.getKey().equalsIgnoreCase(" ") || dto.getKey().equalsIgnoreCase("null")){
           return  keyService.postShortUrl(dto.getUrl());
        }
        return keyService.postShortUrl(dto.getUrl(),dto.getKey());
    }



    @ExceptionHandler({RuntimeException.class,Exception.class})
    public ResponseEntity<Error> handleBadRequest(RuntimeException e){
      Error eObject =  new Error(HttpStatus.BAD_REQUEST,e.getMessage().toString());
        return new ResponseEntity<>(eObject,HttpStatus.BAD_REQUEST);
    }

    @Autowired
    public MainController(KeyService keyService) {
        this.keyService = keyService;
    }
}

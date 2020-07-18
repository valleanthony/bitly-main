package com.redirect.demo.Service;

import com.redirect.demo.Model.WebKey;
import com.redirect.demo.Repos.KeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Service
public class KeyService {

    private static final String topUrl = "http://localhost:8080/";
    private KeyRepo keyRepo;

    @Autowired
    public KeyService(KeyRepo keyRepo) {
        this.keyRepo = keyRepo;
    }

    public String mainRedirect(String key){
     WebKey holder = keyRepo.findByKey(key).orElseThrow(()->new RuntimeException("Link with that Key does not exist"));
     return holder.getUrl();
    }

    public String postShortUrl (String url)throws RuntimeException{
        WebKey temp = new WebKey();
        try{
           if (urlValidator(url)){
                temp.setUrl(url);
                temp.setKey(generateKeyCode());
            }
        }catch (RuntimeException e){
            throw e;
        }
        String key = keyRepo.save(temp).getKey();
        return topUrl + key;
    }

    public String postShortUrl (String url, String userGenKey) throws RuntimeException{
        WebKey temp = new WebKey();
        if (urlValidator(url)){
            temp.setUrl(url);
        }
        String validator = userProvidedKeyValidator(userGenKey);
        temp.setKey(validator);
        String key = keyRepo.save(temp).getKey();
        return topUrl +key;
    }



    private boolean urlValidator(String url) {
        String valid = new String(url);
        boolean check = valid.matches("[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)");
        if (!check){
            throw new RuntimeException("Not a valid URL");
        }
        return true;
    }

    private String generateKeyCode(){
       String keyGen =  UUID.randomUUID().toString();
        keyGen= keyGen.replace("-","");
        keyGen= keyGen.substring(0,5);
        final String s = keyGen;
        return s;
    }

    private String userProvidedKeyValidator(String key){
        if (keyRepo.existsByKey(key)){
            throw new RuntimeException("Your Key is already being used");
        }
        return key;
    }

}

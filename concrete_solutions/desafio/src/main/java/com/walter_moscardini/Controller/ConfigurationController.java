package com.walter_moscardini.Controller;

import com.walter_moscardini.Model.Phone;
import com.walter_moscardini.Model.User;
import com.walter_moscardini.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/config")
public class ConfigurationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public void init(){

        userService.createUser(
                new User("Walter",
                        "walter.jpm@gmail.com",
                        "walterPass",
                        Stream.of(
                                new Phone("11112222",
                                        "99"))
                                .collect(Collectors.toCollection(ArrayList::new))
                )
        );

        userService.createUser(
                new User("Francisco",
                        "francisco@concrete.com",
                        "franciscoPass",
                        Stream.of(
                                new Phone("33334444",
                                        "99"))
                                .collect(Collectors.toCollection(ArrayList::new))
                )
        );

        userService.createUser(
                new User("Helena",
                        "helena@concrete.com",
                        "helenaPass",
                        Stream.of(
                                new Phone("55556666",
                                        "99"))
                                .collect(Collectors.toCollection(ArrayList::new))
                )
        );

    }

}

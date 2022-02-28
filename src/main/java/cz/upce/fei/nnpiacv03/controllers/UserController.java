package cz.upce.fei.nnpiacv03.controllers;

import cz.upce.fei.nnpiacv03.services.SessionService;
import cz.upce.fei.nnpiacv03.users.User;
import cz.upce.fei.nnpiacv03.users.UsersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    private final UsersService usersService;
    private final SessionService userSessionService;

    public UserController(@Qualifier("usersServiceImpl") UsersService usersService,
                          @Qualifier("userSessionServiceImpl") SessionService userSessionService) {
        this.usersService = usersService;
        this.userSessionService = userSessionService;
    }

    @GetMapping("/{id}")
    public String userPage(@PathVariable("id") Integer userId, Model model){
        User user = usersService.getUser(userId);
        if (user != null){
            model.addAttribute("user", user);
            return "userPage";
        }

        return "notFound";
    }
}

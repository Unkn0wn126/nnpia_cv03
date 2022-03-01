package cz.upce.fei.nnpiacv03.controllers;

import cz.upce.fei.nnpiacv03.posts.Post;
import cz.upce.fei.nnpiacv03.services.AnswerService;
import cz.upce.fei.nnpiacv03.services.SessionService;
import cz.upce.fei.nnpiacv03.users.User;
import cz.upce.fei.nnpiacv03.users.UsersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    private final UsersService usersService;
    private final SessionService userSessionService;
    private final AnswerService allAnswerService;

    public UserController(@Qualifier("usersServiceImpl") UsersService usersService,
                          @Qualifier("userSessionServiceImpl") SessionService userSessionService,
                          @Qualifier("allAnswerServiceImpl") AnswerService allAnswerService) {
        this.usersService = usersService;
        this.userSessionService = userSessionService;
        this.allAnswerService = allAnswerService;
    }

    @GetMapping("/{id}")
    public String userPage(@PathVariable("id") Integer userId, Model model){
        if (userSessionService.getUser() == null){
            return "redirect:/";
        }

        User user = usersService.getUser(userId);
        if (user != null){
            model.addAttribute("user", user);
            List<Post> posts = allAnswerService.getAnswers();
            List<Post> userPosts = new ArrayList<>();
            for (Post post:
                 posts) {
                if (post.getUserId() == userId){
                    userPosts.add(post);
                }
            }
            model.addAttribute("userPosts", userPosts);
            return "userPage";
        }

        return "notFound";
    }

    @GetMapping("/")
    public String userList(Model model){
        if (userSessionService.getUser() == null){
            return "redirect:/";
        }

        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);

        return "usersList";
    }
}

package cz.upce.fei.nnpiacv03.controllers;

import cz.upce.fei.nnpiacv03.posts.Post;
import cz.upce.fei.nnpiacv03.services.AnswerService;
import cz.upce.fei.nnpiacv03.services.CounterService;
import cz.upce.fei.nnpiacv03.services.SessionService;
import cz.upce.fei.nnpiacv03.users.UsersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final AnswerService allAnswerService;
    private final AnswerService individualAnswerService;
    private final SessionService userSessionService;
    private final UsersService usersService;
    private CounterService postCounterService;

    public PostController(@Qualifier("allAnswerServiceImpl") AnswerService allAnswerService,
                          @Qualifier("individualAnswerServiceImpl") AnswerService individualAnswerService,
                          @Qualifier("postCounterServiceImpl") CounterService postCounterService,
                          @Qualifier("userSessionServiceImpl") SessionService userSessionService,
                          @Qualifier("usersServiceImpl") UsersService usersService) {
        this.allAnswerService = allAnswerService;
        this.individualAnswerService = individualAnswerService;
        this.userSessionService = userSessionService;
        this.postCounterService = postCounterService;
        this.usersService = usersService;
    }

    @GetMapping("/post")
    public String postForm(Model model){
        if (userSessionService.getUser() == null){
            return "redirect:/";
        }
        model.addAttribute("post", new Post());

        return "greeting";
    }

    @PostMapping("/post")
    public String greetingSubmit(@ModelAttribute Post post, Model model){
        if (userSessionService.getUser() == null){
            return "redirect:/";
        }
        model.addAttribute("post", post);
        post.setId(postCounterService.getId());
        post.setUserId(userSessionService.getUser().getUserId());

        allAnswerService.addAnswer(post);
        individualAnswerService.addAnswer(post);

        return "result";
    }

    @GetMapping("/")
    public String postList(Model model){
        if (userSessionService.getUser() == null){
            return "redirect:/";
        }
        model.addAttribute("greeting", new Post());
        model.addAttribute("allAnswers", allAnswerService.getAnswers());
        model.addAttribute("individualAnswers", individualAnswerService.getAnswers());
        return "postsList";
    }

    @GetMapping("/user")
    public String userPostList(@RequestParam(name = "userid", required = false) Integer userId, Model model){
        if (userSessionService.getUser() == null){
            return "redirect:/";
        }

        List<Post> posts = allAnswerService.getAnswers();
        List<Post> userPosts = new ArrayList<>();
        for (Post post:
                posts) {
            if (post.getUserId() == userId){
                userPosts.add(post);
            }
        }

        model.addAttribute("greeting", new Post());
        model.addAttribute("allAnswers", userPosts);
        model.addAttribute("individualAnswers", individualAnswerService.getAnswers());
        return "userPostsList";
    }
}

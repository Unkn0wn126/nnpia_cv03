package cz.upce.fei.nnpiacv03.controllers;

import cz.upce.fei.nnpiacv03.posts.Greeting;
import cz.upce.fei.nnpiacv03.services.AnswerService;
import cz.upce.fei.nnpiacv03.services.CounterService;
import cz.upce.fei.nnpiacv03.services.SessionService;
import cz.upce.fei.nnpiacv03.users.User;
import cz.upce.fei.nnpiacv03.users.UsersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    private final AnswerService allAnswerService;
    private final AnswerService individualAnswerService;
    private final SessionService userSessionService;
    private final UsersService usersService;
    private CounterService sessionCounterService;

    public GreetingController(@Qualifier("allAnswerServiceImpl") AnswerService allAnswerService,
                              @Qualifier("individualAnswerServiceImpl") AnswerService individualAnswerService,
                              @Qualifier("sessionCounterServiceImpl") CounterService sessionCounterService,
                              @Qualifier("userSessionServiceImpl") SessionService userSessionService,
                              @Qualifier("usersServiceImpl") UsersService usersService) {
        this.allAnswerService = allAnswerService;
        this.individualAnswerService = individualAnswerService;
        this.userSessionService = userSessionService;
        this.sessionCounterService = sessionCounterService;
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String greetingPage(Model model){
        if (userSessionService.getUser() == null)
            model.addAttribute("user", new User());
        else
            model.addAttribute("user", userSessionService.getUser());

        return "greetingPage";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        if (userSessionService.getUser() == null){
            user.setUserId(sessionCounterService.getId());
            userSessionService.setUser(user);
            usersService.addUser(user);
        }

        return "userPage";
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model){
        model.addAttribute("greeting", new Greeting());
        model.addAttribute("allAnswers", allAnswerService.getAnswers());
        model.addAttribute("individualAnswers", individualAnswerService.getAnswers());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model){
        model.addAttribute("greeting", greeting);
        allAnswerService.addAnswer(greeting);
        individualAnswerService.addAnswer(greeting);
        model.addAttribute("allAnswers", allAnswerService.getAnswers());
        model.addAttribute("individualAnswers", individualAnswerService.getAnswers());
        return "result";
    }
}

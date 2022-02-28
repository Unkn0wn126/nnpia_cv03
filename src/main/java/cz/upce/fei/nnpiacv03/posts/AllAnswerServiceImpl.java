package cz.upce.fei.nnpiacv03.posts;

import cz.upce.fei.nnpiacv03.services.AnswerService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AllAnswerServiceImpl implements AnswerService {
    private final List<Greeting> answers;

    public AllAnswerServiceImpl(){
        answers = new ArrayList<>();
    }

    @Override
    public void addAnswer(Greeting answer){
        answers.add(answer);
    }

    @Override
    public List<Greeting> getAnswers(){
        return answers;
    }
}

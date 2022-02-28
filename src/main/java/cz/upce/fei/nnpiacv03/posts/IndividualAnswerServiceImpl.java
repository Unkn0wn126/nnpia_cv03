package cz.upce.fei.nnpiacv03.posts;

import cz.upce.fei.nnpiacv03.services.AnswerService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IndividualAnswerServiceImpl implements AnswerService {
    private final List<Greeting> answers;

    public IndividualAnswerServiceImpl(){
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

package cz.upce.fei.nnpiacv03.services;

import cz.upce.fei.nnpiacv03.posts.Greeting;

import java.util.List;

public interface AnswerService {
    public void addAnswer(Greeting answer);

    public List<Greeting> getAnswers();
}

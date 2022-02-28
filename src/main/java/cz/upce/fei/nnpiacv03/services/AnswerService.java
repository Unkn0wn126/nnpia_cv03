package cz.upce.fei.nnpiacv03.services;

import cz.upce.fei.nnpiacv03.posts.Post;

import java.util.List;

public interface AnswerService {
    void addAnswer(Post answer);

    List<Post> getAnswers();
}

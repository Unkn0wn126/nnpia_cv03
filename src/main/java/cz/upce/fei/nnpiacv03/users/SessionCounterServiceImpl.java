package cz.upce.fei.nnpiacv03.users;

import cz.upce.fei.nnpiacv03.services.CounterService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionCounterServiceImpl implements CounterService {
    private Integer counter = 0;

    @Override
    public Integer getId() {
        counter++;
        return counter;
    }
}

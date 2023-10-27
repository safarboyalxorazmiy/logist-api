package uz.logist.outcome;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutcomeService {
    private final OutcomeRepository outcomeRepository;

    public List<OutcomeEntity> getLast() {
        return null;
     }
}
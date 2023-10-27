package uz.logist.outcome;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/outcome")
@RequiredArgsConstructor
public class OutcomeController {
    private final OutcomeService outcomeService;

    @PreAuthorize("permitAll()")
    @GetMapping("/get")
    public List<OutcomeEntity> getLast() {
        System.out.println(outcomeService.getLast());
        return outcomeService.getLast();
    }
}

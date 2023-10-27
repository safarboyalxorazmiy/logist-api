package uz.logist.logist.component;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import uz.logist.logist.component.dto.LogistComponentInfoDTO;
import uz.logist.logist.component.dto.LogistComponentRequestSumbitDTO;
import uz.logist.user.User;

import java.util.List;

@RestController
@RequestMapping("/logist")
@RequiredArgsConstructor
public class LogistComponentController {
    private final LogistComponentService logistComponentService;

    @PreAuthorize("permitAll()")
    @PostMapping("/component/submit")
    public ResponseEntity<Boolean> submitComponentRequest(@RequestBody LogistComponentRequestSumbitDTO dto) {
        Boolean result = logistComponentService.submitComponent(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/component/not/verified")
    public ResponseEntity<List<LogistComponentInfoDTO>> getNotVerifiedRequests() {
        List<LogistComponentInfoDTO> result = logistComponentService.getNotVerifiedComponents();
        return ResponseEntity.ok(result);
    }

    @PutMapping("/component/verify")
    public ResponseEntity<Boolean> verifyRequest(@RequestParam Long requestId) {
        Boolean result = logistComponentService.verifyRequest(requestId);
        return ResponseEntity.ok(result);
    }

    private Long getLogistId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        return user.getId();
    }

}
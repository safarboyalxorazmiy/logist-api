package uz.logist.logist.component;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.logist.logist.component.dto.ComponentInfoDTO;
import uz.logist.logist.component.dto.ComponentSumbitDTO;
import uz.logist.user.User;

import java.util.List;

@RestController
@RequestMapping("/logist")
@RequiredArgsConstructor
public class LogistComponentController {
    private final LogistComponentService logistComponentService;

    @PreAuthorize("permitAll()")
    @PostMapping("/component/submit")
    public ResponseEntity<Boolean> submitComponent(@RequestBody ComponentSumbitDTO dto) {
        Boolean result = logistComponentService.submitComponent(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/component/not/verified")
    public ResponseEntity<List<ComponentInfoDTO>> getNotVerifiedComponents() {
        List<ComponentInfoDTO> result = logistComponentService.getNotVerifiedComponents();
        return ResponseEntity.ok(result);
    }

    private Long getLogistId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        return user.getId();
    }

}
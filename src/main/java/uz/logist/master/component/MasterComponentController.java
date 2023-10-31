package uz.logist.master.component;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.logist.master.component.dto.MasterComponentRequestSumbitDTO;
import uz.logist.master.component.dto.MasterInfoDTO;

import java.util.List;

@RestController
@RequestMapping("/master")
@RequiredArgsConstructor
public class MasterComponentController {
  private final MasterComponentRequestService masterComponentRequestService;

  @PreAuthorize("permitAll()")
  @PostMapping("/component/submit")
  public ResponseEntity<Boolean> submitComponentRequest(@RequestBody MasterComponentRequestSumbitDTO dto) {
    System.out.println(dto);
    Boolean result = masterComponentRequestService.submitComponent(dto);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/get/info")
  public ResponseEntity<List<MasterInfoDTO>> getAllLogists() {
    List<MasterInfoDTO> result = masterComponentRequestService.getAllMastersInfo();
    return ResponseEntity.ok(result);
  }


}
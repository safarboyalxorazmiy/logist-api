package uz.logist.components;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/components")
@RequiredArgsConstructor
public class ComponentsController {
  private final ComponentsService componentsService;

  @PreAuthorize("permitAll()")
  @GetMapping("/get/all")
  public List<ComponentsEntity> getAll() {
    return componentsService.getAll();
  }
}
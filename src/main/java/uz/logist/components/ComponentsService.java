package uz.logist.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComponentsService {
  private final ComponentsRepository componentsRepository;

  public List<ComponentsEntity> getAll() {
    return componentsRepository.findAll();
  }
}
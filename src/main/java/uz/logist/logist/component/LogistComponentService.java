package uz.logist.logist.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.logist.components.ComponentsEntity;
import uz.logist.components.ComponentsRepository;
import uz.logist.logist.component.dto.LogistComponentInfoDTO;
import uz.logist.logist.component.dto.LogistComponentRequestSumbitDTO;
import uz.logist.logist.component.dto.LogistInfoDTO;
import uz.logist.user.Role;
import uz.logist.user.User;
import uz.logist.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogistComponentService {
  private final LogistComponentRequestRepository logistComponentRequestRepository;
  private final LogistComponentRepository logistComponentRepository;
  private final ComponentsRepository componentsRepository;
  private final UserRepository userRepository;

  public Boolean submitComponent(LogistComponentRequestSumbitDTO dto) {
    // IS COMPONENT EXISTS??
    Optional<ComponentsEntity> byComponentId = componentsRepository.findById(dto.getComponentId());
    if (byComponentId.isEmpty()) {
      return false;
    }

    // IS LOGIST EXISTS??
    Optional<User> byLogistId = userRepository.findById(dto.getLogistId());
    if (byLogistId.isEmpty()) {
      return false;
    }

    // CREATE REQUEST
    LogistComponentRequestEntity logistComponent = new LogistComponentRequestEntity();
    logistComponent.setLogistId(dto.getLogistId());
    logistComponent.setComponentId(dto.getComponentId());
    logistComponent.setQuantity(dto.getQuantity());
    logistComponent.setVerified(false);

    logistComponentRequestRepository.save(logistComponent);
    return true;
  }

  public List<LogistComponentInfoDTO> getNotVerifiedComponents() {
    List<LogistComponentRequestEntity> byVerifiedFalse = logistComponentRequestRepository.findByVerifiedFalse();

    List<LogistComponentInfoDTO> result = new ArrayList<>();
    for (LogistComponentRequestEntity logistComponent : byVerifiedFalse) {
      LogistComponentInfoDTO dto = new LogistComponentInfoDTO();
      dto.setId(logistComponent.getId());
      dto.setQuantity(logistComponent.getQuantity());
      dto.setComponentId(logistComponent.getComponentId());
      dto.setLogistId(logistComponent.getLogistId());
      result.add(dto);
    }

    return result;
  }

  public Boolean verifyRequest(Long requestId) {
    // REQUEST EXISTS??
    Optional<LogistComponentRequestEntity> byRequestId = logistComponentRequestRepository.findById(requestId);
    if (byRequestId.isEmpty()) {
      return false;
    }

    // SET REQUEST VERIFIED
    LogistComponentRequestEntity requestEntity = byRequestId.get();
    requestEntity.setVerified(true);
    logistComponentRequestRepository.save(requestEntity);

    // CHECK COMPONENT EXISTS IN LOGIST
    Optional<LogistComponentEntity> byComponentIdAndLogistId = logistComponentRepository.findByComponentIdAndLogistId(requestEntity.getComponentId(), requestEntity.getLogistId());
    if (byComponentIdAndLogistId.isEmpty()) {
      // NOT EXISTS CREATE ONE
      LogistComponentEntity logistComponent = new LogistComponentEntity();
      logistComponent.setComponentId(requestEntity.getComponentId());
      logistComponent.setLogistId(requestEntity.getLogistId());
      logistComponent.setQuantity(requestEntity.getQuantity());

      logistComponentRepository.save(logistComponent);
      return true;
    }

    // EXISTS SET QUANTITY
    LogistComponentEntity logistComponent = byComponentIdAndLogistId.get();
    logistComponent.setQuantity(logistComponent.getQuantity() + requestEntity.getQuantity());
    logistComponentRepository.save(logistComponent);
    return true;
  }

  public List<LogistInfoDTO> getAllLogistsInfo() {
    List<User> byRoleLogist = userRepository.findByRole(Role.LOGIST);
    List<LogistInfoDTO> result = new ArrayList<>();
    for (User user : byRoleLogist) {
      LogistInfoDTO dto = new LogistInfoDTO();
      dto.setFirstName(user.getFirstname());
      dto.setLastName(user.getLastname());
      dto.setId(user.getId());
      result.add(dto);
    }

    return result;
  }
}
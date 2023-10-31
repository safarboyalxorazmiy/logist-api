package uz.logist.master.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.logist.components.ComponentsEntity;
import uz.logist.components.ComponentsRepository;
import uz.logist.logist.component.LogistComponentEntity;
import uz.logist.logist.component.LogistComponentRequestEntity;
import uz.logist.logist.component.dto.LogistComponentInfoDTO;
import uz.logist.logist.component.dto.LogistInfoDTO;
import uz.logist.master.component.dto.MasterComponentRequestSumbitDTO;
import uz.logist.master.component.dto.MasterInfoDTO;
import uz.logist.user.Role;
import uz.logist.user.User;
import uz.logist.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MasterComponentRequestService {
  private final MasterComponentRequestRepository masterComponentRequestRepository;
  private final ComponentsRepository componentsRepository;
  private final UserRepository userRepository;

  public Boolean submitComponent(MasterComponentRequestSumbitDTO dto) {
    // IS COMPONENT EXISTS??
    Optional<ComponentsEntity> byComponentId = componentsRepository.findById(dto.getComponentId());
    if (byComponentId.isEmpty()) {
      return false;
    }

    // IS LOGIST EXISTS??
    Optional<User> byLogistId = userRepository.findById(dto.getMasterId());
    if (byLogistId.isEmpty()) {
      return false;
    }

    // CREATE REQUEST
    MasterComponentRequestEntity logistComponent = new MasterComponentRequestEntity();
    logistComponent.setMasterId(dto.getMasterId());
    logistComponent.setComponentId(dto.getComponentId());
    logistComponent.setQuantity(dto.getQuantity());
    logistComponent.setVerified(false);

    masterComponentRequestRepository.save(logistComponent);
    return true;
  }

  public List<MasterInfoDTO> getAllMastersInfo() {
    List<User> byRoleLogist = userRepository.findByRole(Role.MASTER);
    List<MasterInfoDTO> result = new ArrayList<>();
    for (User user : byRoleLogist) {
      MasterInfoDTO dto = new MasterInfoDTO();
      dto.setFirstName(user.getFirstname());
      dto.setLastName(user.getLastname());
      dto.setId(user.getId());
      result.add(dto);
    }

    return result;
  }
}
package uz.logist.logist.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.logist.logist.component.dto.ComponentInfoDTO;
import uz.logist.logist.component.dto.ComponentSumbitDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogistComponentService {
    private final LogistComponentRepository logistComponentRepository;

    public Boolean submitComponent(ComponentSumbitDTO dto) {
        LogistComponentEntity logistComponent = new LogistComponentEntity();
        logistComponent.setLogistId(dto.getLogistId());
        logistComponent.setComponentId(dto.getComponentId());
        logistComponent.setQuantity(dto.getQuantity());
        logistComponent.setVerified(false);
        
        logistComponentRepository.save(logistComponent);
        return true;
    }


    public List<ComponentInfoDTO> getNotVerifiedComponents() {
        List<LogistComponentEntity> byVerifiedFalse = logistComponentRepository.findByVerifiedFalse();

        List<ComponentInfoDTO> result = new ArrayList<>();
        for (LogistComponentEntity logistComponent : byVerifiedFalse) {
            ComponentInfoDTO dto = new ComponentInfoDTO();
            dto.setId(logistComponent.getId());
            dto.setQuantity(logistComponent.getQuantity());
            dto.setComponentId(logistComponent.getComponentId());
            dto.setLogistId(logistComponent.getLogistId());
            result.add(dto);
        }

        return result;
    }
}
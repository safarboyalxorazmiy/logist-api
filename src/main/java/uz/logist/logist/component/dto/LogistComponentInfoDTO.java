package uz.logist.logist.component.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogistComponentInfoDTO {
    private Long id,
            componentId,
            logistId;
    private Double quantity;
}
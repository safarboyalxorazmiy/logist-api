package uz.logist.logist.component.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogistComponentRequestSumbitDTO {
    private Long componentId, logistId;
    private Double quantity;
}
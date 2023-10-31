package uz.logist.logist.component.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogistComponentRequestSumbitDTO {
    private Long componentId;
    private Long logistId;
    private Double quantity;
}
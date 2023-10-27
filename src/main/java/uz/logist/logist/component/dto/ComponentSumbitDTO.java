package uz.logist.logist.component.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComponentSumbitDTO {
    private Long componentId, logistId;
    private Double quantity;
}
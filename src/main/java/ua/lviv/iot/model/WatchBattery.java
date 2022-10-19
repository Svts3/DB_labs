package ua.lviv.iot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WatchBattery {

    private Long id;
    private Integer chardeLevel;
    private String watchSerialNumber;
    
}

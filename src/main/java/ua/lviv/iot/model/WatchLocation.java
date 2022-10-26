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
public class WatchLocation {

    private Long id;
    private Double latitude;
    private Double longitude;
    private String watchSerialNumber;
}

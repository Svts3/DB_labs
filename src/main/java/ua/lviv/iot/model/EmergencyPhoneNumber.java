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
public class EmergencyPhoneNumber {

    private Long id;
    private String phoneNumber;
    private String watchSerialNumber;
}

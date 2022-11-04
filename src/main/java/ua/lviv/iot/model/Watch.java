package ua.lviv.iot.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Watch {
    @Id
    private String serialNumber;
    
    @OneToOne
    @JoinColumn(name = "street_name", referencedColumnName = "name", nullable=false)
    private Street street;
    
    @OneToMany(mappedBy = "watch")
    private List<HealthInfo> healthInfos;
    
    @OneToMany(mappedBy = "watch")
    private List<WatchLocation>watchLocations;
    
    @OneToMany(mappedBy = "watch")
    private List<WatchBattery>watchBatteries;
    
    @OneToMany(mappedBy = "watch")
    private List<EmergencyPhoneNumber>emergencyPhoneNumbers;
    
    @OneToMany(mappedBy = "watch")
    public Set<PropertyInfo>propertyInfos;
    
}

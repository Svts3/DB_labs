package ua.lviv.iot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class City {
    @Id
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "region_name", referencedColumnName = "name", nullable = false)
    private Region region;
    
    @OneToMany(mappedBy = "city")
    private List<Street>streets;
    
    
    
    
    

}

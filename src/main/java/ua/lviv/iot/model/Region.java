package ua.lviv.iot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Region {
    @Id
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_name", referencedColumnName = "name", nullable = false)
    private Country country;
    
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<City>cities;
    

}

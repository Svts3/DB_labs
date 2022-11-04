package ua.lviv.iot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "watch_location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WatchLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double latitude;
    private Double longitude;
    
    @ManyToOne
    @JoinColumn(name = "watch_serial_number", referencedColumnName = "serialNumber", nullable = false)
    private Watch watch;
}

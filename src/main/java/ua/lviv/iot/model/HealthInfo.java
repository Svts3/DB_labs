package ua.lviv.iot.model;

import javax.persistence.Column;
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
@Table(name = "health_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HealthInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "heartbeat_rate")
    private Integer heartbeatRate;
    @ManyToOne
    @JoinColumn(name = "watch_serial_number", referencedColumnName = "serialNumber",
    nullable = false)
    private Watch watch;

}

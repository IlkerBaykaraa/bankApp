package dist.hw.bank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@Table(name="credits")
@Data
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_id",nullable = false)
    private long customerId;

    @Column(name = "creditAmount",nullable = false)
    private long credit_amount;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "date",nullable = false)
    private LocalDateTime date;

}

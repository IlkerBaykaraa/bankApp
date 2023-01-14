package dist.hw.bank.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "id_number",nullable = false)
    private String idNumber;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "password",nullable = false)
    private String password;
}

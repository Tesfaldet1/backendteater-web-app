package se.scg.backendteaterwebapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor

public class Staff extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;



    @OneToMany(cascade = CascadeType.ALL)
    private List<Calendar> calendarList;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH}
    )
    private List<ContactInformation> contactInformations;

    public Staff(String firstName, String lastName, LocalDate birthday, List<Calendar> calendarList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;

        this.calendarList = calendarList;
    }
}

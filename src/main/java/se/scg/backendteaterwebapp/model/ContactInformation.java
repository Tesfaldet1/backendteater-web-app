package se.scg.backendteaterwebapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phone;
    private String address;
    private String city;
    private String zipcode;



    public ContactInformation(String phone, String address, String city) {
        this.phone = phone;
        this.address = address;
        this.city = city;
    }
}

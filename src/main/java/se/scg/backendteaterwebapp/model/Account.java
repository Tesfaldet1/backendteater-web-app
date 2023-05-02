package se.scg.backendteaterwebapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    @Id
  //  @Column(nullable = false, unique = true)
    private String username;
   // @Column(nullable = false)
    private String password;




    public Account(String username) {
        this.username = username;
    }

    public Account(String username, Role role) {
        this.username = username;

    }
}

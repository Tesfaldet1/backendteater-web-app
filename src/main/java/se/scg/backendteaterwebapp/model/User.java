package se.scg.backendteaterwebapp.model;
import jakarta.persistence.*;
import lombok.*;
import se.scg.backendteaterwebapp.Exception.DataDuplicateException;
import se.scg.backendteaterwebapp.Exception.DataNotFoundException;


import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<ContactInformation> contactInformationList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne(cascade = CascadeType.ALL)
    private Staff staff;
    public User(Account account, Set<Role> roles, List<ContactInformation> contactInformationList) {
        this.account = account;

        this.contactInformationList = contactInformationList;
    }

    public User(Account account, Set<Role> roles) {
        this.account = account;

    }




}








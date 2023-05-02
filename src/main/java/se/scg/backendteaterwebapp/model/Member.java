package se.scg.backendteaterwebapp.model;

import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jakarta.persistence.*;

import lombok.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Member extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Column(unique = true, nullable = false, length = 30)
    private String email;
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH}
    )
    private List<ContactInformation> contactInformations;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Event event;

    public Member(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Member(String firstName, String lastName, LocalDate birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public List<String> getEmailList() {
        List<String> emailList = new ArrayList<>();
        emailList.add(email);
        emailList.add("tweldemicheal@gmail.com");
        emailList.add("ogeariyo@gmail.com");
        emailList.add("tahsinkhan86@gmail.com");
        emailList.add("lubnafarheensweden@gmail.com");
        emailList.add("Emil_skull@hotmail.com");
        return emailList;
    }

    public static void sendEmail(Member member, String subject, String body, String emailId, String password) {
        // set SMTP properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // create session and authenticate
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(emailId, password);
            }
        });

        try {
            // create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailId));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(member.email));
            message.setSubject(subject);
            message.setText(body);

            // send message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
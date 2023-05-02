package se.scg.backendteaterwebapp.model.Dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import se.scg.backendteaterwebapp.model.Event;

import java.util.List;
@Getter
@Setter
public class CalendarDto {
    private Integer id;
    private String title;
    private List<Event> events;

    private String calendarMode;
}

package se.scg.backendteaterwebapp.model.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.scg.backendteaterwebapp.model.Calendar;
import se.scg.backendteaterwebapp.model.Member;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private LocalDateTime startTime;


    private LocalDateTime endTime;
    private List<Calendar> calendars;
    private List<Member> attendees;


}

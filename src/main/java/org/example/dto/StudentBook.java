package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enum.Status;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentBook {
    private Integer id ;
    private  Integer Student_id;
    private Integer book_id;
    private LocalDateTime createdDate;
    private LocalDateTime returnedDate;
    private String duration;
    private Status status;

}

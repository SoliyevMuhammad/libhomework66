package org.example.dto;

import org.example.enums.GeneralStatus;

import java.time.LocalDateTime;

public class StudentsBook {
    private Integer id;
    private LocalDateTime createdDate;
    private GeneralStatus status;
    private LocalDateTime returnedDate;
    private Integer duration;
    public StudentsBook() {
    }

    public StudentsBook(Integer id, LocalDateTime createdDate, GeneralStatus status, LocalDateTime returnedDate, Integer duration) {
        this.id = id;
        this.createdDate = createdDate;
        this.status = status;
        this.returnedDate = returnedDate;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public GeneralStatus getStatus() {
        return status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
    }

    public LocalDateTime getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDateTime returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "StudentsBook{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", status=" + status +
                ", returnedDate=" + returnedDate +
                ", duration=" + duration +
                '}';
    }
}

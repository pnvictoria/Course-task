package org.example.model;

import java.time.LocalDateTime;

public class ReportLine {
    private String racer;
    private String team;
    private LocalDateTime duration;

    public ReportLine(String racer, String team) {
        this.racer = racer;
        this.team = team;
    }

    public ReportLine(String racer, String team, LocalDateTime duration) {
        this.racer = racer;
        this.team = team;
        this.duration = duration;
    }

    public String getRacer() {
        return racer;
    }

    public void setRacer(String racer) {
        this.racer = racer;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public LocalDateTime getDuration() {
        return duration;
    }

    public void setDuration(LocalDateTime duration) {
        this.duration = duration;
    }
}

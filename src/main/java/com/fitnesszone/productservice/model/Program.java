package com.fitnesszone.productservice.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;

public class Program {
    @Id
    private String programCode;
    private String programName;
    private String description;
    private int durationInMonths;
    private int price;
    private boolean active;

    public Program(String programCode, String programName, String description, int durationInMonths, int price, boolean active) {
        this.programCode = programCode;
        this.programName = programName;
        this.description = description;
        this.durationInMonths = durationInMonths;
        this.price = price;
        this.active = active;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

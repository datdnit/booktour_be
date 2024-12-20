package com.hau.tour_service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TourUpdateRequest {

    @NotNull(message = "Enter your tour name")
    @Size(min = 2, message = "Tour name requires at least 2 characters")
    private String name;

    @NotNull(message = "Enter your tour thumbnail")
    private String thumbnail;

    @NotNull(message = "Enter your tour thumbnail")
    private String description;

    @NotNull(message = "Enter your tour price")
    private Integer price;
    private String duration;
    private String airline;
    private String startingGate;

    @NotNull(message = "Select your tour status")
    @NotEmpty(message = "Select your tour status")
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getStartingGate() {
        return startingGate;
    }

    public void setStartingGate(String startingGate) {
        this.startingGate = startingGate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

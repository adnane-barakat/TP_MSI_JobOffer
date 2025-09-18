package com.JobOffer.JobOfferService.dto;

import com.JobOffer.JobOfferService.entities.Company;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record JobOfferDto( UUID uid,
         String title,
         LocalDate startDate,
         LocalDate endDate,
         LocalTime startDayTime,
         LocalTime endDayTime,
         UUID student ,
         int expirationDays ,
         Company owner,
         Instant creationTimestamps) {


}

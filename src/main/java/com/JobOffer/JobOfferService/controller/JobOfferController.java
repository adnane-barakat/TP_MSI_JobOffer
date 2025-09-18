package com.JobOffer.JobOfferService.controller;

import com.JobOffer.JobOfferService.dto.JobOfferDto;
import com.JobOffer.JobOfferService.dto.wrapper.PaginatedResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.JobOffer.JobOfferService.Service.JobOfferService;

import java.util.UUID;

@Controller
public class JobOfferController {
    private final JobOfferService jobservice;
    public JobOfferController(JobOfferService jobservice){
        this.jobservice=jobservice;
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<JobOfferDto> getOffer(@PathVariable UUID id) {
        return ResponseEntity.ok(jobservice.findOne(id));
    }


    @GetMapping("/publish")
    public JobOfferDto publishOffer(@RequestBody JobOfferDto newJob , String requestor){
            return jobservice.publishNewJobOffer( newJob , requestor);
    }

    @GetMapping("/searchOffers")
    public PaginatedResponseDto<JobOfferDto> search(@RequestBody String title , int page , int size){
        return jobservice.search(title , page , size);
    }

    @GetMapping()

}

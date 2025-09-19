package com.JobOffer.JobOfferService.controller;

import com.JobOffer.JobOfferService.dto.JobOfferDto;
import com.JobOffer.JobOfferService.dto.wrapper.PaginatedResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.JobOffer.JobOfferService.Service.JobOfferService;

import java.util.UUID;

@RestController
@RequestMapping("/service/JobOffer")
public class JobOfferController {

    @Autowired
    private JobOfferService jobservice;

    @GetMapping("/{id}")
    public ResponseEntity<JobOfferDto> getOffer(@PathVariable UUID id) {
        return ResponseEntity.ok(jobservice.findOne(id));
    }


    @PostMapping
    public JobOfferDto publishOffer(@RequestBody JobOfferDto newJob , String requestor){
            return jobservice.publishNewJobOffer( newJob , requestor);
    }

    @GetMapping
    public PaginatedResponseDto<JobOfferDto> search(@RequestBody String title , int page , int size){
        return jobservice.search(title , page , size);
    }

    @PutMapping
    public ResponseEntity<JobOfferDto> updateOffer(@RequestBody JobOfferDto updatedJob , String requestor){
        return ResponseEntity.ok(jobservice.updateJobOffer(updatedJob,requestor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable UUID id, String requestor){
        jobservice.cancelJobOffer(id,requestor);
        return ResponseEntity.ok().build();
    }

}

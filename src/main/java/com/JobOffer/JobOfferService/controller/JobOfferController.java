package com.JobOffer.JobOfferService.controller;

import com.JobOffer.JobOfferService.dto.JobOfferDto;
import com.JobOffer.JobOfferService.dto.wrapper.PaginatedResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<JobOfferDto> publishOffer(@RequestBody JobOfferDto newJob , String requestor){
        JobOfferDto resultJobOffer = jobservice.publishNewJobOffer(newJob, requestor);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultJobOffer);
    }

    @GetMapping
    public PaginatedResponseDto<JobOfferDto> search(
            @RequestParam(required = false, name = "title", defaultValue = "*") String title,
            @RequestParam(required = false, name = "page", defaultValue = "0") int page,
            @RequestParam(required = false, name = "size", defaultValue = "10") int size){
        title = title.replace("*", "%");
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

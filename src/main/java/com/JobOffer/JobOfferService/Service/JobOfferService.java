package com.JobOffer.JobOfferService.Service;

import com.JobOffer.JobOfferService.dto.JobOfferDto;
import com.JobOffer.JobOfferService.dto.wrapper.PaginatedResponseDto;

import java.util.UUID;

public interface JobOfferService {

    JobOfferDto findOne(UUID id);
    PaginatedResponseDto<JobOfferDto> search (String title, int page, int size);

    JobOfferDto publishNewJobOffer(JobOfferDto newJobOffer, String requestor);
    JobOfferDto updateJobOffer(JobOfferDto jobOffer, String requestor);
    void cancelJobOffer(UUID jobOfferId, String requestor);



}


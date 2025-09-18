package com.JobOffer.JobOfferService.Service.implementation;

import com.JobOffer.JobOfferService.Repository.CompanyRepository;
import com.JobOffer.JobOfferService.Repository.JobOfferRepository;
import com.JobOffer.JobOfferService.Service.JobOfferService;
import com.JobOffer.JobOfferService.dto.JobOfferDto;
import com.JobOffer.JobOfferService.dto.wrapper.PaginatedResponseDto;
import com.JobOffer.JobOfferService.entities.JobOffer;
import com.JobOffer.JobOfferService.mapper.CompanyMapper;
import com.JobOffer.JobOfferService.mapper.JobOfferMapper;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class JobOfferServiceImpl implements JobOfferService {

    private static final Logger logger = LoggerFactory.getLogger(JobOfferServiceImpl.class);
    private final JobOfferMapper mapper= JobOfferMapper.INSTANCE;
    private final CompanyMapper companyMapper = CompanyMapper.INSTANCE;
    private final JobOfferRepository jobOfferRepository;
    private final CompanyRepository companyRepository;

    public JobOfferServiceImpl(JobOfferRepository jobOfferRepository,CompanyRepository companyRepository){
        this.jobOfferRepository = jobOfferRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public JobOfferDto findOne(UUID id){
        JobOffer result = jobOfferRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return mapper.toDto(result);
    }

    @Override
    public PaginatedResponseDto<JobOfferDto> search(String title , int page , int size) {
        Page<JobOffer> result = jobOfferRepository.searchAllByTitleLikeIgnoreCase(title , PageRequest.of(page,size));
        return mapper.toPaginatedDto(result);
    }

    @Override
    public JobOfferDto publishNewJobOffer(JobOfferDto newJobOffer, String requestor){
        JobOffer newJobOfferEntity = mapper.toEntity(newJobOffer);
        JobOffer savedJobOffer = jobOfferRepository.save(newJobOfferEntity);
        return mapper.toDto(savedJobOffer);

    }

    @Override
    public JobOfferDto updateJobOffer(JobOfferDto jobOfferDto , String requestor) {
        JobOffer existingJobOffer = jobOfferRepository.findById(jobOfferDto.uid()).orElseThrow(EntityNotFoundException::new);
        existingJobOffer.setTitle(jobOfferDto.title());
        existingJobOffer.setEndDate(jobOfferDto.endDate());
        existingJobOffer.setStartDate(jobOfferDto.startDate());

        return mapper.toDto(existingJobOffer);
    }



    @Override
    public void cancelJobOffer(UUID id , String requestor){
        jobOfferRepository.deleteById(id);
    }

}

package com.JobOffer.JobOfferService.mapper;

import com.JobOffer.JobOfferService.dto.wrapper.PaginatedResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.JobOffer.JobOfferService.dto.JobOfferDto;
import com.JobOffer.JobOfferService.entities.JobOffer;
import org.springframework.data.domain.Page;
import java.util.List;

@Mapper
public interface JobOfferMapper {
    JobOfferMapper INSTANCE = Mappers.getMapper(JobOfferMapper.class);

    JobOfferDto toDto(JobOffer entity);
    JobOffer toEntity(JobOfferDto dto);

    default PaginatedResponseDto<JobOfferDto> toPaginatedDto(Page<JobOffer> page){
        List<JobOfferDto> content=  page.getContent().stream().map(this::toDto).toList();
        return new PaginatedResponseDto<>(
                content,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast()
        );

    }

}

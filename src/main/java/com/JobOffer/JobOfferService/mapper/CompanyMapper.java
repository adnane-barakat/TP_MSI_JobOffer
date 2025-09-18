package com.JobOffer.JobOfferService.mapper;
import org.mapstruct.factory.Mappers;
import com.JobOffer.JobOfferService.dto.CompanyDto;
import com.JobOffer.JobOfferService.entities.Company;

public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDto toDto(Company entity);
    Company toEntity(CompanyDto dto);
}

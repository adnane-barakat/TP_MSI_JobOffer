package com.JobOffer.JobOfferService.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.JobOffer.JobOfferService.dto.CompanyDto;
import com.JobOffer.JobOfferService.entities.Company;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDto toDto(Company company);
    Company toEntity(CompanyDto dto);
}

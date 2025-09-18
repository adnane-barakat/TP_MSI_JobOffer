package com.JobOffer.JobOfferService.Repository;
import com.JobOffer.JobOfferService.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String> {
}

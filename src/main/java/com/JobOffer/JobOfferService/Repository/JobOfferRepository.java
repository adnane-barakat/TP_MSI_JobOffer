package com.JobOffer.JobOfferService.Repository;

import com.JobOffer.JobOfferService.entities.JobOffer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, UUID> {

    List<JobOffer> findAllByTitleLikeOrderByCreationTimestampDesc(String title);

    Page<JobOffer> searchAllByTitleLikeIgnoreCase(String titleRegex, Pageable pageable);




}

package com.msstudent.ie.carbonfree.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Long> {
    boolean existsByReferenceCode(String referenceCode);

    Track findByReferenceCode(String referenceCode);
}

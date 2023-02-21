package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IFacilityRepository extends JpaRepository<Facility, Long> {
    @Query(value = "select * from facility where name like concat('%',:name,'%')" +
            "and facility_type_id = :facilityTypeId and flag=true", nativeQuery = true)
    Page<Facility> findAllByNameContainingAndFacilityType_Id(@Param("name") String name,
                                                             @Param("facilityTypeId") Long facilityTypeId,
                                                             Pageable pageable);
    @Query(value = "select * from facility where name like concat('%',:name,'%')" +
            "and flag=true", nativeQuery = true)
    Page<Facility> findAllByNameContaining(@Param("name") String name, Pageable pageable);
    Optional<Facility> findByName(String name);
}

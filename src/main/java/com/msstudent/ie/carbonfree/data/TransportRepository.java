package com.msstudent.ie.carbonfree.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport,Long> {

    @Query("SELECT DISTINCT transportBrand from Transport")
    List<String> getTransportBrand();

    @Query("SELECT DISTINCT transportModel from Transport where transportBrand=:newBrand")
    List<String> getTransportModelByBrand(String newBrand);

    @Query("SELECT DISTINCT transportSize from Transport where transportBrand=:newBrand and transportModel =:newModel")
    List<String> getTransportSizeByModelAndBrand(@Param("newBrand") String newBrand, @Param("newModel") String newModel);

    @Query("SELECT t from Transport t where t.transportBrand=:newBrand and t.transportModel=:newMode and t.transportSize=:newSize")
    Transport findTransportByThree(String newBrand, String newMode, String newSize);

}

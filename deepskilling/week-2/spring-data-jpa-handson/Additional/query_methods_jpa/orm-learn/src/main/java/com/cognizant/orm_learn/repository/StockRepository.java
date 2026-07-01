package com.cognizant.orm_learn.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByCodeAndDateBetween(String code, LocalDate startDate, LocalDate endDate);

    @Query("SELECT s FROM Stock s WHERE s.code = :code AND (s.open > :threshold OR s.close > :threshold)")
    List<Stock> findByCodeAndPriceAbove(@Param("code") String code, @Param("threshold") BigDecimal threshold);

    List<Stock> findTop3ByOrderByVolumeDesc();

    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);

}
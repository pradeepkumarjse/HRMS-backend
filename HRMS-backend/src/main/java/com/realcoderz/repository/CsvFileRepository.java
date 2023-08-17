package com.realcoderz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realcoderz.model.CsvFile;

public interface CsvFileRepository extends JpaRepository<CsvFile, Long> {

}

package com.realcoderz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realcoder.entity.Employee;


@Repository
public interface employeerepository extends JpaRepository<Employee, Long> {

}

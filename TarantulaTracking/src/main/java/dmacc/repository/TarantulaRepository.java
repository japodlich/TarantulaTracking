package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Tarantula;



public interface TarantulaRepository extends JpaRepository <Tarantula, Long> {

}
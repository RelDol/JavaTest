package vn.anhnhb.javatestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.anhnhb.javatestapi.model.Work;

/**
 * work repository
 * @author AnhNHB
 * @version 1.0 2020/04/03
 * 
 */
public interface WorkRepository extends JpaRepository<Work, Integer>{

}

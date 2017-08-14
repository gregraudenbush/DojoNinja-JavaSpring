package com.gregory.DojoNinja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gregory.DojoNinja.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository <Dojo, Long>{

}

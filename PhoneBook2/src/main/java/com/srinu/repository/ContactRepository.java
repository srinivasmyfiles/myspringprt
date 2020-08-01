package com.srinu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srinu.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity,Serializable>{

}

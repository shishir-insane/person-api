package com.sk.wagawin.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sk.wagawin.person.entity.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

}

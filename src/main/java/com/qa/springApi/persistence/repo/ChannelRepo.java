package com.qa.springApi.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springApi.persistence.domain.Channel;

@Repository
public interface ChannelRepo extends JpaRepository<Channel,Long> {

}

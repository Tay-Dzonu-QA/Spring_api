package com.qa.springApi.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springApi.persistence.domain.TvShow;

@Repository
public interface TvShowRepo extends JpaRepository<TvShow,Long> {

}

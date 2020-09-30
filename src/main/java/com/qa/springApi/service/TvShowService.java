package com.qa.springApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springApi.dto.TvShowDTO;
import com.qa.springApi.exceptions.ChannelNotFoundException;
import com.qa.springApi.exceptions.TvShowNotFoundException;
import com.qa.springApi.persistence.domain.TvShow;
import com.qa.springApi.persistence.repo.TvShowRepo;
import com.qa.springApi.utils.SAPIBeanUtils;

@Service
public class TvShowService {

	private TvShowRepo repo;
	private ModelMapper mapper;

	@Autowired
	public TvShowService(TvShowRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private TvShowDTO mapToDTO(TvShow tvShow) {
		return this.mapper.map(tvShow, TvShowDTO.class);
	}

//	private TvShow mapFromDTO(TvShowDTO tvShowDTO) {
//		return this.mapper.map(tvShowDTO, TvShow.class);
//	}

	public TvShowDTO create(TvShow tvShow) {
//		TvShow toSave = this.mapFromDTO(tvShowDTO);
		TvShow saved = this.repo.save(tvShow);
		return mapToDTO(saved);
	}

	public List<TvShowDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public TvShowDTO read(Long id) {
		TvShow found = this.repo.findById(id).orElseThrow(TvShowNotFoundException::new);
		return this.mapToDTO(found);
	}

	public TvShowDTO update(TvShowDTO tvShowDTO,Long id) {
		TvShow toUpdate = this.repo.findById(id).orElseThrow(ChannelNotFoundException::new);
		SAPIBeanUtils.mergeNotNull(tvShowDTO,toUpdate);
		return this.mapToDTO(this.repo.save(toUpdate));
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}

package com.qa.springApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springApi.dto.ChannelDTO;
import com.qa.springApi.exceptions.ChannelNotFoundException;
import com.qa.springApi.persistence.domain.Channel;
import com.qa.springApi.persistence.repo.ChannelRepo;
import com.qa.springApi.utils.SAPIBeanUtils;

@Service
public class ChannelService {

	private ChannelRepo repo;
	private ModelMapper mapper;

	//@Autowired
	public ChannelService(ChannelRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private ChannelDTO mapToDTO(Channel channel) {
		return this.mapper.map(channel, ChannelDTO.class);
	}

	private Channel mapFromDTO(ChannelDTO channelDTO) {
		return this.mapper.map(channelDTO, Channel.class);
	}

	public ChannelDTO create(ChannelDTO channelDTO) {
		Channel toSave = this.mapFromDTO(channelDTO);
		Channel saved = this.repo.save(toSave);
		return mapToDTO(saved);
	}

	public List<ChannelDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public ChannelDTO read(Long id) {
		Channel found = this.repo.findById(id).orElseThrow(ChannelNotFoundException::new);
		return this.mapToDTO(found);
	}

	public ChannelDTO update(ChannelDTO channelDTO,Long id) {
		Channel toUpdate = this.repo.findById(id).orElseThrow(ChannelNotFoundException::new);
		SAPIBeanUtils.mergeObject(channelDTO, toUpdate);
		return this.mapToDTO(toUpdate);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}

package com.qa.springApi.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tv_channel_name", unique = true)
	@NotNull
	@Size(min = 1, max = 60)
	private String name;

	@Column(name = "channel_number")
	private Integer number;

	
	@OneToMany(mappedBy="channel", cascade=CascadeType.ALL)
//	@OneToMany(mappedBy = "channel")
	private List<TvShow> tvShows;


	public Channel( @NotNull @Size(min = 1, max = 60) String name, int number, List<TvShow> tvShows) {
		super();
		//this.id = id;
		this.name = name;
		this.number = number;
		this.tvShows = tvShows;
	}
	
//	public Channel() {}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getNumber() {
//		return number;
//	}
//
//	public void setNumber(int number) {
//		this.number = number;
//	}
//
//	public List<TvShow> getTvShows() {
//		return tvShows;
//	}
//
//	public void setTvShows(List<TvShow> tvShows) {
//		this.tvShows = tvShows;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + number;
//		result = prime * result + ((tvShows == null) ? 0 : tvShows.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Channel other = (Channel) obj;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (number != other.number)
//			return false;
//		if (tvShows == null) {
//			if (other.tvShows != null)
//				return false;
//		} else if (!tvShows.equals(other.tvShows))
//			return false;
//		return true;
//	}
//	
	

}

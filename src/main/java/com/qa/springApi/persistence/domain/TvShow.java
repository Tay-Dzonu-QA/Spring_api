package com.qa.springApi.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class TvShow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tv_show_name", unique = true)
	@NotNull
	@Size(min = 1, max = 60)
	private String name;

	@Column(name = "run_time_mins")
	private Integer runTimeMins;

	@Column(name = "genre")
	@NotNull
	@Size(min = 1, max = 60)
	private String genre;
	
	@ManyToOne//(targetEntity = Channel.class)
	private Channel channel;

	public TvShow(@NotNull @Size(min = 1, max = 60) String name, int runTimeMins,
			@NotNull @Size(min = 1, max = 60) String genre) {
		super();
		this.name = name;
		this.runTimeMins = runTimeMins;
		this.genre = genre;
	}
//	public TvShow() {}
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getRunTimeMins() {
//		return runTimeMins;
//	}
//	public void setRunTimeMins(int runTimeMins) {
//		this.runTimeMins = runTimeMins;
//	}
//	public String getGenre() {
//		return genre;
//	}
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
//	public Channel getChannel() {
//		return channel;
//	}
//	public void setChannel(Channel channel) {
//		this.channel = channel;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
//		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + runTimeMins;
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TvShow other = (TvShow) obj;
//		if (channel == null) {
//			if (other.channel != null)
//				return false;
//		} else if (!channel.equals(other.channel))
//			return false;
//		if (genre == null) {
//			if (other.genre != null)
//				return false;
//		} else if (!genre.equals(other.genre))
//			return false;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (runTimeMins != other.runTimeMins)
//			return false;
//		return true;
//	}
	
}

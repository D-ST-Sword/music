package music.pojo;

import java.util.List;

public class Song extends BaseEntity {
	
	private String songId;
	private String name;
	private String classId;

	private String singerId;
	private String songSrc;
	private String songImg;
	
	public String getSongId() {
		return songId;
	}
	public void setSongId(String songId) {
		this.songId = songId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getSingerId() {
		return singerId;
	}
	public void setSingerId(String singerId) {
		this.singerId = singerId;
	}
	public String getSongSrc() {
		return songSrc;
	}
	public void setSongSrc(String songSrc) {
		this.songSrc = songSrc;
	}
	public String getSongImg() {
		return songImg;
	}
	public void setSongImg(String songImg) {
		this.songImg = songImg;
	}
	
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", name=" + name + ", classId=" + classId + ", singerId=" + singerId
				+ ", songSrc=" + songSrc + ", songImg=" + songImg + "]";
	}
	
	
}

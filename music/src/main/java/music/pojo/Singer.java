package music.pojo;

public class Singer extends BaseEntity {

	private String singerId;
	private String name;
	private String singerImg;
	
	public String getSingerId() {
		return singerId;
	}
	public void setSingerId(String singerId) {
		this.singerId = singerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSingerImg() {
		return singerImg;
	}
	public void setSingerImg(String singerImg) {
		this.singerImg = singerImg;
	}
	
	@Override
	public String toString() {
		return "Singer [singerId=" + singerId + ", name=" + name + ", singerImg=" + singerImg + "]";
	}
	
	
}

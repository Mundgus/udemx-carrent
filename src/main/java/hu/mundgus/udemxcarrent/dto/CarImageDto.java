package hu.mundgus.udemxcarrent.dto;

public class CarImageDto {
    private Integer id;
    private Integer rank;
    private String url;

    public CarImageDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

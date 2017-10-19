package models;



import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseModel<Restaurant> {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double mark;
    @Column
    private Long votes;
    @Column(name = "price_range")
    private Long priceRange;
    @Column(name = "image_file_name")
    private String imageFileName;
    @Column(name = "cover_file_name")
    private String coverFileName;
    @Column
    private String category;

    //+LOCATION


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public Long getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Long priceRange) {
        this.priceRange = priceRange;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public void update(Restaurant data) {
        if (data.getName() != null) {
            setName(data.getName());
        }
        if (data.getDescription() != null) {
            setDescription(data.getDescription());
        }
        if (data.getMark() != null) {
            setMark(data.getMark());
        }
        if (data.getVotes() != null) {
            setVotes(data.getVotes());
        }
        if (data.getPriceRange() != null) {
            setPriceRange(data.getPriceRange());
        }
        if (data.getImageFileName() != null) {
            setImageFileName(data.getImageFileName());
        }
        if (data.getCoverFileName() != null) {
            setCoverFileName(data.getCoverFileName());
        }
        if (data.getCategory() != null) {
            setCategory(data.getCategory());
        }

    }

}

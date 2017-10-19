package models;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseModel<M> {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public abstract void update(M model);

}

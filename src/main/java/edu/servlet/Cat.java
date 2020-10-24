package edu.servlet;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.util.Date;

//@Entity
//@Table(name = "cat", schema = "public")
public class Cat {

//    @Column(name = "cat_id")
//    @Id
    private Long id;

//    @Column(name = "name", nullable = false, length = 255)
    private String name;

//    @Column(name = "birth", nullable = false)
    private Date birth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (!id.equals(cat.id)) return false;
        if (!name.equals(cat.name)) return false;
        return birth.equals(cat.birth);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + birth.hashCode();
        return result;
    }
}

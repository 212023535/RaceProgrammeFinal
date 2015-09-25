package RaceProgramme.domain;

import sun.security.provider.certpath.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * Created by student on 2015/09/06.
 */

@Entity
public class Classes implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String className;
    private String classCode;
    @Embedded
    private List<Drivers> drivers;

    private Classes(){}

    public Classes(Builder builder)
    {
        this.id = builder.id;
        this.classCode = builder.classCode;
        this.className = builder.className;
        this.drivers = builder.drivers;
    }

    public Long getId() {
        return id;
    }

    public String getClassCode() {
        return classCode;
    }

    public String getClassName() {
        return className;
    }

    public List<Drivers> getDrivers() {
        return drivers;
    }

    public static class Builder
    {
        private Long id;
        private String className;
        private String classCode;
        private List<Drivers> drivers;

        public Builder(String classCode){this.classCode = classCode;}

        public Builder className(String className)
        {
            this.className = className;
            return this;
        }

        public Builder drivers(List<Drivers> drivers)
        {
            this.drivers = drivers;
            return this;
        }

        public Builder classCode(String classCode)
        {
            this.classCode = classCode;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Classes classes)
        {
            this.drivers = classes.drivers;
            this.className = classes.className;
            this.classCode = classes.classCode;
            this.id = classes.id;

            return this;
        }

        public Classes build() {return new Classes(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classes)) return false;

        Classes classes = (Classes) o;

        if (classCode != null ? !classCode.equals(classes.classCode) : classes.classCode != null) return false;
        if (id != null ? !id.equals(classes.id) : classes.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (classCode != null ? classCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Classes{" +
                ", className='" + className + '\'' +
                ", classCode='" + classCode + '\'' +
                ", Drivers=" + drivers +
                '}';
    }
}

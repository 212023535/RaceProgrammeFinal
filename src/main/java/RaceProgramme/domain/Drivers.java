package RaceProgramme.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/09/06.
 */
@Entity
public class Drivers implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String vehicle;

    private Drivers(){}

    public Drivers(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.vehicle = builder.vehicle;
    }

    public String getName() {
        return name;
    }

    public String getVehicle() {
        return vehicle;
    }


    public Long getId() {
        return id;
    }

    public static class Builder
    {
        private Long id;
        private String name;
        private String vehicle;

        public Builder(String name){this.name = name;}

        public Builder id(Long id){this.id = id; return this;}

        public Builder vehicle(String vehicle){this.vehicle = vehicle; return this;}

        public Builder driverName(String name){this.name = name; return this;}

        public Builder copy(Drivers drivers)
        {
            this.id = drivers.id;
            this.vehicle = drivers.vehicle;
            this.name = drivers.name;

            return this;
        }

        public Drivers build(){return new Drivers(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drivers)) return false;

        Drivers drivers = (Drivers) o;

        if (id != null ? !id.equals(drivers.id) : drivers.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                ", name='" + name + '\'' +
                ", vehicle='" + vehicle + '\'' +
                '}';
    }
}

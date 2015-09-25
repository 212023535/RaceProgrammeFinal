package RaceProgramme.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/09/06.
 */
@Embeddable
public class Grid implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pos;

    @Embedded
    private Drivers driverName;
    @Embedded
    private Drivers vehicle;
    @Embedded
    private Classes className;

    private Grid(){}

    private Grid(Builder builder)
    {
        this.id = builder.id;
        this.pos = builder.pos;
        this.driverName = builder.driverName;
        this.vehicle = builder.vehicle;
        this.className = builder.className;
    }

    public Long getId() {
        return id;
    }

    public String getPos() {
        return pos;
    }

    public Drivers getDriverName() {
        return driverName;
    }

    public Drivers getVehicle() {
        return vehicle;
    }

    public Classes getClassName() {
        return className;
    }

    public static class Builder
    {
        private Long id;
        private String pos;
        private Drivers driverName;
        private Drivers vehicle;
        private Classes className;

        public Builder(Long id){this.id = id;}

        public Builder pos(String pos){this.pos = pos; return this;}

        public Builder driverName(Drivers driverName){this.driverName = driverName; return this;}

        public Builder vehicle(Drivers vehicle){this.vehicle = vehicle; return this;}

        public Builder className(Classes className){this.className = className; return this;}

        public Builder copy(Grid grid)
        {
            this.id = grid.id;
            this.pos = grid.pos;
            this.driverName = grid.driverName;
            this.vehicle = grid.vehicle;
            this.className = grid.className;

            return this;
        }

        public Grid build(){return new Grid(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid = (Grid) o;

        if (!id.equals(grid.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Grid{" +
                ", pos='" + pos + '\'' +
                ", driverName=" + driverName +
                ", vehicle=" + vehicle +
                '}';
    }
}


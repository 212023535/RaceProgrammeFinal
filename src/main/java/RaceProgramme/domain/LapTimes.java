package RaceProgramme.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/09/06.
 */
@Embeddable
public class LapTimes implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lapTime;

    @Embedded
    private Drivers driverName;
    @Embedded
    private Drivers vehicle;
    @Embedded
    private Classes className;

    private LapTimes(){}

    private LapTimes(Builder builder)
    {
        this.id = builder.id;
        this.lapTime = builder.lapTime;
        this.driverName = builder.driverName;
        this.vehicle = builder.vehicle;
        this.className = builder.className;
    }

    public Long getId() {
        return id;
    }

    public String getLapTime() {
        return lapTime;
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
        private String lapTime;
        private Drivers driverName;
        private Drivers vehicle;
        private Classes className;

        public Builder(Long id){this.id = id;}

        public Builder lapTime(String lapTime){this.lapTime = lapTime; return this;}

        public Builder driverName(Drivers driverName){this.driverName = driverName; return this;}

        public Builder vehicle(Drivers vehicle){this.vehicle = vehicle; return this;}

        public Builder className(Classes className){this.className = className; return this;}

        public Builder copy(LapTimes lapTimes)
        {
            this.id = lapTimes.id;
            this.lapTime = lapTimes.lapTime;
            this.driverName = lapTimes.driverName;
            this.vehicle = lapTimes.vehicle;
            this.className = lapTimes.className;

            return this;
        }

        public LapTimes build(){return new LapTimes(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LapTimes lapTimes = (LapTimes) o;

        if (id != null ? !id.equals(lapTimes.id) : lapTimes.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LapTimes{" +
                ", lapTime='" + lapTime + '\'' +
                ", driverName=" + driverName +
                ", vehicle=" + vehicle +
                ", className=" + className +
                '}';
    }
}

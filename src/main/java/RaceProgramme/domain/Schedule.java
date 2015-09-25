package RaceProgramme.domain;

import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/09/06.
 */
@Embeddable
public class Schedule implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String time;

    @Embedded
    private Classes className;

    private Schedule(){}

    private Schedule(Builder builder)
    {
        this.className = builder.className;
        this.time = builder.time;
        this.id = builder.id;
    }

    public Long getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public Classes getClassName() {
        return className;
    }

    public static class Builder
    {
        private Long id;
        private String time;
        private Classes className;

        public Builder(Long id){this.id = id;}

        public Builder time(String time){this.time = time; return this;}

        public Builder className(Classes className){this.className = className; return this;}

        public Builder copy(Schedule schedule)
        {
            this.className = schedule.className;
            this.time = schedule.time;
            this.id = schedule.id;

            return this;
        }

        public Schedule build(){return new Schedule(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;

        Schedule schedule = (Schedule) o;

        if (id != null ? !id.equals(schedule.id) : schedule.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "time='" + time + '\'' +
                ", className=" + className +
                '}';
    }
}

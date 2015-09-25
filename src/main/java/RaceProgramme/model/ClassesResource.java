package RaceProgramme.model;

import RaceProgramme.domain.Drivers;
import RaceProgramme.domain.Tracks;
import org.springframework.hateoas.ResourceSupport;


/**
 * Created by student on 2015/09/06.
 */
public class ClassesResource extends ResourceSupport
{
    private Long id;
    private String className;
    private String classCode;
    private Tracks trackName;
    private Tracks tracks;
    private Drivers drivers;

    private ClassesResource(){}

    private ClassesResource(Builder builder)
    {
        this.id = builder.id;
        this.classCode = builder.classCode;
        this.className = builder.className;
        this.trackName = builder.trackName;
        this.tracks = builder.tracks;
        this.drivers = builder.drivers;
    }

    public String getClassName() {
        return className;
    }



    public Drivers getDrivers() {
        return drivers;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public String getClassCode() {
        return classCode;
    }

    public static class Builder
    {
        private Long id;
        private String className;
        private String classCode;
        private Tracks trackName;
        private Tracks tracks;
        private Drivers drivers;

        public Builder(String classCode){this.classCode = classCode;}

        public Builder className(String className)
        {
            this.className = className;
            return this;
        }

        public Builder trackName(Tracks trackName)
        {
            this.trackName = trackName;
            return this;
        }

        public Builder tracks(Tracks tracks)
        {
            this.tracks = tracks;
            return this;
        }

        public Builder drivers(Drivers drivers)
        {
            this.drivers = drivers;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(ClassesResource classes)
        {
            this.trackName = classes.trackName;
            this.className = classes.className;
            this.classCode = classes.classCode;
            this.id = classes.id;
            this.drivers = classes.drivers;
            this.tracks = classes.tracks;

            return this;
        }

        public ClassesResource build() {return new ClassesResource(this);}
    }
}

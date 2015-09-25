package RaceProgramme.model;

import RaceProgramme.domain.Classes;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/06.
 */
public class DriverResource extends ResourceSupport
{
    private Long id;
    private String name;
    private String vehicle;

    private DriverResource(){}

    private DriverResource(Builder builder)
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


    public static class Builder
    {
        private Long id;
        private String name;
        private String vehicle;


        public Builder(String name){this.name = name;}

        public Builder id(Long id){this.id = id; return this;}

        public Builder vehicle(String vehicle){this.vehicle = vehicle; return this;}


        public Builder copy(DriverResource drivers)
        {
            this.id = drivers.id;
            this.vehicle = drivers.vehicle;
            this.name = drivers.name;

            return this;
        }

        public DriverResource build(){return new DriverResource(this);}
    }
}

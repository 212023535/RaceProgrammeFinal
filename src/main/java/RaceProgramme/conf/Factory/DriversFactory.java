package RaceProgramme.conf.Factory;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;

import java.util.List;

/**
 * Created by student on 2015/09/06.
 */
public class DriversFactory
{
    public static Drivers createDriver(String name,String vehicle)
    {
        Drivers drivers = new Drivers.Builder(name).vehicle(vehicle).build();

        return drivers;
    }
}

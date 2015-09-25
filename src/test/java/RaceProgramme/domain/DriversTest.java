package RaceProgramme.domain;

import RaceProgramme.conf.Factory.DriversFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/09/11.
 */
public class DriversTest
{
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void createDrivers() throws Exception
    {
       Drivers driver = DriversFactory.createDriver("Dawie","Porsche");
        Assert.assertEquals("Dawie",driver.getName());
    }

    @Test
    public void updateDrivers() throws Exception
    {
        Drivers driver = DriversFactory.createDriver("Dawie","Porsche");
        Drivers driver2 = new Drivers.Builder(driver.getName()).copy(driver).driverName("John").build();

        Assert.assertEquals("Dawie",driver.getName());
        Assert.assertEquals("John",driver2.getName());
    }
}

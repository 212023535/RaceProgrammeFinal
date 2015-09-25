package RaceProgramme.repository;

import RaceProgramme.conf.Factory.DriversFactory;
import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;
import RaceProgramme.repositories.DriversRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/11.
 */
public class DriversCRUDTest
{
    private Long id;

    @Autowired
    private DriversRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception
    {
        List<Classes> classList = new ArrayList();

        Classes classes = new Classes.Builder("S&GT").className("Sports & GT").build();
        classList.add(classes);

        Drivers drivers = DriversFactory.createDriver("Johan", "Porsche");

        repository.save(drivers);

        id = drivers.getId();

        Assert.assertNotNull(drivers.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Drivers drivers = repository.findOne(id);
        Assert.assertNotNull(drivers);
        Assert.assertEquals("Johan",drivers.getName());
        Assert.assertEquals("Porsche",drivers.getVehicle());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Drivers drivers = (Drivers)this.repository.findOne(this.id);
        Drivers newDriver = new Drivers.Builder(drivers.getName()).copy(drivers).driverName("Steve").build();
        this.repository.save(newDriver);
        Drivers updateT = (Drivers)this.repository.findOne(this.id);
        Assert.assertEquals("Steve",updateT.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Drivers drivers = repository.findOne(id);
        repository.delete(drivers);
        Drivers deleted = repository.findOne(id);
        Assert.assertNull(deleted);
    }


}

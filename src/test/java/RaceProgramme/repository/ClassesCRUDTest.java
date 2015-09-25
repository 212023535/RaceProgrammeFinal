package RaceProgramme.repository;

import RaceProgramme.conf.Factory.ClassesFactory;
import RaceProgramme.conf.Factory.DriversFactory;
import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;
import RaceProgramme.repositories.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/09/11.
 */
public class ClassesCRUDTest
{
    private Long id;

    @Autowired
    private ClassesRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception
    {
        List<Drivers> driversList = new ArrayList();
        Drivers driver = DriversFactory.createDriver("Dawie","Porsche");
        driversList.add(driver);

        Map<String,String> KillarneyClasses = new HashMap<String,String>();
        KillarneyClasses.put("ClassName", "Sports and GT");
        KillarneyClasses.put("ClassCode", "S&GT");
        KillarneyClasses.put("ClassName","V8 Masters");
        KillarneyClasses.put("ClassCode","V8M");

        Classes class1 = ClassesFactory.createClass(KillarneyClasses);

        repository.save(class1);

        id = class1.getId();

        Assert.assertNotNull(class1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Classes classes = repository.findOne(id);
        Assert.assertNotNull(classes);
        Assert.assertEquals("Sports & GT", classes.getClassName());
        Assert.assertEquals("Dawie Joubert ",classes.getDrivers());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Classes classes = (Classes)this.repository.findOne(this.id);
        Classes newClass = new Classes.Builder(classes.getClassName()).copy(classes).className("Masters V8 Series").build();
        this.repository.save(newClass);
        Classes updateC = (Classes)this.repository.findOne(this.id);
        Assert.assertEquals("Masters V8 Series",updateC.getClassName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Classes classes = repository.findOne(id);
        repository.delete(classes);
        Classes deleted = repository.findOne(id);
        Assert.assertNull(deleted);
    }

}

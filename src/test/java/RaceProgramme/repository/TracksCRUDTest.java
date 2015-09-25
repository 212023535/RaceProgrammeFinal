package RaceProgramme.repository;

import RaceProgramme.App;
import RaceProgramme.conf.Factory.ClassesFactory;
import RaceProgramme.conf.Factory.DriversFactory;
import RaceProgramme.conf.Factory.TracksFactory;
import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;
import RaceProgramme.domain.Tracks;
import RaceProgramme.repositories.TracksRepository;
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
@SpringApplicationConfiguration(classes= {App.class})
@WebAppConfiguration
public class TracksCRUDTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private TracksRepository repository;

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
        List<Drivers> driversList = new ArrayList();

        Map<String,String> SGTDrivers = new HashMap<String,String>();
        SGTDrivers.put("DriverName","Dawie Joubert");
        SGTDrivers.put("Vehicle","Lotus Exige R");
        SGTDrivers.put("DriverName","Steve Humble");
        SGTDrivers.put("Vehicle","Juno Sport");
        SGTDrivers.put("DriverName","Craig Jarvis");
        SGTDrivers.put("Vehicle","Porsche GT3 Cup");
        SGTDrivers.put("DriverName","Johann Engelbrecht");
        SGTDrivers.put("Vehicle","Porsche GT3 Cup");
        SGTDrivers.put("DriverName","Charl Arangies");
        SGTDrivers.put("Vehicle","Dodge Viper");



        Map<String,String> KillarneyClasses = new HashMap<String,String>();
        KillarneyClasses.put("ClassName", "Sports and GT");
        KillarneyClasses.put("ClassCode", "S&GT");
        KillarneyClasses.put("ClassName","Masters V8 Series");
        KillarneyClasses.put("ClassCode","V8M");
        KillarneyClasses.put("ClassName", "Fine Cars");
        KillarneyClasses.put("ClassCode", "FICA");
        KillarneyClasses.put("ClassName", "GTi Challenge");
        KillarneyClasses.put("ClassCode", "GTiC");
        KillarneyClasses.put("ClassName", "Supercars");
        KillarneyClasses.put("ClassCode", "SupC");
        KillarneyClasses.put("ClassName", "C;assic Cars");
        KillarneyClasses.put("ClassCode", "CLCA");
        KillarneyClasses.put("ClassName", "Clubmans");
        KillarneyClasses.put("ClassCode", "CLUB");
        KillarneyClasses.put("ClassName", "Formula Libre");
        KillarneyClasses.put("ClassCode", "FOLI");
        KillarneyClasses.put("ClassName", "Superbikes");
        KillarneyClasses.put("ClassCode", "SBSA");
        KillarneyClasses.put("ClassName", "Superbikes Class B");
        KillarneyClasses.put("ClassCode", "SBSB");


        Classes SGTC = ClassesFactory.createClass(SGTDrivers);

        Tracks tracks = TracksFactory.createTrack("Killarney",classList);

        this.repository.save(tracks);
        id = tracks.getId();
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Tracks track1 = repository.findOne(id);
        Assert.assertNotNull(track1);
        Assert.assertEquals("Sports & GT",track1.getClassName());
        Assert.assertEquals("Killarney Motor Racing Complex",track1.getTrackName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Tracks track = (Tracks)this.repository.findOne(this.id);
        Tracks newTrack = new Tracks.Builder(track.getTrackName()).copy(track).trackName("Kyalami GP Circuit").build();
        this.repository.save(newTrack);
        Tracks updateT = (Tracks)this.repository.findOne(this.id);
        Assert.assertEquals("Kyalami GP Circuit",updateT.getTrackName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Tracks tracks = repository.findOne(id);
        repository.delete(tracks);
        Tracks deleted = repository.findOne(id);
        Assert.assertNull(deleted);
    }

}

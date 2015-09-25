package RaceProgramme.services;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TracksServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private TrackService service;
    private Long id;
    @Autowired
    private TracksRepository repository;
    private List<Tracks> trackList;

    @BeforeMethod
    public void setUp() throws  Exception
    {
        trackList = new ArrayList();
    }

    @Test
    public void create() throws Exception
    {
        /*//Killarney 2 Classes
        List<Classes> classList1 = new ArrayList<Classes>();

        List<Drivers> driversList1 = new ArrayList<Drivers>();
        List<Drivers> driversList2 = new ArrayList<Drivers>();

        Drivers d1 = DriversFactory.createDriver("Dawie Joubert","Lotus Exige R");
        Drivers d2 = DriversFactory.createDriver("Johann Engelbrecht","Porsche GT3 Cup");
        Drivers d3 = DriversFactory.createDriver("Steve Humble","Juno Sport");

        Drivers dr1 = DriversFactory.createDriver("Craig Jarvis","Panacea Ford Mustang V8");
        Drivers dr2 = DriversFactory.createDriver("Jurgens Zubenthaim","Novel Ford Mustang V8");
        Drivers dr3 = DriversFactory.createDriver("Marcel Angel","Angel Autohaus Ford Mustang V8");

        driversList1.add(d1);
        driversList1.add(d2);
        driversList1.add(d3);

        driversList2.add(dr1);
        driversList2.add(dr2);
        driversList2.add(dr3);


        Classes c1 = ClassesFactory.createClass("Sports & GT","S&GT",driversList1);
        Classes c2 = ClassesFactory.createClass("Masters V8","MV8",driversList2);

        classList1.add(c1);
        classList1.add(c2);

        Tracks killarney = TracksFactory.createTrack("Killarney Motor Racing Complex",classList1);
        trackList.add(killarney);

        //Zwartkops 2 Classes
        List<Classes> classList2 = new ArrayList<Classes>();

        List<Drivers> driversList3 = new ArrayList<Drivers>();
        List<Drivers> driversList4 = new ArrayList<Drivers>();

        Drivers dri1 = DriversFactory.createDriver("Charl Joubert","Lotus Exige R");
        Drivers dri2 = DriversFactory.createDriver("Scois Joubert", "Ariel Atom 300");
        Drivers dri3 =DriversFactory.createDriver("Pieter Joubert", "Lotus Elise Motorsport");

        Drivers driv1 = DriversFactory.createDriver("Anthony Taylor", "Afrox BMW 335i");
        Drivers driv2 = DriversFactory.createDriver("Hennie Groenewald", "Sasol Subaru Impreza WRX STi");
        Drivers driv3 = DriversFactory.createDriver("Michael Stewart", "Total Audi S4");

        driversList3.add(dri1);
        driversList3.add(dri2);
        driversList3.add(dri3);

        driversList4.add(driv1);
        driversList4.add(driv2);
        driversList4.add(driv3);

        Classes cl1 =  ClassesFactory.createClass("GT Class","GT",driversList3);
        Classes cl2 = ClassesFactory.createClass("Bridgestone Production Cars","BPC",driversList4);

        classList2.add(cl1);
        classList2.add(cl2);


        Tracks zwartkops = TracksFactory.createTrack("Zwartkops Raceway",classList2);


        trackList.add(zwartkops);

        repository.save(trackList);
        id = killarney.getId();

        Assert.assertNotNull(id);*/
    }

    @Test
    public void testGet() throws Exception
    {
        List <Tracks> tracks = service.getTrack(id);

        Assert.assertTrue(tracks.size() == 2);
    }
}

package RaceProgramme.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by student on 2015/09/06.
 */
@RestController
@RequestMapping("/api/**")

public class HomePage
{
   /* @Autowired
    private ClassesService classesService;

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "classes",method = RequestMethod.GET)
    public Classes getClasses()
    {
        Classes classes = new Classes.Builder("S&GT").className("Sports & GT").build();
        return classes;
    }

    @RequestMapping(value = "/classes",method = RequestMethod.GET)
    public List<Classes> getClasses2()
    {
        return classesService.getClasses();
    }*/
}

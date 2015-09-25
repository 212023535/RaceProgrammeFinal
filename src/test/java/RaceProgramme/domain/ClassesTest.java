package RaceProgramme.domain;

import RaceProgramme.conf.Factory.ClassesFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/11.
 */
public class ClassesTest
{
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void createClass() throws Exception
    {

        Map<String,String> KillarneyClasses = new HashMap<String,String>();
        KillarneyClasses.put("ClassName", "Sports and GT");
        KillarneyClasses.put("ClassCode", "S&GT");
        KillarneyClasses.put("ClassName","V8 Masters");
        KillarneyClasses.put("ClassCode","V8M");

        Classes class1 = ClassesFactory.createClass(KillarneyClasses);
        Assert.assertEquals("S&GT",class1.getClassCode());
    }

    @Test
    public void updateClass() throws Exception
    {
        Map<String,String> KillarneyClasses = new HashMap<String,String>();
        KillarneyClasses.put("ClassName", "Sports and GT");
        KillarneyClasses.put("ClassCode", "S&GT");
        KillarneyClasses.put("ClassName","V8 Masters");
        KillarneyClasses.put("ClassCode","V8M");
        Classes class1 = ClassesFactory.createClass(KillarneyClasses);

        Classes class2 = new Classes.Builder(class1.getClassCode()).copy(class1).classCode("MV8").build();

        Assert.assertEquals("S&GT",class1.getClassCode());
        Assert.assertEquals("MV8",class2.getClassCode());
    }
}

package RaceProgramme.conf.Factory;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;
import RaceProgramme.domain.Grid;

/**
 * Created by student on 2015/09/06.
 */
public class GridFactory
{
    public static Grid createGrid(Long id,String pos,Drivers driverName,Drivers vehicle,Classes className)
    {
        Grid grid = new Grid.Builder(id).pos(pos).driverName(driverName).vehicle(vehicle).className(className).build();

        return grid;
    }
}

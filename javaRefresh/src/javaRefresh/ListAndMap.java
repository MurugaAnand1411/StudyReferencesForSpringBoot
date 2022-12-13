package javaRefresh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//create a list
class mobileAccessories {

  // id will act as Key
  private Integer id;

  // name will act as value
  private String name;

  // create curstuctor for reference
  public mobileAccessories(Integer id, String name)
  {

      // assign the value of id and name
      this.id = id;
      this.name = name;
  }

  // return private variable id
  public Integer getId()
  {
      return id;
  }

  // return private variable name
  public String getName()
  {
      return name;
  }
}

//main class and method
public class ListAndMap {

  // main Driver
  public static void main(String[] args)
  {

      // create a list
      List<mobileAccessories>
          lt = new ArrayList<mobileAccessories>();

      // add the member of list
      lt.add(new mobileAccessories(1, "cable"));
      lt.add(new mobileAccessories(2, "charger"));
      lt.add(new mobileAccessories(3, "cover"));

      // create map with the help of
      // Object (stu) method
      // create object of Map class
      Map<Integer, String> map = new HashMap<>();

      // put every value list to Map
      for (mobileAccessories mob : lt) {
          map.put(mob.getId(), mob.getName());
      }

      // print map
      System.out.println("Map  : " + map);
  }
}


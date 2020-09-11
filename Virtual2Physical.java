import java.util.Vector;

public class Virtual2Physical 
{
  public static int pageNum ( long memaddr , int numpages , long block ) 
  {
    int i = 0;
    long high = 0;
    long low = 0;
    
    for (i = 0; i <= numpages; i++) 
    {
      low = block * i;
      high = block * ( i + 1 ); 
      if ( low <= memaddr && memaddr < high ) 
      {
        return i;
      }
    } 
    return -1;
  }

  public static String getSegments (int virtualPage, long initialSection, long finalSection) {
    long block = 4096L;
    long low = (4 * block) * virtualPage;
    long high = (4 * block) * (virtualPage + 1); 

    System.out.println("low: " + low);
    System.out.println("hihg: " + high);    
    System.out.println("virtualPage: " + virtualPage);
    System.out.println("initialSection: " + initialSection);
    System.out.println("finalSection: " + finalSection);
    System.out.println("block: " + block);

    if ((low <= initialSection && initialSection < high) && (low <= finalSection && finalSection < high)) {
      //El segmento pertenece a esta página
      
      String segments = "";

      /*
        S1 : low -- low + block
        S2 : (low + block) -- low + (2*block)
        S3 : (low + (2*block)) -- low + (3*block)
        S4 : (low + (3*block)) -- low + (4*block)
      */

      if ((initialSection >= low && initialSection < (low + block)) && (finalSection >= initialSection)) {
        segments += "S1 ";
        initialSection += block;
      } 

      if ((initialSection >= (low + block) && initialSection < (low + (2*block))) && (finalSection >= initialSection)) {
        segments += "S2 ";
        initialSection += block;
      }

      if ((initialSection >= (low + (2*block)) && initialSection < (low + (3*block))) && (finalSection >= initialSection)) {
        segments += "S3 ";
        initialSection += block;
      }

      if ((initialSection >= (low + (3*block)) && initialSection < (low + (4*block))) && (finalSection >= initialSection)) {
        segments += "S4 ";
      }

      return segments;

    } else {
      //El segmento no pertenece a esta sección
      return null;
    }
  }

}

public class Instruction 
{
  public String inst;
  public long addr;
  public long initialSegment;
  public long finalSegment;

  public Instruction( String inst, long addr, long initialSegment, long finalSegment ) 
  {
    this.inst = inst;
    this.addr = addr;
    this.initialSegment = initialSegment;
    this.finalSegment = finalSegment;
  } 	

}

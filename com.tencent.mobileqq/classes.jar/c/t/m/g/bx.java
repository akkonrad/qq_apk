package c.t.m.g;

public final class bx
  implements bc, bv
{
  private static bx a = new bx();
  private bv b;
  private bc c;
  private boolean d = false;
  
  public static bx c()
  {
    return a;
  }
  
  public final void a()
  {
    this.b.a();
  }
  
  public final void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public final void a(bc parambc)
  {
    this.c = parambc;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.c.a(paramString1, paramArrayOfByte, paramString2);
  }
  
  public final void a_()
  {
    this.c.a_();
  }
  
  public final void b()
  {
    this.b.b();
  }
  
  /* Error */
  public final void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	c/t/m/g/bx:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokestatic 55	c/t/m/g/bo:c	()Lc/t/m/g/bo;
    //   18: putfield 30	c/t/m/g/bx:b	Lc/t/m/g/bv;
    //   21: aload_0
    //   22: getfield 30	c/t/m/g/bx:b	Lc/t/m/g/bv;
    //   25: ifnull +22 -> 47
    //   28: aload_0
    //   29: getfield 30	c/t/m/g/bx:b	Lc/t/m/g/bv;
    //   32: aload_0
    //   33: invokeinterface 57 2 0
    //   38: aload_0
    //   39: getfield 30	c/t/m/g/bx:b	Lc/t/m/g/bv;
    //   42: invokeinterface 59 1 0
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 27	c/t/m/g/bx:d	Z
    //   52: goto -41 -> 11
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	bx
    //   6	2	1	bool	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   14	47	55	finally
    //   47	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bx
 * JD-Core Version:    0.7.0.1
 */
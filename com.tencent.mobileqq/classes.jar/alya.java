import com.tencent.qqprotect.qsec.QSecLibMgr;
import com.tencent.qqprotect.qsec.QSecLibMgr.LibEventListener;
import com.tencent.qqprotect.qsec.QSecPushServiceMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class alya
  implements QSecLibMgr.LibEventListener
{
  public alya(QSecPushServiceMgr paramQSecPushServiceMgr) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (QSecPushServiceMgr.a(this.a))
      {
        Object localObject2 = (List)QSecPushServiceMgr.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          QSecPushServiceMgr.a(this.a).remove(Integer.valueOf(paramInt2));
          QSecPushServiceMgr.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (alyb)((Iterator)???).next();
            QSecPushServiceMgr.a(this.a).a(((alyb)localObject2).jdField_a_of_type_Int, ((alyb)localObject2).b, ((alyb)localObject2).c, new Object[] { ((alyb)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alya
 * JD-Core Version:    0.7.0.1
 */
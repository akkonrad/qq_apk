import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public final class fns
  implements Comparator
{
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fns
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public final class cyq
  implements Comparator
{
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cyq
 * JD-Core Version:    0.7.0.1
 */
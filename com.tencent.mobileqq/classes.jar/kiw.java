import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;
import com.tencent.biz.JoinGroupTransitActivity;

public class kiw
  implements JoinGroupHandler.IJoinGroupCB
{
  public kiw(JoinGroupTransitActivity paramJoinGroupTransitActivity) {}
  
  public void a()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(1);
  }
  
  public void b()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(2);
  }
  
  public void c()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kiw
 * JD-Core Version:    0.7.0.1
 */
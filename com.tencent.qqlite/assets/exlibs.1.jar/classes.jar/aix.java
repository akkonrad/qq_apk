import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class aix
  extends DiscussionObserver
{
  public aix(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0) && (paramLong == Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        HashMap localHashMap = new HashMap();
        if (!TextUtils.isEmpty(str))
        {
          Friends localFriends = ((FriendManager)this.a.app.getManager(8)).c(str);
          if (localFriends != null) {
            localHashMap.put("memberName", localFriends.name);
          }
          for (;;)
          {
            localHashMap.put("memberUin", str);
            localArrayList1.add(localHashMap);
            localArrayList2.add(str);
            break;
            localHashMap.put("memberName", str);
          }
        }
      }
      this.a.a(localArrayList1);
      DiscussionInfoCardActivity.a(this.a).addAll(localArrayList2);
      this.a.a(2, this.a.getString(2131363676));
      DiscussionInfoCardActivity.a(this.a);
      if (!this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.a)))) {
      ReportController.b(this.a.app, "CliOper", "", "", "discuss", "discuss_common", 0, 0, "", "", "", "");
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if ((paramBoolean) && (paramLong1 != null) && (String.valueOf(paramLong1).equals(DiscussionInfoCardActivity.a(this.a))))
    {
      DiscussionInfoCardActivity.a(this.a, DiscussionInfoCardActivity.a(this.a));
      return;
    }
    QQToast.a(this.a, 1, this.a.getString(2131363219), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.a).equals(paramString))
    {
      if (!paramBoolean) {
        break label110;
      }
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131363680));
        DiscussionInfoCardActivity.a(this.a).c(2130837989);
        DiscussionInfoCardActivity.a(this.a).b(false);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16, 1500L);
      }
    }
    label110:
    while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing())) {
      return;
    }
    DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131363681));
    DiscussionInfoCardActivity.a(this.a).c(2130837979);
    DiscussionInfoCardActivity.a(this.a).b(false);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 1500L);
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    if ((DiscussionInfoCardActivity.a(this.a).equals(str)) && (paramBoolean) && (bool))
    {
      paramArrayOfObject = (FriendsManagerImp)this.a.app.getManager(8);
      this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramArrayOfObject.a(DiscussionInfoCardActivity.a(this.a));
      DiscussionInfoCardActivity.a(this.a, DiscussionInfoCardActivity.a(this.a));
      this.a.a();
      DiscussionInfoCardActivity.b(this.a);
    }
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    paramArrayOfObject = (String)paramArrayOfObject[2];
    if ((paramArrayOfObject == null) || (paramArrayOfObject.trim().equals(""))) {
      paramArrayOfObject = this.a.getString(2131363682);
    }
    for (;;)
    {
      if (DiscussionInfoCardActivity.a(this.a).equals(str))
      {
        if ((10001 == i) || (10002 == i)) {
          DialogUtil.a(this.a, 230, null, paramArrayOfObject, new aiy(this, str), null).show();
        }
      }
      else {
        return;
      }
      this.a.a(1, paramArrayOfObject);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.a)))) {}
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.a).equals(paramString))
    {
      if (!paramBoolean) {
        break label164;
      }
      paramString = ((FriendsManagerImp)this.a.app.getManager(8)).a(paramString);
      if (paramString != null)
      {
        DiscussionInfoCardActivity.a(this.a, paramString.discussionName);
        DiscussionInfoCardActivity.a(this.a).setText(DiscussionInfoCardActivity.b(this.a));
      }
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131363673));
        DiscussionInfoCardActivity.a(this.a).c(2130837989);
        DiscussionInfoCardActivity.a(this.a).b(false);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 1500L);
      }
    }
    label164:
    do
    {
      return;
      DiscussionInfoCardActivity.a(this.a).setText(DiscussionInfoCardActivity.b(this.a));
    } while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing()));
    DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131363674));
    DiscussionInfoCardActivity.a(this.a).c(2130837989);
    DiscussionInfoCardActivity.a(this.a).b(false);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aix
 * JD-Core Version:    0.7.0.1
 */
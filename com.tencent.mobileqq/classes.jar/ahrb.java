import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Map;

public class ahrb
  implements AdapterView.OnItemClickListener
{
  public ahrb(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ThreadPriorityManager.a(true);
    SearchHistory localSearchHistory;
    label270:
    int i;
    if ((paramAdapterView == this.a.jdField_a_of_type_ComTencentWidgetXListView) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null))
    {
      SearchUtils.a("home_page", "clk_history", new String[] { "" + paramInt });
      paramAdapterView = (IContactSearchable)this.a.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.getItem(paramInt);
      if ((paramAdapterView instanceof ContactSearchableSearchHistory))
      {
        localSearchHistory = ((ContactSearchableSearchHistory)paramAdapterView).a();
        QLog.d("searchUtils", 2, "on serarch history click, " + localSearchHistory.toString());
        switch (localSearchHistory.type)
        {
        default: 
          paramInt = 1;
          if (paramInt != 0)
          {
            SearchUtils.a(HistorySearchEntryModel.a(this.a), localSearchHistory.displayName, localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type);
            if (localSearchHistory.type != 1) {
              break label1073;
            }
            i = 2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      label316:
      paramInt = 0;
      if (this.a.b == 2) {
        paramInt = 3;
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "Search", "May_find", paramInt, 0, String.valueOf(i), "", "", "");
        return;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 29);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label270;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 34);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label270;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 53);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label270;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 53);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label270;
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localSearchHistory.uin, 33);
        localAllInOne.a = new ArrayList();
        localAllInOne.k = localSearchHistory.displayName;
        if (!TextUtils.isEmpty(localSearchHistory.uin))
        {
          String[] arrayOfString = localSearchHistory.uin.split("\\|");
          if (arrayOfString != null)
          {
            paramInt = 0;
            if (paramInt < arrayOfString.length)
            {
              ArrayList localArrayList = localAllInOne.a;
              StringBuilder localStringBuilder = new StringBuilder().append("电话");
              if (arrayOfString.length > 0) {}
              for (paramAdapterView = Integer.valueOf(paramInt + 1);; paramAdapterView = "")
              {
                localArrayList.add(new ProfileActivity.CardContactInfo(paramAdapterView, arrayOfString[paramInt], null));
                paramInt += 1;
                break;
              }
            }
          }
        }
        localAllInOne.g = 3;
        ProfileActivity.b(paramView.getContext(), localAllInOne);
        paramInt = 1;
        break label270;
        paramAdapterView = (FriendsManager)HistorySearchEntryModel.a(this.a).getManager(50);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.c(localSearchHistory.uin);
          if (paramAdapterView != null)
          {
            RecentUtil.a = true;
            RecentUtil.a(paramView.getContext(), HistorySearchEntryModel.a(this.a), localSearchHistory.uin, 0, ContactUtils.a(paramAdapterView), false);
          }
          paramInt = 1;
          break label270;
        }
        paramInt = 0;
        break label270;
        paramAdapterView = (DiscussionManager)HistorySearchEntryModel.a(this.a).getManager(52);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.a(localSearchHistory.troopUin);
          if (paramAdapterView != null)
          {
            paramAdapterView = (DiscussionMemberInfo)paramAdapterView.get(localSearchHistory.uin);
            if (paramAdapterView != null)
            {
              RecentUtil.a = true;
              RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, paramAdapterView.memberName, false);
              paramInt = 1;
              break label270;
            }
          }
        }
        RecentUtil.a = true;
        RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label270;
        RecentUtil.a = true;
        RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label270;
        RecentUtil.a = true;
        RecentUtil.a(paramView.getContext(), HistorySearchEntryModel.a(this.a), localSearchHistory.uin, localSearchHistory.type, localSearchHistory.displayName, false);
        paramInt = 1;
        break label270;
        if (!TextUtils.equals(localSearchHistory.uin, AppConstants.ar)) {
          break;
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
        ReadInJoyActivityHelper.a(paramView.getContext(), null, -1L, 1);
        paramInt = 1;
        break label270;
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
        ReadInJoyActivityHelper.a(HistorySearchEntryModel.a(this.a), paramView.getContext(), 1, 0);
        break;
        label1073:
        if (localSearchHistory.type != 3000) {
          break label1123;
        }
        i = 3;
        break label316;
        if (this.a.b == 10) {
          paramInt = 2;
        } else if (this.a.b == 1) {
          paramInt = 1;
        }
      }
      label1123:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahrb
 * JD-Core Version:    0.7.0.1
 */
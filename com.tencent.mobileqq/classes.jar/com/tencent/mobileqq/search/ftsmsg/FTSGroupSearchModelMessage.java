package com.tencent.mobileqq.search.ftsmsg;

import android.view.View;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSGroupSearchModelEntity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.List;

public class FTSGroupSearchModelMessage
  extends FTSGroupSearchModelEntity
{
  public FTSGroupSearchModelMessage(List paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  public int a()
  {
    return SearchEntryConfigManager.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return "聊天记录";
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.a, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      SearchUtils.a("all_result", "more_talk", new String[] { "" + this.a });
    }
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.d = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 0;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.h = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.i = -1;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = -1;
    SQLiteFTSUtils.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage
 * JD-Core Version:    0.7.0.1
 */
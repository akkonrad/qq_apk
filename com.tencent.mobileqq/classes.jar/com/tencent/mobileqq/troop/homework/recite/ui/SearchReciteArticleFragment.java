package com.tencent.mobileqq.troop.homework.recite.ui;

import ajjp;
import ajjq;
import ajjr;
import ajjs;
import ajju;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.utils.TroopReciteCgiHandler;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.widget.FlowLayout;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchReciteArticleFragment
  extends AbsHomeWorkFragment
  implements HttpWebCgiAsyncTask.Callback
{
  private volatile long jdField_a_of_type_Long;
  private ajju jdField_a_of_type_Ajju;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter;
  private TroopReciteCgiHandler jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler;
  private HttpWebCgiAsyncTask2 jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2;
  private FlowLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetFlowLayout;
  private LoadMoreXListView jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private HttpWebCgiAsyncTask2 jdField_b_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2;
  private boolean jdField_b_of_type_Boolean;
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    LinkedList localLinkedList;
    int i;
    int j;
    do
    {
      return paramString2;
      localLinkedList = new LinkedList();
      i = 0;
      j = paramString2.length();
      while (i < j)
      {
        if (paramString1.contains(String.valueOf(paramString2.charAt(i)))) {
          localLinkedList.offer(Integer.valueOf(i));
        }
        i += 1;
      }
    } while (localLinkedList.isEmpty());
    paramString1 = new SpannableString(paramString2);
    while (!localLinkedList.isEmpty())
    {
      j = ((Integer)localLinkedList.poll()).intValue();
      i = j + 1;
      while ((!localLinkedList.isEmpty()) && (i == ((Integer)localLinkedList.peek()).intValue()))
      {
        localLinkedList.poll();
        i += 1;
      }
      paramString1.setSpan(new ForegroundColorSpan(paramInt), j, i, 33);
    }
    return paramString1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "", -2147483648);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("keywords", paramString2);
    localIntent.putExtra("troop_uin", paramString1);
    AbsHomeWorkFragment.a((Activity)paramContext, SearchReciteArticleFragment.class, localIntent, paramInt, "");
  }
  
  private void a(JSONObject paramJSONObject, Bundle paramBundle)
  {
    String str1 = "0";
    if (paramJSONObject != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchReciteArticleFragment", 2, paramJSONObject.toString());
      }
    }
    for (;;)
    {
      int i;
      String str2;
      try
      {
        i = paramJSONObject.getInt("retcode");
        if (i != 0) {
          continue;
        }
        Object localObject = paramJSONObject.getJSONObject("result");
        if (localObject == null) {
          break label309;
        }
        i = ((JSONObject)localObject).getInt("errCode");
        if (i != 0) {
          continue;
        }
        localObject = ((JSONObject)localObject).optJSONArray("rs");
        if (localObject != null)
        {
          int j = ((JSONArray)localObject).length();
          if (j != 0)
          {
            i = 0;
            if (i < j)
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter.a(((JSONArray)localObject).optString(i));
              i += 1;
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter.notifyDataSetChanged();
            if (!this.jdField_a_of_type_Boolean) {
              a(false);
            }
          }
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SearchReciteArticleFragment", 2, localJSONException, new Object[0]);
        str2 = "-1";
        i = 0;
        continue;
      }
      if (i == 0)
      {
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onGetKeywordListCallBack server error: ", paramBundle, "\n", paramJSONObject });
        }
        h();
        paramJSONObject = str1;
        if (i != 0)
        {
          i = 1;
          TroopReportor.a("Grp_edu", "publish_homework", "get_search_keywords", 0, i, new String[] { paramJSONObject });
          return;
          str1 = String.valueOf(i);
          i = 0;
          continue;
          str1 = String.valueOf(i);
          i = 0;
          continue;
          if ((QLog.isColorLevel()) && (paramBundle != null)) {
            QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onGetKeywordListCallBack client error: ", paramBundle });
          }
          paramJSONObject = "-1";
          i = 0;
        }
        else
        {
          i = 2;
        }
      }
      else
      {
        paramJSONObject = str2;
        continue;
        label309:
        i = 0;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter.getCount() != 0) {}
    for (;;)
    {
      localView.setVisibility(i);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      i = 8;
    }
  }
  
  private void b(String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      f();
      if (QLog.isColorLevel()) {
        QLog.i("SearchReciteArticleFragment", 2, "request search start is " + this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler.a(localQQAppInterface, this, paramString, this.jdField_b_of_type_Int, 10, 10002);
    }
  }
  
  private void b(JSONObject paramJSONObject, Bundle paramBundle)
  {
    boolean bool4 = false;
    boolean bool1 = false;
    int k;
    int i;
    boolean bool3;
    int j;
    boolean bool2;
    if (paramJSONObject != null)
    {
      k = 0;
      i = 0;
      bool3 = true;
      bool1 = true;
      if (this.jdField_b_of_type_Int != 0) {
        break label588;
      }
      j = 1;
      if (QLog.isColorLevel()) {
        QLog.i("SearchReciteArticleFragment", 2, paramJSONObject.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.a(true);
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        m = paramJSONObject.getInt("retcode");
        if (m != 0) {
          continue;
        }
        bool2 = bool1;
        localObject = paramJSONObject.getJSONObject("result");
        if (localObject == null) {
          break label573;
        }
        bool2 = bool1;
        m = ((JSONObject)localObject).getInt("errCode");
        bool2 = bool1;
        if (((JSONObject)localObject).getInt("is_end") != 0) {
          break label594;
        }
        bool1 = true;
        if (m != 0) {
          continue;
        }
        bool4 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (!((JSONObject)localObject).has("rs")) {
          break label573;
        }
        bool2 = bool1;
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("rs");
        if (localJSONArray == null) {
          break label568;
        }
        bool2 = bool1;
        m = localJSONArray.length();
        if (m == 0) {
          break label568;
        }
        i = 0;
        if (i < m)
        {
          bool2 = bool1;
          this.jdField_a_of_type_Ajju.a((SearchReciteArticleFragment.SearchArticle)JSONUtils.b(localJSONArray.optJSONObject(i), SearchReciteArticleFragment.SearchArticle.class));
          i += 1;
          continue;
        }
        bool2 = bool1;
        this.jdField_a_of_type_Ajju.a(((JSONObject)localObject).optString("key", ""));
        bool2 = bool1;
        this.jdField_a_of_type_Ajju.notifyDataSetChanged();
        bool2 = bool1;
        this.jdField_b_of_type_Int += 10;
        i = 1;
        localObject = "0";
        bool2 = true;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      catch (JSONException localJSONException)
      {
        int m;
        Object localObject;
        bool1 = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SearchReciteArticleFragment", 2, localJSONException, new Object[0]);
        str = "-1";
        i = k;
        continue;
      }
      if ((j != 0) && (i == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.a(bool1, bool2);
      if (!bool1)
      {
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onSearchArticleCallBack server error: ", paramBundle, "\n", paramJSONObject });
        }
        h();
      }
      paramJSONObject = (JSONObject)localObject;
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("key", "");
        paramBundle = paramBundle.getString("start", "");
        if (bool1)
        {
          i = 1;
          TroopReportor.a("Grp_edu", "publish_homework", "kewen_search", 0, i, new String[] { localObject, paramBundle, paramJSONObject });
        }
      }
      else
      {
        return;
        bool4 = false;
        bool3 = bool1;
        bool2 = bool1;
        localObject = String.valueOf(m);
        bool1 = bool3;
        bool2 = bool4;
        continue;
        bool2 = false;
        bool1 = true;
        localObject = String.valueOf(m);
        continue;
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onSearchArticleCallBack client error: ", paramBundle });
        }
        h();
        paramJSONObject = "-1";
        continue;
      }
      i = 2;
      continue;
      label568:
      i = 0;
      continue;
      label573:
      bool1 = bool3;
      String str = "0";
      bool2 = bool4;
      continue;
      label588:
      j = 0;
      break;
      label594:
      bool1 = false;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131368322));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView = ((LoadMoreXListView)a(2131363924));
    this.jdField_a_of_type_AndroidViewView = a(2131363925);
    this.jdField_b_of_type_AndroidViewView = a(2131368448);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFlowLayout = ((FlowLayout)a(2131368449));
  }
  
  private void d()
  {
    a("搜索背诵文章");
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ajjp(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter.a = new ajjq(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setAdapter(this.jdField_a_of_type_Ajju);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.a(new ajjr(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setOnItemClickListener(new ajjs(this));
    String str = getArguments().getString("keywords", "");
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
    }
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      g();
      this.jdField_b_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler.a(localQQAppInterface, this, this.jdField_a_of_type_JavaLangString, 10001);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2.cancel(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2.cancel(true);
      this.jdField_b_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 = null;
    }
  }
  
  private void h()
  {
    QQToast.a(getActivity(), "网络异常，请检查网络设置。", 0).a();
  }
  
  protected int a()
  {
    return 2130969910;
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    paramActivity.getWindow().setSoftInputMode(32);
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$FlowLayoutKeywordsListAdapter = new SearchReciteArticleFragment.FlowLayoutKeywordsListAdapter(null);
    this.jdField_a_of_type_Ajju = new ajju(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler = new TroopReciteCgiHandler();
  }
  
  protected void a(@Nullable String paramString) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 10001: 
      a(paramJSONObject, paramBundle);
      return;
    }
    b(paramJSONObject, paramBundle);
  }
  
  protected void b(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    d();
    e();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 257) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
      if (TextUtils.isEmpty(paramIntent)) {}
    }
    try
    {
      a(new JSONObject(paramIntent));
      b();
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_Boolean = true;
    g();
    f();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.homework.recite.ui;

import ajjw;
import ajjx;
import ajjy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.utils.HWReciteUtils;
import com.tencent.mobileqq.troop.homework.recite.utils.TroopReciteCgiHandler;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class SelectReciteParagraphFragment
  extends AbsHomeWorkFragment
  implements HttpWebCgiAsyncTask.Callback
{
  private ajjy jdField_a_of_type_Ajjy;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ArticleInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo;
  private TroopReciteCgiHandler jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler;
  private HttpWebCgiAsyncTask2 jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, paramString1, paramString2, new ArrayList(0), paramInt);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, ArrayList paramArrayList, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("kid", paramString2);
    localIntent.putExtra("troop_uin", paramString1);
    if (paramArrayList != null) {
      localIntent.putExtra("selected_list", paramArrayList);
    }
    AbsHomeWorkFragment.a((Activity)paramContext, SelectReciteParagraphFragment.class, localIntent, paramInt, "");
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131368450));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131368452));
  }
  
  private void d()
  {
    a("选择背诵的段落");
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new ajjw(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ajjx(this));
    f();
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler.a(localQQAppInterface, this, this.b, null, 10003);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText("背诵选中段落");
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    while (this.jdField_a_of_type_Ajjy == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_Ajjy.getCount())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText("背诵全文");
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      String str = this.jdField_a_of_type_Ajjy.a(j).content_html;
      if (str == null) {
        break label178;
      }
      i = str.length() + i;
    }
    label178:
    for (;;)
    {
      break;
      this.jdField_a_of_type_AndroidWidgetButton.setText(String.format("背诵%s，共%d字", new Object[] { HWReciteUtils.a(new ArrayList(this.jdField_a_of_type_JavaUtilSet)), Integer.valueOf(i) }));
      return;
    }
  }
  
  private void g()
  {
    QQToast.a(getActivity(), "网络异常，请检查网络设置。", 0).a();
  }
  
  protected int a()
  {
    return 2130969911;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("troop_uin", "");
    this.b = paramBundle.getString("kid", "");
    paramBundle = paramBundle.getIntegerArrayList("selected_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.jdField_a_of_type_JavaUtilSet.addAll(paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler = new TroopReciteCgiHandler();
  }
  
  protected void a(@Nullable String paramString) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = ArticleInfo.onHandleGetArticleDetail(paramBundle, paramJSONObject);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null)
    {
      g();
      return;
    }
    this.jdField_a_of_type_Ajjy = new ajjy(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_JavaUtilSet);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajjy);
    f();
  }
  
  protected void b(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    d();
    e();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2.cancel(true);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment
 * JD-Core Version:    0.7.0.1
 */
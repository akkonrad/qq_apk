package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import uju;
import ujv;
import ujw;

public class BabyQAIOPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private FriendChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildFriendChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ujw jdField_a_of_type_Ujw;
  
  public BabyQAIOPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public BabyQAIOPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    BabyQHandler localBabyQHandler = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
    int i;
    String str2;
    Object localObject1;
    String str1;
    Object localObject2;
    if ((localBabyQHandler.jdField_a_of_type_JavaUtilHashMap != null) && (!localBabyQHandler.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (localBabyQHandler.jdField_a_of_type_JavaUtilArrayList != null) && (!localBabyQHandler.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = localBabyQHandler.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = (String[])localBabyQHandler.jdField_a_of_type_JavaUtilHashMap.get(str2);
          if ((localObject1 != null) && (localObject1.length == 2))
          {
            str1 = localObject1[0];
            localObject2 = localObject1[1];
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        int j = Integer.parseInt(str1);
        localObject1 = new uju();
        ((uju)localObject1).jdField_a_of_type_JavaLangString = str2;
        ((uju)localObject1).jdField_a_of_type_Int = j;
        ((uju)localObject1).jdField_a_of_type_Boolean = "1".equalsIgnoreCase((String)localObject2);
        ((uju)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = localBabyQHandler.a(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("loadDatas | item.drawable is :");
          if (((uju)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            break label303;
          }
          str1 = "null";
          QLog.d("Q.BabyQ", 2, str1 + ", itemCode : " + j);
        }
        if (((uju)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label309;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.BabyQ", 2, "initDatas|get item code error :  " + str1);
      break;
      label303:
      str1 = "not null";
      continue;
      label309:
      if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131433366)))
      {
        ((uju)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838382);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131433368)))
      {
        ((uju)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838380);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131433367)))
      {
        ((uju)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838381);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
        continue;
        if (i != 0) {
          c();
        }
        return;
        c();
        return;
      }
    }
  }
  
  private void c()
  {
    uju localuju = new uju();
    localuju.jdField_a_of_type_Boolean = false;
    localuju.jdField_a_of_type_Int = 1;
    localuju.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131433368);
    localuju.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838380);
    this.jdField_a_of_type_JavaUtilArrayList.add(localuju);
    localuju = new uju();
    localuju.jdField_a_of_type_Boolean = false;
    localuju.jdField_a_of_type_Int = 2;
    localuju.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131433367);
    localuju.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838381);
    this.jdField_a_of_type_JavaUtilArrayList.add(localuju);
    localuju = new uju();
    localuju.jdField_a_of_type_Boolean = false;
    localuju.jdField_a_of_type_Int = 3;
    localuju.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131433366);
    localuju.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838382);
    this.jdField_a_of_type_JavaUtilArrayList.add(localuju);
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Ujw != null) {
      this.jdField_a_of_type_Ujw.notifyDataSetChanged();
    }
  }
  
  public void a(FriendChatPie paramFriendChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramFriendChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildFriendChatPie = paramFriendChatPie;
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494037));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131362572));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(2);
    b();
    this.jdField_a_of_type_Ujw = new ujw(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Ujw);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof ujv)))
    {
      paramView = (ujv)paramView.getTag();
      localObject = paramView.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildFriendChatPie.a.append((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildFriendChatPie.ak();
      BabyQHandler localBabyQHandler = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if (localBabyQHandler.b((String)localObject))
      {
        localBabyQHandler.a((String)localObject);
        a();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806D", "0X800806D", paramView.jdField_a_of_type_Int, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */
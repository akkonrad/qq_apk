package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;
import eiy;
import eiz;
import eja;
import ejb;
import ejc;
import ejd;
import eje;
import java.util.ArrayList;

public class CircleGroupListView
  extends BaseNewFriendView
  implements View.OnClickListener
{
  static final boolean b = true;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  public SearchResultDialog a;
  public CircleManager a;
  IGroupObserver jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver = new eiy(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public ejd a;
  public ArrayList a;
  private View d;
  
  public CircleGroupListView(Context paramContext, ForwardOperations paramForwardOperations)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = paramForwardOperations;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_JavaUtilArrayList);
    boolean bool;
    if (i != 0)
    {
      CircleManager localCircleManager = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        bool = true;
        i = localCircleManager.a(i, bool);
        if (i != 0) {
          break label116;
        }
        b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ejd = new ejd(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ejd);
      return;
      bool = false;
      break;
      label116:
      if (i == -2)
      {
        a(2131562449, 1);
        continue;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          d(true);
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    Contacts.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new eiz(this, getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new eja(this));
    localTranslateAnimation2.setAnimationListener(new ejb(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(new ejc(this, paramInt, localTranslateAnimation2));
    this.b.startAnimation(localTranslateAnimation1);
  }
  
  private void d(boolean paramBoolean)
  {
    int j = 8;
    Object localObject = this.d;
    if (paramBoolean)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
      if (!paramBoolean) {
        break label46;
      }
    }
    label46:
    for (int i = j;; i = 0)
    {
      ((XListView)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232903));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(null);
    this.d = findViewById(2131232904);
    View localView = ((Activity)getContext()).getLayoutInflater().inflate(2130903942, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    localView.findViewById(2131233084).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131233085);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    ((TextView)localView.findViewById(2131234396)).setText(2131562831);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
  }
  
  public View a()
  {
    View localView = ((Activity)getContext()).getLayoutInflater().inflate(2130903553, null);
    localView.setId(2130903553);
    eje localeje = new eje(null);
    localeje.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131230940));
    localeje.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131231395));
    localeje.b = ((TextView)localView.findViewById(2131231396));
    Button localButton = (Button)localView.findViewById(2131232032);
    localButton.setBackgroundResource(2130837803);
    localButton.setVisibility(0);
    localButton.setClickable(false);
    localView.setTag(localeje);
    localView.setOnClickListener(this);
    return localView;
  }
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    super.a(paramIntent, paramINewFriendContext);
    a(2130903552);
    j();
    a();
  }
  
  public void a(View paramView, CircleGroup paramCircleGroup)
  {
    eje localeje = (eje)paramView.getTag();
    localeje.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleGroup.groupId));
    localeje.jdField_a_of_type_AndroidWidgetTextView.setText(paramCircleGroup.groupName);
    localeje.b.setText(getResources().getString(2131558935, new Object[] { Integer.valueOf(paramCircleGroup.buddyCount) }));
    localeje.jdField_a_of_type_Int = paramCircleGroup.groupId;
    localeje.jdField_a_of_type_JavaLangString = paramCircleGroup.groupName;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getString(2131558936, new Object[] { localeje.jdField_a_of_type_JavaLangString }));
    localStringBuilder.append(getResources().getString(2131558937, new Object[] { Integer.valueOf(paramCircleGroup.buddyCount) }));
    localStringBuilder.append(getContext().getResources().getString(2131558938));
    paramView.setContentDescription(localStringBuilder.toString());
  }
  
  protected void d()
  {
    super.d();
    if (!this.jdField_a_of_type_Boolean) {
      a(true);
    }
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
    super.h();
  }
  
  public void onClick(View paramView)
  {
    eje localeje;
    switch (paramView.getId())
    {
    default: 
      localeje = (eje)paramView.getTag();
      paramView = this.jdField_a_of_type_AndroidContentIntent;
      if (paramView == null) {
        paramView = new Intent();
      }
      break;
    }
    for (;;)
    {
      paramView.setClass(getContext(), CircleMemberListActivity.class);
      paramView.putExtra("k_group_id", localeje.jdField_a_of_type_Int);
      paramView.putExtra("k_group_name", localeje.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Forward_circle_grp", 0, 0, localeje.jdField_a_of_type_Int - 1 + "", "", "", "");
        b(paramView, 20000);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Forward_search", 0, 0, "", "", "", "");
          c(14);
          return;
        }
        c(13);
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Circle_list_exp", 0, 0, localeje.jdField_a_of_type_Int - 1 + "", "", "", "");
      a(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.CircleGroupListView
 * JD-Core Version:    0.7.0.1
 */
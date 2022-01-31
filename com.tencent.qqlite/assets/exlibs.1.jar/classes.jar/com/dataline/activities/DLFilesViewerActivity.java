package com.dataline.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import c;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.widget.XListView;
import f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class DLFilesViewerActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static final int a = 0;
  public static String a;
  public static final int b = 1;
  public static final String b = "dl_files_groupid";
  public static final int c = 2;
  public static final int d = 3;
  private View jdField_a_of_type_AndroidViewView;
  private DatalineFilesAdapter jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new f(this);
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = null;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DLFilesViewerActivity";
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
    int i = 1;
    int j = 0;
    DataLineMsgRecord localDataLineMsgRecord;
    DLFileInfo localDLFileInfo;
    if (localIterator.hasNext())
    {
      localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      localDLFileInfo = DatalineFilesAdapter.a(localDataLineMsgRecord);
      if (((localDLFileInfo.a != 0) && (localDLFileInfo.a != 3)) || (j != 0)) {
        break label217;
      }
      j = 1;
    }
    label128:
    label151:
    label214:
    label217:
    for (;;)
    {
      int k;
      if ((localDLFileInfo.a == 5) && (localDataLineMsgRecord.strMoloKey != null))
      {
        DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
        if (!localDataLineMsgRecord.bIsApkFile) {
          break label151;
        }
        if (localDataLineHandler.a(localDataLineMsgRecord.strMoloKey))
        {
          k = 1;
          label122:
          localDataLineMsgRecord.nAppStatus = k;
        }
      }
      else
      {
        if ((localDLFileInfo.a == 5) || (i == 0)) {
          break label214;
        }
        i = 0;
      }
      for (;;)
      {
        break;
        k = 0;
        break label122;
        localDataLineMsgRecord.nAppStatus = 1;
        break label128;
        if (i == 0)
        {
          this.j.setVisibility(0);
          if (j != 0)
          {
            this.j.setText(getString(2131361885));
            return;
          }
          this.j.setText(getString(2131361884));
          return;
        }
        this.j.setVisibility(8);
        return;
      }
    }
  }
  
  private void d()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getFirstItem();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsApkFile)) {
      setTitle(2131361890);
    }
    for (;;)
    {
      this.h.setVisibility(0);
      this.h.setText(getString(2131361822));
      c();
      this.j.setOnClickListener(new c(this));
      return;
      setTitle(2131361889);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("dl_files_groupid", 0);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a().a().a(i);
    getWindow().setBackgroundDrawableResource(2131427340);
    setContentView(2130903153);
    getWindow().setBackgroundDrawable(null);
    d();
    this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131296961));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296962));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter = new DatalineFilesAdapter(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet, this, this.app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter);
    paramBundle = LayoutInflater.from(getActivity()).inflate(2130903115, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getActivity().getResources().getDrawable(2130838643));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    paramBundle = this.app.a();
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount() - 1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    c();
    this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter.notifyDataSetChanged();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof DataLineMsgRecord))
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter.notifyDataSetChanged();
      c();
    }
    do
    {
      do
      {
        return;
        if (!(paramObject instanceof QQMessageFacade.Message)) {
          break;
        }
      } while (!((QQMessageFacade.Message)paramObject).frienduin.endsWith(String.valueOf(AppConstants.T)));
      this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter.notifyDataSetChanged();
      c();
      return;
    } while ((!(paramObject instanceof RecentUser)) || (!((RecentUser)paramObject).uin.endsWith(String.valueOf(AppConstants.T))));
    this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter.notifyDataSetChanged();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity
 * JD-Core Version:    0.7.0.1
 */
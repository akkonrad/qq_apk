package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class EmotionDownloadOrUpdateAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  protected EmoticonPackage a;
  protected EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder a;
  private MqqHandler a;
  protected boolean a;
  protected boolean b;
  private int f = 2;
  private int g;
  
  public EmotionDownloadOrUpdateAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    if (paramEmoticonPackage.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.g = paramInt4;
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder == null)) {}
    ProgressButton localProgressButton;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "doDownloadOpr epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        }
        localProgressButton = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
      } while (localProgressButton == null);
      if (!paramBoolean) {
        break;
      }
      d();
    } while (this.f != 2);
    EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals("10278")))
    {
      ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, this.g);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
    }
    localProgressButton.setProgressColor(-16745986);
    float f1 = localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    int i;
    if (this.h == 2)
    {
      localProgressButton.setText("取消");
      localProgressButton.setProgress((int)f1);
      localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, true, this.g);
      this.h = 1;
      i = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, i + "", "");
      return;
      if (this.h == 1)
      {
        String str = "下载";
        if (this.b) {
          str = "更新";
        }
        localProgressButton.setText(str);
        localProgressButton.setProgress(0);
        this.h = 2;
        localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
        i = 2;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))
          {
            EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) {
      return;
    }
    int i = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).j();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 4)
    {
      if ((i == 1) || (i == 3))
      {
        this.f = 2;
        return;
      }
      this.f = 0;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5)
    {
      if (i == 3)
      {
        this.f = 2;
        return;
      }
      this.f = 1;
      return;
    }
    this.f = 2;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 18)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "payback");
      }
      if (a())
      {
        a(true);
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057AD", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt == 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.obj = paramEmoticonPackage;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder paramEmotionDownloadOrUpdateViewHolder)
  {
    if ((paramEmotionDownloadOrUpdateViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "updateUI holder is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateUI epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
    paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = EmosmUtils.a(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    String str;
    for (;;)
    {
      try
      {
        localDrawable1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837572);
        localDrawable2 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841350);
        if (!FileUtils.a((String)localObject)) {
          continue;
        }
        localObject = URLDrawableHelper.a(new URL("file:///" + (String)localObject), localDrawable1, localDrawable2);
        if (localObject == null) {
          continue;
        }
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Drawable localDrawable1;
        Drawable localDrawable2;
        float f1;
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130841350);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130841350);
        continue;
        str = "下载";
        if (!this.b) {
          break;
        }
      }
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      f1 = ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Ep id=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + ", progress=" + f1);
      }
      if (f1 >= 0.0F)
      {
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress((int)(f1 * 100.0F));
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("取消");
        this.h = 1;
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setOnClickListener(this);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = EmosmUtils.b(19, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          localObject = URLDrawableHelper.a((String)localObject, localDrawable1, localDrawable2);
        }
        else
        {
          localObject = EmosmUtils.b(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          continue;
          paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130841350);
        }
      }
      else
      {
        str = "更新";
      }
    }
    for (;;)
    {
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(str);
      this.h = 2;
      if (!a()) {
        break;
      }
      c();
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5))
      {
        d();
        if (this.f != 2) {
          str = "立即开通";
        }
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
      {
        str = "查看详情";
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "onAdapterSelected emotionpkg = null");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 4) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 5)) {
        break;
      }
      d();
    } while (this.f != 2);
    while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
    {
      EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
      if ((localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId) >= 0.0F) || (!EmoticonUtils.b())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "wifi auto download emotion , epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      }
      localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, false, this.g);
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("取消");
        this.h = 1;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
      return;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.b)
    {
      if (paramInt == 0) {
        return 0;
      }
      return 1;
    }
    return super.getItemViewType(paramInt);
  }
  
  public int getViewTypeCount()
  {
    if (this.b) {
      return 2;
    }
    return super.getViewTypeCount();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramMessage.obj;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "packageDownloadEnd view is null");
    }
    do
    {
      do
      {
        do
        {
          return true;
        } while ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)) || (localEmoticonPackage == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId)));
        switch (paramMessage.what)
        {
        default: 
          return true;
        case 100: 
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage refreshCover epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          }
          paramMessage = EmosmUtils.a(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        }
      } while (paramMessage == null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
      return true;
      paramMessage = EmojiManager.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), localEmoticonPackage.epId);
    } while (paramMessage == null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage refreshprogress epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    int i = (int)paramMessage.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("取消");
    this.h = 1;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(i);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgressColor(-16745986);
    return true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage packageDownloadEnd epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    if (this.b) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("更新");
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("下载");
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
    this.h = 2;
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131364483) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 4) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 5)) {
        break;
      }
      d();
      if (this.f == 2) {
        break label284;
      }
      Object localObject = "mvip.g.a.bq_" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
      paramView = "!vip";
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5) {
        paramView = "!svip";
      }
      paramView = "http://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + paramView + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 4813);
      }
    } while (this.jdField_a_of_type_Boolean);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
    return;
    if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 4) {}
      for (boolean bool = true;; bool = false)
      {
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, bool);
        return;
      }
    }
    label284:
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */
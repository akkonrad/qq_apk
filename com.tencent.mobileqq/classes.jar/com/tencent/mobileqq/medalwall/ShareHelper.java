package com.tencent.mobileqq.medalwall;

import aefx;
import aefy;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneShareManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ShareHelper
{
  Context jdField_a_of_type_AndroidContentContext;
  public Bitmap a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ShareActionSheetBuilder a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f = "";
  
  public ShareHelper(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Object localObject3;
    if (paramDrawable == null)
    {
      localObject3 = null;
      return localObject3;
    }
    Object localObject1;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject1 = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject1).getBitmap() != null) {
        return ((BitmapDrawable)localObject1).getBitmap();
      }
    }
    for (;;)
    {
      try
      {
        if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
          continue;
        }
        localObject1 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Rect localRect;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ShareHelper", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        Object localObject2 = null;
        continue;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject3 = new Canvas((Bitmap)localObject1);
      localRect = paramDrawable.copyBounds();
      paramDrawable.setBounds(0, 0, ((Canvas)localObject3).getWidth(), ((Canvas)localObject3).getHeight());
      paramDrawable.draw((Canvas)localObject3);
      paramDrawable.setBounds(localRect);
      return localObject1;
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
  }
  
  public static String a(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    return new SimpleDateFormat("yyyyMMdd").format(paramLong);
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(Base64.encodeToString(paramString.getBytes(), 3).replace("=", ""));
    char c1 = localStringBuilder.charAt(0);
    localStringBuilder.deleteCharAt(0);
    localStringBuilder.append(c1);
    if (QLog.isColorLevel()) {
      QLog.i("ShareHelper", 4, "encodeOne src:" + Base64.encodeToString(paramString.getBytes(), 0) + " dst:" + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramArrayOfString[i] = a(paramArrayOfString[i]);
      i += 1;
    }
    return b(paramArrayOfString);
  }
  
  private void a()
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(114).a(this.jdField_b_of_type_JavaLangString).c(this.jdField_a_of_type_JavaLangString).a();
    localAbsShareMsg.mSourceName = this.e;
    localAbsShareMsg.mSourceAction = "web";
    localAbsShareMsg.mSourceUrl = this.f;
    Object localObject = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject).a(this.d, this.jdField_b_of_type_JavaLangString, this.c);
    localAbsShareMsg.addItem((AbsStructMsgElement)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("forward_type", -3);
    ((Intent)localObject).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
    ((Intent)localObject).putExtra("forwardDirect", true);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
  }
  
  private boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.e));
  }
  
  private List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430108);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430114);
    localActionSheetItem.jdField_b_of_type_Int = 2130838337;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
    localActionSheetItem.jdField_b_of_type_Int = 2130838340;
    localActionSheetItem.c = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430127);
    localActionSheetItem.jdField_b_of_type_Int = 2130838334;
    localActionSheetItem.c = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private static String b(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int k;
    for (int i = 0; j < paramArrayOfString.length; i = k)
    {
      k = i;
      if (paramArrayOfString[j].length() > i) {
        k = paramArrayOfString[j].length();
      }
      j += 1;
    }
    j = 0;
    while (j < i)
    {
      k = 0;
      while (k < paramArrayOfString.length)
      {
        if (paramArrayOfString[k].length() > j) {
          localStringBuilder.append(paramArrayOfString[k].charAt(j));
        }
        k += 1;
      }
      j += 1;
    }
    return a(localStringBuilder.toString());
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.d)) {
      localArrayList.add(this.d);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("desc", this.c);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("url", this.jdField_a_of_type_JavaLangString);
    localBundle.putStringArrayList("image_url", localArrayList);
    QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, null);
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    WXShareHelper.a().d(String.valueOf(l), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c, this.jdField_a_of_type_JavaLangString);
  }
  
  private void d()
  {
    long l = System.currentTimeMillis();
    WXShareHelper.a().c(String.valueOf(l), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!a()) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "分享失败", 0).a();
    }
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
        {
          aefx localaefx = new aefx(this);
          paramOnDismissListener = new aefy(this, paramOnDismissListener);
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder((Activity)this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433100));
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(this.jdField_a_of_type_AndroidContentContext));
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(localaefx);
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(paramOnDismissListener);
        }
        try
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a().isShowing())
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
            return;
          }
        }
        catch (Exception paramOnDismissListener) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramOnDismissListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.ShareHelper
 * JD-Core Version:    0.7.0.1
 */
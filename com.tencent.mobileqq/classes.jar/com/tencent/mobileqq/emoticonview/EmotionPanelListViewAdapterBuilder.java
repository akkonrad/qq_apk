package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class EmotionPanelListViewAdapterBuilder
{
  private static EmotionPanelListViewAdapterBuilder a;
  
  public static EmotionPanelListViewAdapterBuilder a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new EmotionPanelListViewAdapterBuilder();
      }
      return a;
    }
    finally {}
  }
  
  public BaseEmotionAdapter a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListViewAdapterBuilder", 2, "getAdapter panelType = " + paramInt2);
    }
    switch (paramInt2)
    {
    case 10: 
    case 11: 
    default: 
      return null;
    case 1: 
      return new SystemAndEmojiAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback, paramBaseChatPie, paramInt4);
    case 6: 
      return new BigEmotionDownloadedAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramBaseChatPie, paramInt4);
    case 8: 
      return new BigEmotionUpdateAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 7: 
      return new EmotionDownloadOrInvalidAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 4: 
      return new FavoriteEmotionAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback, paramBaseChatPie);
    case 5: 
      return new MagicFaceAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 3: 
      return new RecommendEmotionAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback, paramInt4, paramBoolean);
    case 2: 
      return new SmallEmotionDownloadedAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramBaseChatPie, paramInt4);
    case 9: 
      return new SmallEmotionUpdateAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    }
    return new EmotionCompleteInvalidAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListViewAdapterBuilder
 * JD-Core Version:    0.7.0.1
 */
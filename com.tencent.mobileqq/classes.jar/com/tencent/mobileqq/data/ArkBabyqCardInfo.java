package com.tencent.mobileqq.data;

import abts;
import abtt;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkRecommendController;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class ArkBabyqCardInfo
  implements ArkAdapterItemInterface
{
  public final String TAG = "ArkBabyqCardInfo";
  public String appDesc;
  public String appIntent;
  public String appMinVersion;
  public String appName;
  public String appView;
  public String compatibleText;
  public String config;
  public String extra;
  public ArkAioContainerWrapper mArkBabyqContainer;
  public WeakReference mBabyQReplyMsg;
  public LinkedList mExtendedArkBabyqCardList;
  public String metaList;
  public String promptText;
  
  public ArkBabyqCardInfo(MessageForArkBabyqReply paramMessageForArkBabyqReply)
  {
    reset();
    this.mBabyQReplyMsg = new WeakReference(paramMessageForArkBabyqReply);
  }
  
  public void attachArkView(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, int paramInt)
  {
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842247);
    if (this.mArkBabyqContainer == null)
    {
      this.mArkBabyqContainer = new ArkAioContainerWrapper();
      this.mArkBabyqContainer.a(paramArkHorizontalListViewAdapter);
      localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      ArkAppDataReport.d((QQAppInterface)localObject1, this.appName);
      if ((this.mBabyQReplyMsg != null) && (this.mBabyQReplyMsg.get() != null))
      {
        localObject2 = (MessageForArkBabyqReply)this.mBabyQReplyMsg.get();
        if (localObject1 != null) {
          ((ArkAppHandler)((QQAppInterface)localObject1).a(95)).a(((MessageForArkBabyqReply)localObject2).arkSearchType, 0, 1, this.extra, ((MessageForArkBabyqReply)localObject2).arkMsgId, this.appName, this.appView, null, 0, 0);
        }
      }
    }
    Object localObject1 = new ArkBabyqCardInfo.Config();
    ((ArkBabyqCardInfo.Config)localObject1).fromString(this.config);
    if ((((ArkBabyqCardInfo.Config)localObject1).autoSize != null) && (((ArkBabyqCardInfo.Config)localObject1).autoSize.intValue() == 1)) {}
    localObject1 = this.mArkBabyqContainer;
    ((ArkAioContainerWrapper)localObject1).a(this.appName, this.appView, this.appMinVersion, this.metaList, paramArkHorizontalListViewAdapter.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, this, paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((ArkAioContainerWrapper)localObject1).setFixSize(BaseChatItemLayout.d, BaseChatItemLayout.d);
    ((ArkAioContainerWrapper)localObject1).setMaxSize(BaseChatItemLayout.d, BaseChatItemLayout.d);
    ((ArkAioContainerWrapper)localObject1).setMinSize(BaseChatItemLayout.d * 7 / 10, BaseChatItemLayout.d);
    localObject1 = new abts(this, paramItemViewHolder, paramArkHorizontalListViewAdapter, (ArkAioContainerWrapper)localObject1, paramInt);
    Object localObject2 = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ArkAppView localArkAppView = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ((ArkViewImplement.ArkViewInterface)localObject2).setClipRadius(15.0F);
    ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(1);
    localArkAppView.a(this.mArkBabyqContainer, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
    ((ArkViewImplement.ArkViewInterface)localObject2).setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    ((ArkViewImplement.ArkViewInterface)localObject2).setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    ((ArkViewImplement.ArkViewInterface)localObject2).setLoadCallback((ArkViewImplement.LoadCallback)localObject1);
    if (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    }
    paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setCallback(new abtt(this));
    paramItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void clickTail(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, Context paramContext) {}
  
  public void destroyContainerByRemove()
  {
    doOnEvent(2);
  }
  
  public void doOnEvent(int paramInt)
  {
    if (this.mExtendedArkBabyqCardList != null)
    {
      Iterator localIterator = this.mExtendedArkBabyqCardList.iterator();
      while (localIterator.hasNext())
      {
        ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)localIterator.next();
        if (localArkBabyqCardInfo != null) {
          localArkBabyqCardInfo.doOnEvent(paramInt);
        }
      }
    }
    if (this.mArkBabyqContainer != null)
    {
      this.mArkBabyqContainer.doOnEvent(paramInt);
      if (paramInt == 2) {
        this.mArkBabyqContainer = null;
      }
    }
  }
  
  public ArkAdapterItemInterface extendArkCardByOpen(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    if (this.mArkBabyqContainer == paramArkAppContainer) {
      if ((this.mBabyQReplyMsg == null) || (this.mBabyQReplyMsg.get() == null)) {
        break label167;
      }
    }
    label167:
    for (Object localObject = (MessageForArkBabyqReply)this.mBabyQReplyMsg.get();; localObject = null)
    {
      paramArkAppContainer = paramArkAppContainer.getAppName();
      if ((localObject != null) && ((((MessageForArkBabyqReply)localObject).getArkBabyqCardCount() >= ArkRecommendController.f) || ((!((MessageForArkBabyqReply)localObject).isSingleApp) && (((MessageForArkBabyqReply)localObject).getArkBabyqCardCountForApp(paramArkAppContainer) >= ArkRecommendController.g)))) {
        return null;
      }
      localObject = new ArkBabyqCardInfo((MessageForArkBabyqReply)localObject);
      ((ArkBabyqCardInfo)localObject).appName = paramArkAppContainer;
      ((ArkBabyqCardInfo)localObject).appView = paramString1;
      ((ArkBabyqCardInfo)localObject).appMinVersion = this.appMinVersion;
      ((ArkBabyqCardInfo)localObject).metaList = paramString2;
      ((ArkBabyqCardInfo)localObject).config = this.config;
      ((ArkBabyqCardInfo)localObject).extra = this.extra;
      if (this.mExtendedArkBabyqCardList == null) {
        this.mExtendedArkBabyqCardList = new LinkedList();
      }
      this.mExtendedArkBabyqCardList.add(0, localObject);
      return localObject;
    }
  }
  
  public boolean fromAppXml(String paramString)
  {
    reset();
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.appName = paramString.optString("name");
      this.appIntent = paramString.optString("intent");
      this.appView = paramString.optString("view");
      this.appDesc = paramString.optString("desc");
      this.appMinVersion = paramString.optString("ver");
      this.promptText = paramString.optString("prompt");
      this.metaList = paramString.optString("meta");
      this.config = paramString.optString("config");
      this.extra = paramString.optString("extra");
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.appName;
    arrayOfString[1] = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(this.appName, null);
    return arrayOfString;
  }
  
  public int getArkBabyqCardCount()
  {
    int j;
    if (this.mExtendedArkBabyqCardList != null)
    {
      Iterator localIterator = this.mExtendedArkBabyqCardList.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label57;
      }
      ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)localIterator.next();
      if (localArkBabyqCardInfo == null) {
        break label61;
      }
      i = localArkBabyqCardInfo.getArkBabyqCardCount() + i;
    }
    label57:
    label61:
    for (;;)
    {
      break;
      j = 0;
      return j + 1;
    }
  }
  
  public int getArkBabyqCardCountForApp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i;
    int j;
    if (this.mExtendedArkBabyqCardList != null)
    {
      Iterator localIterator = this.mExtendedArkBabyqCardList.iterator();
      i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label81;
      }
      ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)localIterator.next();
      if ((localArkBabyqCardInfo == null) || (!paramString.equals(localArkBabyqCardInfo.appName))) {
        break label100;
      }
      i += localArkBabyqCardInfo.getArkBabyqCardCount();
    }
    label81:
    label100:
    for (;;)
    {
      break;
      j = 0;
      i = j;
      if (paramString.equals(this.appName)) {
        i = j + 1;
      }
      return i;
    }
  }
  
  public void reset()
  {
    this.promptText = null;
    this.appName = null;
    this.appIntent = null;
    this.appDesc = null;
    this.appView = null;
    this.appMinVersion = null;
    this.metaList = null;
    this.config = null;
    this.compatibleText = null;
    this.extra = null;
  }
  
  /* Error */
  public String toAppXml()
  {
    // Byte code:
    //   0: new 319	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 384	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 81	com/tencent/mobileqq/data/ArkBabyqCardInfo:appName	Ljava/lang/String;
    //   12: ifnull +15 -> 27
    //   15: aload_1
    //   16: ldc_w 324
    //   19: aload_0
    //   20: getfield 81	com/tencent/mobileqq/data/ArkBabyqCardInfo:appName	Ljava/lang/String;
    //   23: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   26: pop
    //   27: aload_0
    //   28: getfield 332	com/tencent/mobileqq/data/ArkBabyqCardInfo:appIntent	Ljava/lang/String;
    //   31: ifnull +15 -> 46
    //   34: aload_1
    //   35: ldc_w 330
    //   38: aload_0
    //   39: getfield 332	com/tencent/mobileqq/data/ArkBabyqCardInfo:appIntent	Ljava/lang/String;
    //   42: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   45: pop
    //   46: aload_0
    //   47: getfield 338	com/tencent/mobileqq/data/ArkBabyqCardInfo:appDesc	Ljava/lang/String;
    //   50: ifnull +15 -> 65
    //   53: aload_1
    //   54: ldc_w 336
    //   57: aload_0
    //   58: getfield 338	com/tencent/mobileqq/data/ArkBabyqCardInfo:appDesc	Ljava/lang/String;
    //   61: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   64: pop
    //   65: aload_0
    //   66: getfield 109	com/tencent/mobileqq/data/ArkBabyqCardInfo:appView	Ljava/lang/String;
    //   69: ifnull +15 -> 84
    //   72: aload_1
    //   73: ldc_w 334
    //   76: aload_0
    //   77: getfield 109	com/tencent/mobileqq/data/ArkBabyqCardInfo:appView	Ljava/lang/String;
    //   80: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_0
    //   85: getfield 133	com/tencent/mobileqq/data/ArkBabyqCardInfo:appMinVersion	Ljava/lang/String;
    //   88: ifnull +15 -> 103
    //   91: aload_1
    //   92: ldc_w 340
    //   95: aload_0
    //   96: getfield 133	com/tencent/mobileqq/data/ArkBabyqCardInfo:appMinVersion	Ljava/lang/String;
    //   99: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   102: pop
    //   103: aload_0
    //   104: getfield 344	com/tencent/mobileqq/data/ArkBabyqCardInfo:promptText	Ljava/lang/String;
    //   107: ifnull +15 -> 122
    //   110: aload_1
    //   111: ldc_w 342
    //   114: aload_0
    //   115: getfield 344	com/tencent/mobileqq/data/ArkBabyqCardInfo:promptText	Ljava/lang/String;
    //   118: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_0
    //   123: getfield 104	com/tencent/mobileqq/data/ArkBabyqCardInfo:extra	Ljava/lang/String;
    //   126: ifnull +15 -> 141
    //   129: aload_1
    //   130: ldc_w 348
    //   133: aload_0
    //   134: getfield 104	com/tencent/mobileqq/data/ArkBabyqCardInfo:extra	Ljava/lang/String;
    //   137: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   140: pop
    //   141: aload_0
    //   142: getfield 135	com/tencent/mobileqq/data/ArkBabyqCardInfo:metaList	Ljava/lang/String;
    //   145: astore_2
    //   146: aload_2
    //   147: ifnull +22 -> 169
    //   150: aload_1
    //   151: ldc_w 346
    //   154: new 319	org/json/JSONObject
    //   157: dup
    //   158: aload_0
    //   159: getfield 135	com/tencent/mobileqq/data/ArkBabyqCardInfo:metaList	Ljava/lang/String;
    //   162: invokespecial 322	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   165: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload_0
    //   170: getfield 117	com/tencent/mobileqq/data/ArkBabyqCardInfo:config	Ljava/lang/String;
    //   173: astore_2
    //   174: aload_2
    //   175: ifnull +22 -> 197
    //   178: aload_1
    //   179: ldc_w 347
    //   182: new 319	org/json/JSONObject
    //   185: dup
    //   186: aload_0
    //   187: getfield 117	com/tencent/mobileqq/data/ArkBabyqCardInfo:config	Ljava/lang/String;
    //   190: invokespecial 322	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   193: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   196: pop
    //   197: aload_1
    //   198: invokevirtual 391	org/json/JSONObject:toString	()Ljava/lang/String;
    //   201: areturn
    //   202: astore_2
    //   203: ldc 31
    //   205: new 393	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 396
    //   215: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_2
    //   219: invokevirtual 403	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   222: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 408	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: goto -62 -> 169
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 409	org/json/JSONException:printStackTrace	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_2
    //   242: ldc 31
    //   244: new 393	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   251: ldc_w 411
    //   254: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_2
    //   258: invokevirtual 403	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   261: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 408	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: goto -73 -> 197
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 351	java/lang/Exception:printStackTrace	()V
    //   278: goto -39 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	ArkBabyqCardInfo
    //   7	191	1	localJSONObject	JSONObject
    //   234	2	1	localJSONException	org.json.JSONException
    //   273	2	1	localException1	Exception
    //   145	30	2	str	String
    //   202	17	2	localException2	Exception
    //   241	17	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   150	169	202	java/lang/Exception
    //   0	27	234	org/json/JSONException
    //   27	46	234	org/json/JSONException
    //   46	65	234	org/json/JSONException
    //   65	84	234	org/json/JSONException
    //   84	103	234	org/json/JSONException
    //   103	122	234	org/json/JSONException
    //   122	141	234	org/json/JSONException
    //   141	146	234	org/json/JSONException
    //   150	169	234	org/json/JSONException
    //   169	174	234	org/json/JSONException
    //   178	197	234	org/json/JSONException
    //   197	202	234	org/json/JSONException
    //   203	231	234	org/json/JSONException
    //   242	270	234	org/json/JSONException
    //   178	197	241	java/lang/Exception
    //   0	27	273	java/lang/Exception
    //   27	46	273	java/lang/Exception
    //   46	65	273	java/lang/Exception
    //   65	84	273	java/lang/Exception
    //   84	103	273	java/lang/Exception
    //   103	122	273	java/lang/Exception
    //   122	141	273	java/lang/Exception
    //   141	146	273	java/lang/Exception
    //   169	174	273	java/lang/Exception
    //   197	202	273	java/lang/Exception
    //   203	231	273	java/lang/Exception
    //   242	270	273	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkBabyqCardInfo
 * JD-Core Version:    0.7.0.1
 */
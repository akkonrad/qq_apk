package com.tencent.mobileqq.redtouch;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RedTouchUtils
{
  public static RedAppInfo a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    int j = 0;
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchUtils BusinessInfo2RedAppInfo", 2, "appInfo is null ");
      }
      return null;
    }
    RedAppInfo localRedAppInfo = new RedAppInfo();
    localRedAppInfo.a(paramAppInfo.uiAppId.get());
    localRedAppInfo.b(paramAppInfo.iNewFlag.get());
    localRedAppInfo.c(paramAppInfo.type.get());
    localRedAppInfo.a(paramAppInfo.buffer.get());
    localRedAppInfo.b(paramAppInfo.path.get());
    localRedAppInfo.d(paramAppInfo.modify_ts.get());
    localRedAppInfo.e(paramAppInfo.appset.get());
    localRedAppInfo.f(paramAppInfo.num.get());
    localRedAppInfo.c(paramAppInfo.icon_url.get());
    localRedAppInfo.h(paramAppInfo.icon_type.get());
    localRedAppInfo.g(paramAppInfo.icon_flag.get());
    localRedAppInfo.i(paramAppInfo.push_red_ts.get());
    localRedAppInfo.j(paramAppInfo.mission_level.get());
    Object localObject = new ArrayList();
    int i;
    if ((paramAppInfo.missions.get() != null) && (paramAppInfo.missions.get().size() > 0))
    {
      i = 0;
      while (i < paramAppInfo.missions.get().size())
      {
        ((ArrayList)localObject).add(paramAppInfo.missions.get().get(i));
        i += 1;
      }
    }
    localRedAppInfo.a((ArrayList)localObject);
    localObject = new RedDisplayInfo();
    RedTypeInfo localRedTypeInfo = new RedTypeInfo();
    ArrayList localArrayList = new ArrayList();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get()).tab_display_info.get();
    paramAppInfo = ((BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get()).red_type_info.get();
    if (localRedTypeInfo1 != null)
    {
      localRedTypeInfo.setRed_content(localRedTypeInfo1.red_content.get());
      localRedTypeInfo.setRed_desc(localRedTypeInfo1.red_desc.get());
      localRedTypeInfo.setRed_priority(localRedTypeInfo1.red_priority.get());
      localRedTypeInfo.setRed_type(localRedTypeInfo1.red_type.get());
    }
    ((RedDisplayInfo)localObject).a(localRedTypeInfo);
    if ((paramAppInfo != null) && (paramAppInfo.size() > 0))
    {
      i = j;
      while (i < paramAppInfo.size())
      {
        localRedTypeInfo = new RedTypeInfo();
        localRedTypeInfo.setRed_content(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i)).red_content.get());
        localRedTypeInfo.setRed_desc(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i)).red_desc.get());
        localRedTypeInfo.setRed_priority(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i)).red_priority.get());
        localRedTypeInfo.setRed_type(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i)).red_type.get());
        localArrayList.add(localRedTypeInfo);
        i += 1;
      }
    }
    ((RedDisplayInfo)localObject).a(localArrayList);
    localRedAppInfo.a((RedDisplayInfo)localObject);
    return localRedAppInfo;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(RedAppInfo paramRedAppInfo)
  {
    if (paramRedAppInfo == null) {
      return null;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.uiAppId.set(paramRedAppInfo.a());
    localAppInfo.iNewFlag.set(paramRedAppInfo.b());
    localAppInfo.type.set(paramRedAppInfo.c());
    localAppInfo.buffer.set(paramRedAppInfo.a());
    localAppInfo.path.set(paramRedAppInfo.b());
    localAppInfo.modify_ts.set(paramRedAppInfo.d());
    localAppInfo.missions.set(paramRedAppInfo.a());
    localAppInfo.appset.set(paramRedAppInfo.e());
    localAppInfo.num.set(paramRedAppInfo.f());
    localAppInfo.icon_url.set(paramRedAppInfo.c());
    localAppInfo.icon_flag.set(paramRedAppInfo.g());
    localAppInfo.icon_type.set(paramRedAppInfo.h());
    localAppInfo.push_red_ts.set(paramRedAppInfo.i());
    localAppInfo.mission_level.set(paramRedAppInfo.j());
    BusinessInfoCheckUpdate.RedDisplayInfo localRedDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
    Object localObject = paramRedAppInfo.a();
    paramRedAppInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    RedTypeInfo localRedTypeInfo;
    if (localObject != null)
    {
      localRedTypeInfo = ((RedDisplayInfo)localObject).a();
      paramRedAppInfo.red_content.set(localRedTypeInfo.getRed_content());
      paramRedAppInfo.red_desc.set(localRedTypeInfo.getRed_desc());
      paramRedAppInfo.red_priority.set(localRedTypeInfo.getRed_priority());
      paramRedAppInfo.red_type.set(localRedTypeInfo.getRed_type());
    }
    localRedDisplayInfo.tab_display_info.set(paramRedAppInfo);
    paramRedAppInfo = new ArrayList();
    if (localObject != null)
    {
      localObject = ((RedDisplayInfo)localObject).a();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          localRedTypeInfo = (RedTypeInfo)((List)localObject).get(i);
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo1.red_content.set(localRedTypeInfo.getRed_content());
          localRedTypeInfo1.red_desc.set(localRedTypeInfo.getRed_desc());
          localRedTypeInfo1.red_priority.set(localRedTypeInfo.getRed_priority());
          localRedTypeInfo1.red_type.set(localRedTypeInfo.getRed_type());
          paramRedAppInfo.add(localRedTypeInfo1);
          i += 1;
        }
      }
    }
    localRedDisplayInfo.red_type_info.set(paramRedAppInfo);
    localAppInfo.red_display_info.set(localRedDisplayInfo);
    return localAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchUtils
 * JD-Core Version:    0.7.0.1
 */
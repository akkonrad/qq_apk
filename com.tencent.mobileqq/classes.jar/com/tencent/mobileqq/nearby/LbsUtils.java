package com.tencent.mobileqq.nearby;

import appoint.define.appoint_define.Cell;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.Wifi;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LbsUtils
{
  public static appoint_define.LBSInfo a(String paramString)
  {
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a == 0.0D) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b == 0.0D)) {
      SosoInterface.a(60000L, paramString);
    }
    for (paramString = SosoInterface.a();; paramString = (String)localObject1)
    {
      if (paramString != null)
      {
        localObject1 = new appoint_define.LBSInfo();
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if (paramString.b != null)
        {
          localObject2 = paramString.b.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new appoint_define.Wifi();
              ((appoint_define.Wifi)localObject4).uint64_mac.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long);
              ((appoint_define.Wifi)localObject4).int32_rssi.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int);
              ((appoint_define.LBSInfo)localObject1).rpt_msg_wifis.add((MessageMicro)localObject4);
            }
          }
        }
        if (paramString.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject2 = paramString.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject4 = new appoint_define.Cell();
              ((appoint_define.Cell)localObject4).int32_cellid.set(((SosoInterface.SosoCell)localObject3).d);
              ((appoint_define.Cell)localObject4).int32_lac.set(((SosoInterface.SosoCell)localObject3).c);
              ((appoint_define.Cell)localObject4).int32_rssi.set(((SosoInterface.SosoCell)localObject3).e);
              ((appoint_define.Cell)localObject4).int32_mcc.set(((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int);
              ((appoint_define.Cell)localObject4).int32_mnc.set(((SosoInterface.SosoCell)localObject3).b);
              ((appoint_define.LBSInfo)localObject1).rpt_msg_cells.add((MessageMicro)localObject4);
            }
          }
        }
        if (paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)
        {
          localObject2 = new appoint_define.GPS();
          ((appoint_define.GPS)localObject2).int32_lon.set((int)(paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D));
          ((appoint_define.GPS)localObject2).int32_lat.set((int)(paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D));
          ((appoint_define.GPS)localObject2).int32_type.set(0);
          ((appoint_define.LBSInfo)localObject1).msg_gps.set((MessageMicro)localObject2);
          return localObject1;
        }
      }
      else
      {
        NearbyUtils.a("getLbsInfo", new Object[] { "lbs is null" });
        return null;
      }
      return localObject1;
    }
  }
  
  public static String a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    Object localObject;
    try
    {
      localJSONObject.put("lat", (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D));
      localJSONObject.put("lon", (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D));
      localJSONArray = new JSONArray();
      localObject = paramSosoLbsInfo.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)((Iterator)localObject).next();
        localJSONArray.put(new JSONObject().put("mac", localSosoWifi.jdField_a_of_type_Long).put("rssi", localSosoWifi.jdField_a_of_type_Int));
        continue;
        return localJSONObject.toString();
      }
    }
    catch (JSONException paramSosoLbsInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsUtils", 2, "lbsInfo to json exception", paramSosoLbsInfo);
      }
    }
    for (;;)
    {
      localJSONObject.put("wifis", localJSONArray);
      localJSONArray = new JSONArray();
      paramSosoLbsInfo = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramSosoLbsInfo.hasNext())
      {
        localObject = (SosoInterface.SosoCell)paramSosoLbsInfo.next();
        localJSONArray.put(new JSONObject().put("mcc", ((SosoInterface.SosoCell)localObject).jdField_a_of_type_Int).put("mnc", ((SosoInterface.SosoCell)localObject).b).put("lac", ((SosoInterface.SosoCell)localObject).c).put("cellid", ((SosoInterface.SosoCell)localObject).d).put("rssi", ((SosoInterface.SosoCell)localObject).e));
      }
      localJSONObject.put("cells", localJSONArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.LbsUtils
 * JD-Core Version:    0.7.0.1
 */
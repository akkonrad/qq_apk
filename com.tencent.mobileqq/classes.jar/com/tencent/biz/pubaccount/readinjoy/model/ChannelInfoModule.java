package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x69fParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import lqr;
import lqs;
import lqt;
import lqu;
import lqv;
import lqw;
import lqx;
import lqy;
import lqz;
import tencent.im.oidb.cmd0x69e.oidb_cmd0x69e.ReqBody;
import tencent.im.oidb.cmd0x69e.oidb_cmd0x69e.RspBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;
import tencent.im.oidb.cmd0x8f5.oidb_cmd0x8f5.ReqBody;
import tencent.im.oidb.cmd0x8f5.oidb_cmd0x8f5.RspBody;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.ChildChannelStatus;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.ReqBody;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.RspBody;

public class ChannelInfoModule
  extends ReadInJoyEngineModule
{
  private int jdField_a_of_type_Int;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private LinkedHashMap jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  public ChannelInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void a(Integer paramInteger)
  {
    ChannelInfo localChannelInfo = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if (localChannelInfo != null)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramInteger);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lqw(this, localChannelInfo));
    }
  }
  
  private void a(boolean paramBoolean1, List paramList1, List paramList2, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lqv(this, paramBoolean1, paramBoolean2, paramList1, paramList2));
  }
  
  private boolean a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (paramChannelInfo == null) {
      return false;
    }
    ChannelInfo localChannelInfo = paramChannelInfo.clone();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelInfo.mChannelID), localChannelInfo);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lqx(this, localChannelInfo));
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ChannelInfo.class, true, null, null, null, null, null, null);
    if (localObject == null)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((ChannelInfo)((Iterator)localObject).next(), false);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public int a()
  {
    List localList = b();
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new lqt(this, localList));
      return 0;
    }
    b();
    return 1;
  }
  
  public ChannelInfo a(Integer paramInteger)
  {
    c();
    return (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
  }
  
  protected ToServiceMsg a(ReadInJoyRequestParams.Request0x69fParams paramRequest0x69fParams)
  {
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l);
    if (paramRequest0x69fParams.jdField_a_of_type_Boolean) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_all_channel_list.set(1);
    }
    if (paramRequest0x69fParams.jdField_b_of_type_Boolean) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_my_channel_id_list.set(1);
    }
    if (paramRequest0x69fParams.j) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_video_channel.set(1);
    }
    if (paramRequest0x69fParams.k) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_local_channel_id.set(1);
    }
    if ((ReadInJoyUtils.a()) && (!paramRequest0x69fParams.l))
    {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_channel.set(1);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_word.set(1);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_jump_url.set(1);
    }
    for (;;)
    {
      if (paramRequest0x69fParams.i) {
        ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_recomm_channel.set(1);
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_important.set(paramRequest0x69fParams.jdField_b_of_type_Int);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_id.set(paramRequest0x69fParams.jdField_c_of_type_Int);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_cover.set(paramRequest0x69fParams.jdField_d_of_type_Int);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_seq.set(paramRequest0x69fParams.jdField_e_of_type_Int);
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).getAttributes().put(c, Integer.valueOf(paramRequest0x69fParams.jdField_a_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put("debug", Boolean.valueOf(paramRequest0x69fParams.l));
      return localObject;
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_channel.set(0);
    }
  }
  
  public List a()
  {
    c();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      localObject3 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject3);
      if (((ChannelInfo)localObject3).mShow) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new lqr(this));
    localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add((ChannelInfo)((Iterator)localObject1).next());
    }
    return localObject2;
  }
  
  public List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((ChannelInfo)paramList.next()).mChannelID));
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt3));
    a(paramInt1, paramInt2, localArrayList, true, true);
  }
  
  public void a(int paramInt1, int paramInt2, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = new oidb_cmd0x908.ReqBody();
    ((oidb_cmd0x908.ReqBody)localObject).uint64_uin.set(Long.valueOf(ReadInJoyUtils.a()).longValue());
    ((oidb_cmd0x908.ReqBody)localObject).uint32_parent_channel_id.set(paramInt1);
    if (paramBoolean1)
    {
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_header_url.set(1);
      label54:
      if (!paramBoolean2) {
        break label184;
      }
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_subscription_count.set(1);
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        ((oidb_cmd0x908.ReqBody)localObject).rpt_child_channel_list.set(paramList);
      }
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0x908", 2312, 0, ((oidb_cmd0x908.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).getAttributes().put("channelType", Integer.valueOf(paramInt2));
      a((ToServiceMsg)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChannelInfoModule", 2, String.format("getSubChannelStatus(): send 0x908 req, parentChannelID =%s , childChannelIDList=%s", new Object[] { Integer.valueOf(paramInt1), Arrays.toString(paramList.toArray()) }));
      return;
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_header_url.set(0);
      break label54;
      label184:
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_subscription_count.set(0);
    }
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    a(paramChannelInfo, true);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x69f")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x69e"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x908"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8f5"));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(List paramList)
  {
    Object localObject = new oidb_cmd0x69e.ReqBody();
    ((oidb_cmd0x69e.ReqBody)localObject).rpt_uint32_channel_ids.set(paramList);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69e", 1694, 0, ((oidb_cmd0x69e.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("channelIDList", paramList);
    a((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new ReadInJoyRequestParams.Request0x69fParams();
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_a_of_type_Int = 4;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_a_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_b_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_c_of_type_Boolean = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_d_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).j = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).k = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_e_of_type_Boolean = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).f = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).g = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).h = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).jdField_b_of_type_Int = 1;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).l = paramBoolean;
    localObject = a((ReadInJoyRequestParams.Request0x69fParams)localObject);
    ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(1));
    a((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt2));
    a(paramBoolean, paramInt1, localArrayList);
  }
  
  public void a(boolean paramBoolean, int paramInt, SparseArray paramSparseArray)
  {
    if (paramSparseArray != null)
    {
      int j = paramSparseArray.size();
      int i = 0;
      while (i < j)
      {
        ChannelInfo localChannelInfo = (ChannelInfo)paramSparseArray.get(paramSparseArray.keyAt(i));
        if (localChannelInfo != null) {
          a(localChannelInfo, true);
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lqs(this, paramBoolean, paramInt, paramSparseArray));
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    oidb_cmd0x8f5.ReqBody localReqBody = new oidb_cmd0x8f5.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(ReadInJoyUtils.a()).longValue());
    if (paramBoolean)
    {
      localReqBody.enum_follow_op.set(0);
      localReqBody.uint32_parent_channel_id.set(paramInt);
      if ((paramList != null) && (paramList.size() > 0)) {
        localReqBody.rpt_child_channel_list.set(paramList);
      }
      a(ReadInJoyOidbHelper.a("OidbSvc.0x8f5", 2293, 0, localReqBody.toByteArray()));
      if (QLog.isColorLevel()) {
        if (paramList != null) {
          break label151;
        }
      }
    }
    label151:
    for (paramList = "null";; paramList = Arrays.toString(paramList.toArray()))
    {
      QLog.d("ChannelInfoModule", 2, String.format("followUnfollow(): send req, follow = %s, parentChannelID =%s , childChannelIDList=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramList }));
      return;
      localReqBody.enum_follow_op.set(1);
      break;
    }
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lqu(this, paramBoolean, paramList));
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    Object localObject1 = new HashMap(paramList.size());
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChannelInfo)((Iterator)localObject2).next();
      ((HashMap)localObject1).put(Integer.valueOf(((ChannelInfo)localObject3).mChannelID), localObject3);
    }
    localObject2 = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject3).next();
      if (((HashMap)localObject1).get(localInteger) == null)
      {
        ((List)localObject2).add(localInteger);
        if (QLog.isColorLevel()) {
          QLog.e("ChannelInfoModule", 2, "saveAllChannelInfoList, channel deleted, channelID=" + localInteger + "channelName=" + ((ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localInteger)).mChannelName);
        }
      }
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      a((Integer)((Iterator)localObject1).next());
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (ChannelInfo)paramList.next();
      localObject2 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(((ChannelInfo)localObject1).mChannelID));
      if (localObject2 == null)
      {
        a((ChannelInfo)localObject1, paramBoolean);
      }
      else if ((!((ChannelInfo)localObject2).mChannelName.equals(((ChannelInfo)localObject1).mChannelName)) || (((ChannelInfo)localObject2).mFontColor != ((ChannelInfo)localObject1).mFontColor) || (((ChannelInfo)localObject2).mFrameColor != ((ChannelInfo)localObject1).mFrameColor) || (!TextUtils.equals(((ChannelInfo)localObject2).mJumpUrl, ((ChannelInfo)localObject1).mJumpUrl)))
      {
        ((ChannelInfo)localObject2).mChannelName = ((ChannelInfo)localObject1).mChannelName;
        ((ChannelInfo)localObject2).mFontColor = ((ChannelInfo)localObject1).mFontColor;
        ((ChannelInfo)localObject2).mFrameColor = ((ChannelInfo)localObject1).mFrameColor;
        ((ChannelInfo)localObject2).mJumpUrl = ((ChannelInfo)localObject1).mJumpUrl;
        a((ChannelInfo)localObject2, paramBoolean);
      }
    }
    return true;
  }
  
  public List b()
  {
    c();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localArrayList.add((ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localInteger));
    }
    return localArrayList;
  }
  
  public void b()
  {
    a(false);
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    oidb_cmd0x69f.RspBody localRspBody = new oidb_cmd0x69f.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    label165:
    boolean bool;
    if (j == 0) {
      if (i == 1)
      {
        if (localRspBody.uint64_uin.has()) {
          localRspBody.uint64_uin.get();
        }
        if (localRspBody.rpt_channel_list.has())
        {
          paramObject = ReadInJoyMSFHandlerUtils.a(localRspBody.rpt_channel_list.get());
          localObject1 = paramObject;
          paramFromServiceMsg = localObject2;
          if (localRspBody.rpt_uint32_my_channel_id_list.has())
          {
            localObject1 = paramObject;
            paramFromServiceMsg = localObject2;
            if (localRspBody.rpt_uint32_my_channel_id_list.get() != null)
            {
              paramFromServiceMsg = new ArrayList(localRspBody.rpt_uint32_my_channel_id_list.size());
              paramFromServiceMsg.addAll(localRspBody.rpt_uint32_my_channel_id_list.get());
              localObject1 = paramObject;
            }
          }
          if (localRspBody.uint32_channel_seq.has()) {
            this.jdField_b_of_type_Int = localRspBody.uint32_channel_seq.get();
          }
          bool = true;
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelInfoModule", 2, "handleGetChannelAndSubscribeList, result=" + j);
      }
      switch (((Integer)paramToServiceMsg.getAttributes().get(c)).intValue())
      {
      default: 
        return;
      }
      a(bool, paramObject, paramFromServiceMsg, ((Boolean)paramToServiceMsg.getAttributes().get("debug")).booleanValue());
      return;
      paramObject = null;
      break;
      localObject1 = null;
      paramFromServiceMsg = localObject2;
      break label165;
      paramObject = null;
      bool = false;
      paramFromServiceMsg = localObject1;
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramList = new ArrayList(paramList);
    paramList.remove(Integer.valueOf(9999));
    c(paramList);
    a(paramList);
    ReadInJoyLogicEngineEventDispatcher.a().b(true, null);
  }
  
  public List c()
  {
    c();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      localObject3 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject3);
      if (((ChannelInfo)localObject3).mShow) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new lqy(this));
    localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add(Integer.valueOf(((ChannelInfo)((Iterator)localObject1).next()).mChannelID));
    }
    return localObject2;
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x69e.RspBody()) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, (List)paramToServiceMsg.getAttributes().get("channelIDList"));
      return;
    }
  }
  
  public void c(List paramList)
  {
    int i = 0;
    if (paramList == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Integer)((Iterator)localObject1).next();
        localObject2 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2);
        if (localObject2 != null)
        {
          ((ChannelInfo)localObject2).mShow = false;
          ((ChannelInfo)localObject2).mSortOrder = 0;
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int j = ((Integer)paramList.next()).intValue();
        localObject1 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(j));
        if (localObject1 != null)
        {
          ((ChannelInfo)localObject1).mShow = true;
          ((ChannelInfo)localObject1).mSortOrder = i;
          i += 1;
        }
      }
      paramList = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Integer)paramList.next();
        localObject1 = (ChannelInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1);
        if (localObject1 != null) {
          a((ChannelInfo)localObject1, true);
        }
      }
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x8f5.RspBody());
    if (QLog.isColorLevel()) {
      QLog.e("ChannelInfoModule", 2, "handle0x8f5FollowUnfollow():  result = " + i);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lqz(this, i));
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    Object localObject = new oidb_cmd0x908.RspBody();
    int i = -1;
    int j = ((Integer)paramToServiceMsg.getAttributes().get("channelType")).intValue();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    boolean bool1;
    if (k == 0)
    {
      if (((oidb_cmd0x908.RspBody)localObject).uint32_parent_channel_id.has()) {
        i = ((oidb_cmd0x908.RspBody)localObject).uint32_parent_channel_id.get();
      }
      if (!((oidb_cmd0x908.RspBody)localObject).rpt_child_channel_status_list.has()) {
        break label481;
      }
      paramFromServiceMsg = ((oidb_cmd0x908.RspBody)localObject).rpt_child_channel_status_list.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label481;
      }
      paramToServiceMsg = new SparseArray(paramFromServiceMsg.size());
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (oidb_cmd0x908.ChildChannelStatus)paramFromServiceMsg.next();
        if (paramObject != null)
        {
          localObject = new ChannelInfo();
          if (paramObject.uint32_status.has())
          {
            if (paramObject.uint32_status.get() > 0)
            {
              bool1 = true;
              label177:
              ((ChannelInfo)localObject).mIsFollowed = bool1;
            }
          }
          else
          {
            if (paramObject.uint32_subscription_count.has()) {
              ((ChannelInfo)localObject).mFollowNum = paramObject.uint32_subscription_count.get();
            }
            if ((paramObject.bytes_channel_header_url.has()) && (paramObject.bytes_channel_header_url.get() != null)) {
              ((ChannelInfo)localObject).mHeaderPicUrl = paramObject.bytes_channel_header_url.get().toStringUtf8();
            }
            if (paramObject.uint32_system_recomm.has())
            {
              if (paramObject.uint32_system_recomm.get() <= 0) {
                break label350;
              }
              bool1 = true;
              label264:
              ((ChannelInfo)localObject).mIsSystemRecomm = bool1;
            }
            if (paramObject.uint32_child_channel_id.has())
            {
              ((ChannelInfo)localObject).mChannelID = paramObject.uint32_child_channel_id.get();
              ((ChannelInfo)localObject).mChannelType = j;
              paramToServiceMsg.append(((ChannelInfo)localObject).mChannelID, localObject);
            }
            if (!paramObject.uint32_is_topic.has()) {
              continue;
            }
            if (paramObject.uint32_is_topic.get() <= 0) {
              break label356;
            }
          }
          label350:
          label356:
          for (bool1 = true;; bool1 = false)
          {
            ((ChannelInfo)localObject).mIsTopic = bool1;
            break;
            bool1 = false;
            break label177;
            bool1 = false;
            break label264;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg == null)
        {
          paramFromServiceMsg = "";
          QLog.d("ChannelInfoModule", 2, String.format("handle0x908GetChildChannelStatus(): parentChannelID = %s, childChannelType = %s, childChannelStatusArray = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramFromServiceMsg }));
        }
      }
      else
      {
        if (k != 0) {
          break label440;
        }
        bool1 = bool2;
        label422:
        a(bool1, i, paramToServiceMsg);
      }
      label440:
      do
      {
        return;
        paramFromServiceMsg = paramToServiceMsg.toString();
        break;
        bool1 = false;
        break label422;
      } while (!QLog.isColorLevel());
      QLog.e("ChannelInfoModule", 2, "handle0x908GetChildChannelStatus(): failed, result = " + k);
      return;
      label481:
      paramToServiceMsg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule
 * JD-Core Version:    0.7.0.1
 */
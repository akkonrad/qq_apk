package cooperation.qzone;

import QMF_PROTOCAL.RetryInfo;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.WupUtil;
import cooperation.qzone.util.ProtocolUtils;

public abstract class QzoneExternalRequest
{
  public static final String FIELD_REFER = "refer";
  public static final String FIELD_UIN = "hostuin";
  public static final int QZONE_BUSSINESS_ID = 1000027;
  public static final String TAIL_NAME = "tail_name";
  private String charset = "utf-8";
  private String deviceTail;
  public long hostUin;
  private long loginUserId;
  public boolean needCompress = true;
  private String refer;
  private RetryInfo retryInfo;
  
  public static JceStruct decode(byte[] paramArrayOfByte, String paramString)
  {
    return ProtocolUtils.a(paramArrayOfByte, paramString);
  }
  
  protected static JceStruct decode(byte[] paramArrayOfByte, String paramString, int[] paramArrayOfInt)
  {
    return ProtocolUtils.a(paramArrayOfByte, paramString, paramArrayOfInt);
  }
  
  public byte[] encode()
  {
    Object localObject1 = getDeviceInfo();
    Object localObject2 = QUA.a();
    long l = getLoginUserId();
    RetryInfo localRetryInfo = (RetryInfo)getRetryInfo();
    localObject1 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = getEncodedUniParameter();
    if (localObject2 != null) {
      return WupUtil.a(((WNSStream)localObject1).pack(MsfSdkUtils.getNextAppSeq(), getCmdString(), (byte[])localObject2, this.needCompress));
    }
    return null;
  }
  
  public String getCharset()
  {
    return this.charset;
  }
  
  public abstract String getCmdString();
  
  public String getDeviceInfo()
  {
    return PlatformInfor.a().b();
  }
  
  public String getDeviceTail()
  {
    return this.deviceTail;
  }
  
  protected byte[] getEncodedUniParameter()
  {
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.setEncodeName("utf8");
    localUniAttribute.put("hostuin", Long.valueOf(getHostUin()));
    String str = uniKey();
    if (!TextUtils.isEmpty(str)) {
      localUniAttribute.put(str, getReq());
    }
    this.refer = getRefer();
    if (!TextUtils.isEmpty(this.refer)) {
      localUniAttribute.put("refer", this.refer);
    }
    str = getDeviceTail();
    if (!TextUtils.isEmpty(str)) {
      localUniAttribute.put("tail_name", str);
    }
    return localUniAttribute.encode();
  }
  
  public long getHostUin()
  {
    return this.hostUin;
  }
  
  public long getLoginUserId()
  {
    return this.loginUserId;
  }
  
  public String getRefer()
  {
    return this.refer;
  }
  
  public abstract JceStruct getReq();
  
  public Object getRetryInfo()
  {
    return this.retryInfo;
  }
  
  public void setCharset(String paramString)
  {
    this.charset = paramString;
  }
  
  public void setDeviceTail(String paramString)
  {
    this.deviceTail = paramString;
  }
  
  public void setHostUin(long paramLong)
  {
    this.hostUin = paramLong;
  }
  
  public void setLoginUserId(long paramLong)
  {
    this.loginUserId = paramLong;
  }
  
  public void setRefer(String paramString)
  {
    this.refer = paramString;
  }
  
  public abstract String uniKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneExternalRequest
 * JD-Core Version:    0.7.0.1
 */
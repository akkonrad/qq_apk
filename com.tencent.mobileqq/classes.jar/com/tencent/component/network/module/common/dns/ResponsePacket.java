package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ResponsePacket
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private DNSInput jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput;
  private String jdField_a_of_type_JavaLangString = "";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[64];
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private ArrayList[] jdField_a_of_type_ArrayOfJavaUtilArrayList;
  private int b;
  
  public ResponsePacket(DNSInput paramDNSInput, String paramString)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput = paramDNSInput;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfJavaUtilArrayList = new ArrayList[4];
    a();
    a(this.b);
    b();
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    int j = 0;
    int i = 0;
    while (i == 0)
    {
      int k = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.c();
      switch (k & 0xC0)
      {
      default: 
        throw new WireParseException("bad label type");
      case 0: 
        if (k == 0)
        {
          i = 1;
        }
        else
        {
          this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.a(this.jdField_a_of_type_ArrayOfByte, 0, k);
          this.jdField_a_of_type_JavaLangStringBuilder.append(ByteBase.a(this.jdField_a_of_type_ArrayOfByte, k));
          this.jdField_a_of_type_JavaLangStringBuilder.append(".");
        }
        break;
      case 192: 
        int m = ((k & 0xFFFFFF3F) << 8) + this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.c();
        if (m >= this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.a() - 2) {
          throw new WireParseException("bad compression");
        }
        k = j;
        if (j == 0)
        {
          this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.a();
          k = 1;
        }
        this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.b(m);
        j = k;
      }
    }
    if (j != 0) {
      this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.b();
    }
    if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      this.jdField_a_of_type_JavaLangStringBuilder.deleteCharAt(this.jdField_a_of_type_JavaLangStringBuilder.length() - 1);
    }
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.d();
    this.b = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.d();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.d();
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    String str = Integer.toBinaryString(paramInt);
    if (str.length() < 4) {
      throw new Exception("exception cause [FBS - " + str + "]");
    }
    str = str.substring(str.length() - 4);
    if (str.equals("0011")) {
      throw new UnknownHostException("Unable to resolve host \"" + this.jdField_a_of_type_JavaLangString + "\": No address associated with hostname");
    }
    if (!str.equals("0000")) {
      throw new Exception("exception cause [RCODE - " + str + "][HOST - " + this.jdField_a_of_type_JavaLangString + "]");
    }
  }
  
  private void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (paramLong > 0L)) {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() + 1000L * paramLong);
    }
  }
  
  private void b()
  {
    int i = 0;
    if (i < 2) {}
    for (;;)
    {
      int j;
      try
      {
        k = this.jdField_a_of_type_ArrayOfInt[i];
        if (k <= 0) {
          break label223;
        }
        this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i] = new ArrayList(k);
      }
      catch (WireParseException localWireParseException)
      {
        int k;
        AnswerRecord localAnswerRecord;
        throw localWireParseException;
      }
      if (j < k)
      {
        localAnswerRecord = new AnswerRecord();
        if (i == 0)
        {
          localAnswerRecord.jdField_a_of_type_JavaLangString = a();
          localAnswerRecord.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.d();
          localAnswerRecord.b = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.d();
          this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i].add(localAnswerRecord);
        }
        else
        {
          a();
          localAnswerRecord.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localAnswerRecord.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.d();
          localAnswerRecord.b = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.d();
          localAnswerRecord.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.a();
          this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.a(this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.d());
          localAnswerRecord.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentComponentNetworkModuleCommonDnsDNSInput.a();
          if (localAnswerRecord.jdField_a_of_type_Int == 1)
          {
            a(localAnswerRecord.jdField_a_of_type_Long);
            this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i].add(localAnswerRecord);
          }
        }
      }
      else
      {
        i += 1;
        break;
        return;
        label223:
        j = 0;
        continue;
      }
      j += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public InetAddress[] a()
  {
    if ((this.jdField_a_of_type_ArrayOfJavaUtilArrayList[1] != null) && (this.jdField_a_of_type_ArrayOfJavaUtilArrayList[1].size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i >= this.jdField_a_of_type_ArrayOfJavaUtilArrayList[1].size()) {
          break label120;
        }
        Object localObject = (AnswerRecord)this.jdField_a_of_type_ArrayOfJavaUtilArrayList[1].get(i);
        try
        {
          localObject = InetAddress.getByAddress(((AnswerRecord)localObject).jdField_a_of_type_JavaLangString, ((AnswerRecord)localObject).jdField_a_of_type_ArrayOfByte);
          if ((localObject != null) && (((InetAddress)localObject).getHostName() != null) && (!((InetAddress)localObject).getHostName().equals(((InetAddress)localObject).getHostAddress()))) {
            localArrayList.add(localObject);
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            QDLog.d("ResponsePacket", "getByAddress>>>", localUnknownHostException);
          }
        }
        i += 1;
      }
      label120:
      return (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.ResponsePacket
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.message;

import java.util.LinkedList;

public class MessageStatisticHelper$DelayMsgReportItem
{
  private static LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  int b;
  int c;
  
  /* Error */
  public static DelayMsgReportItem a(int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: invokevirtual 27	java/util/LinkedList:size	()I
    //   9: ifle +53 -> 62
    //   12: getstatic 20	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   15: iconst_0
    //   16: invokevirtual 31	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   19: checkcast 2	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem
    //   22: astore 6
    //   24: aload 6
    //   26: iload_0
    //   27: putfield 33	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:jdField_a_of_type_Int	I
    //   30: aload 6
    //   32: aload_1
    //   33: putfield 35	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload 6
    //   38: lload_2
    //   39: putfield 37	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:jdField_a_of_type_Long	J
    //   42: aload 6
    //   44: iload 4
    //   46: putfield 39	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:b	I
    //   49: aload 6
    //   51: iload 5
    //   53: putfield 41	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:c	I
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload 6
    //   61: areturn
    //   62: new 2	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem
    //   65: dup
    //   66: invokespecial 42	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:<init>	()V
    //   69: astore 6
    //   71: goto -47 -> 24
    //   74: astore_1
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramInt1	int
    //   0	80	1	paramString	String
    //   0	80	2	paramLong	long
    //   0	80	4	paramInt2	int
    //   0	80	5	paramInt3	int
    //   22	48	6	localDelayMsgReportItem	DelayMsgReportItem
    // Exception table:
    //   from	to	target	type
    //   3	24	74	finally
    //   24	56	74	finally
    //   62	71	74	finally
  }
  
  /* Error */
  public static void a(java.util.List paramList)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: invokevirtual 27	java/util/LinkedList:size	()I
    //   9: istore_1
    //   10: iload_1
    //   11: bipush 100
    //   13: if_icmplt +7 -> 20
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: invokeinterface 49 1 0
    //   26: astore_0
    //   27: aload_0
    //   28: invokeinterface 55 1 0
    //   33: ifeq -17 -> 16
    //   36: aload_0
    //   37: invokeinterface 59 1 0
    //   42: checkcast 2	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem
    //   45: astore_2
    //   46: getstatic 20	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   49: aload_2
    //   50: invokevirtual 63	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: getstatic 20	com/tencent/mobileqq/app/message/MessageStatisticHelper$DelayMsgReportItem:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   57: invokevirtual 27	java/util/LinkedList:size	()I
    //   60: istore_1
    //   61: iload_1
    //   62: bipush 100
    //   64: if_icmplt -37 -> 27
    //   67: goto -51 -> 16
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramList	java.util.List
    //   9	56	1	i	int
    //   45	5	2	localDelayMsgReportItem	DelayMsgReportItem
    // Exception table:
    //   from	to	target	type
    //   3	10	70	finally
    //   20	27	70	finally
    //   27	61	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MessageStatisticHelper.DelayMsgReportItem
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class TelephonyUtils
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 86, 852, 853, 886, 1, 7, 20, 27, 30, 32, 33, 34, 36, 39, 40, 41, 43, 44, 45, 46, 47, 48, 49, 51, 52, 53, 54, 55, 56, 57, 58, 60, 61, 62, 63, 65, 66, 81, 82, 84, 90, 91, 92, 93, 94, 95, 98, 213, 216, 218, 220, 221, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 239, 241, 242, 243, 244, 247, 248, 249, 251, 252, 253, 254, 255, 256, 257, 258, 260, 261, 262, 263, 265, 266, 267, 268, 297, 350, 351, 352, 353, 354, 356, 357, 358, 359, 370, 371, 372, 373, 374, 375, 376, 377, 378, 380, 386, 420, 421, 423, 501, 502, 503, 504, 506, 507, 509, 591, 592, 593, 594, 596, 597, 598, 673, 674, 675, 676, 677, 679, 682, 685, 689, 855, 856, 880, 960, 961, 962, 963, 964, 965, 966, 967, 971, 972, 973, 974, 975, 992, 993, 994, 995, 996, 998, 1242, 1246, 1264, 1268, 1345, 1441, 1473, 1671, 1684, 1758, 1784, 1787, 1868, 1876, 1890 };
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "000", "00", "+00", "+" };
  
  public static String[] a(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getLine1Number();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneCodeUtil", 2, "line1Number=" + paramContext);
      }
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "";
      }
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int k = arrayOfString.length;
      int i = 0;
      while (i < k)
      {
        String str = arrayOfString[i];
        int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
        int m = arrayOfInt.length;
        int j = 0;
        while (j < m)
        {
          int n = arrayOfInt[j];
          if (paramContext.startsWith(str + n)) {
            return new String[] { "" + n, paramContext.replace(str + n, "") };
          }
          j += 1;
        }
        i += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.util.TelephonyUtils
 * JD-Core Version:    0.7.0.1
 */
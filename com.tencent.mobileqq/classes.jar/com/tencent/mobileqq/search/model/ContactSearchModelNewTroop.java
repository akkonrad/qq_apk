package com.tencent.mobileqq.search.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import java.util.Set;

public class ContactSearchModelNewTroop
  extends ContactSearchModelGlobalTroop
{
  private CharSequence c;
  
  public ContactSearchModelNewTroop(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List paramList)
  {
    super(paramQQAppInterface, paramInt, paramString, paramList);
  }
  
  public TroopInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  }
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopName())) {
      return c();
    }
    return super.a();
  }
  
  protected void a()
  {
    int j;
    int i;
    int k;
    label54:
    int m;
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localSpannableStringBuilder.append("包含: ");
        j = this.jdField_b_of_type_JavaUtilList.size() - 1;
        i = 0;
        if (j >= 0)
        {
          k = 1;
          if (i >= 10) {
            break label132;
          }
        }
        label132:
        for (m = 1;; m = 0)
        {
          if ((m & k) == 0) {
            break label138;
          }
          localSpannableStringBuilder.append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.jdField_c_of_type_JavaUtilList.get(j), 6, false));
          i += 1;
          localSpannableStringBuilder.append("、");
          j -= 1;
          break;
          k = 0;
          break label54;
        }
        label138:
        k = 0;
        j = i;
        i = k;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          k = 1;
          label159:
          if (j >= 10) {
            break label284;
          }
          m = 1;
          label168:
          if ((m & k) == 0) {
            break label336;
          }
          localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          k = j;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
          {
            if (this.jdField_c_of_type_JavaUtilList.size() != 1) {
              break label290;
            }
            m = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).a;
            label226:
            if (m != 66) {
              break label300;
            }
            localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).c;
          }
        }
        for (;;)
        {
          label240:
          k = j;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            k = j + 1;
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.append("、");
          }
          label284:
          label290:
          label300:
          do
          {
            i += 1;
            j = k;
            break;
            k = 0;
            break label159;
            m = 0;
            break label168;
            m = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_Int;
            break label226;
            if (m == 88)
            {
              localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_JavaLangString;
              break label240;
            }
            k = j;
          } while (m != 99);
          localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).d;
        }
      }
      label336:
      if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、')) {}
      for (this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1); this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopName(); this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder)
      {
        this.jdField_c_of_type_JavaLangCharSequence = "";
        return;
      }
      this.jdField_c_of_type_JavaLangCharSequence = (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + "");
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = "群聊";
    Object localObject = new SpannableStringBuilder();
    if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopName()) {
      ((SpannableStringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum));
    }
    label522:
    label604:
    label608:
    for (;;)
    {
      this.jdField_c_of_type_JavaLangCharSequence = ((CharSequence)localObject);
      return;
      if ((!this.jdField_a_of_type_JavaUtilSet.isEmpty()) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        j = this.jdField_b_of_type_JavaUtilList.size() - 1;
        i = 0;
        if (j >= 0)
        {
          k = 1;
          if (i >= 10) {
            break label604;
          }
        }
        for (m = 1;; m = 0)
        {
          if ((m & k) == 0) {
            break label608;
          }
          ((SpannableStringBuilder)localObject).append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.jdField_c_of_type_JavaUtilList.get(j), 6, false));
          if (j > 0) {
            ((SpannableStringBuilder)localObject).append("、");
          }
          j -= 1;
          i += 1;
          break;
          k = 0;
          break label522;
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!SearchUtils.a(this.jdField_b_of_type_Int)) {
      SearchUtils.a(paramView, this);
    }
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangCharSequence.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContactSearchModelNewTroop
 * JD-Core Version:    0.7.0.1
 */
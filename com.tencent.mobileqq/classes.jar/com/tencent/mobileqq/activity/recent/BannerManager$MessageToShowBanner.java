package com.tencent.mobileqq.activity.recent;

import android.support.annotation.NonNull;

public final class BannerManager$MessageToShowBanner
{
  public final int a;
  @NonNull
  public final BannerManager.IBannerInteract a;
  @NonNull
  public final String a;
  public final int b;
  @NonNull
  public final String b;
  
  public BannerManager$MessageToShowBanner(int paramInt1, @NonNull String paramString1, int paramInt2, @NonNull String paramString2, @NonNull BannerManager.IBannerInteract paramIBannerInteract)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$IBannerInteract = paramIBannerInteract;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (getClass() != paramObject.getClass());
          paramObject = (MessageToShowBanner)paramObject;
          bool1 = bool2;
        } while (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int);
        bool1 = bool2;
      } while (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int);
      bool1 = bool2;
    } while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    return this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    return ((this.jdField_a_of_type_Int * 31 + this.jdField_a_of_type_JavaLangString.hashCode()) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_b_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    return "MessageToShowBanner{bannerLev=" + this.jdField_a_of_type_Int + ", businessCategory='" + this.jdField_a_of_type_JavaLangString + '\'' + ", iconIdx=" + this.jdField_b_of_type_Int + ", wording='" + this.jdField_b_of_type_JavaLangString + '\'' + ", callback=" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$IBannerInteract + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager.MessageToShowBanner
 * JD-Core Version:    0.7.0.1
 */
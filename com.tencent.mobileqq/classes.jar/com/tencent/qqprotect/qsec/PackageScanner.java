package com.tencent.qqprotect.qsec;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

public class PackageScanner
  implements IScanner
{
  private OnScanListener jdField_a_of_type_ComTencentQqprotectQsecOnScanListener;
  private boolean jdField_a_of_type_Boolean;
  
  public PackageScanner(OnScanListener paramOnScanListener)
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecOnScanListener = paramOnScanListener;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentQqprotectQsecOnScanListener == null);
    this.jdField_a_of_type_ComTencentQqprotectQsecOnScanListener.a(a(), null);
  }
  
  private void c()
  {
    Object localObject = BaseApplication.getContext().getPackageManager();
    if (localObject != null) {
      localObject = ((PackageManager)localObject).getInstalledPackages(8192).iterator();
    }
    for (;;)
    {
      PackageInfo localPackageInfo;
      if (((Iterator)localObject).hasNext())
      {
        localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Boolean) {}
      }
      else
      {
        return;
      }
      if (this.jdField_a_of_type_ComTencentQqprotectQsecOnScanListener != null) {
        this.jdField_a_of_type_ComTencentQqprotectQsecOnScanListener.b(a(), localPackageInfo);
      }
    }
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentQqprotectQsecOnScanListener == null);
    this.jdField_a_of_type_ComTencentQqprotectQsecOnScanListener.c(a(), null);
  }
  
  public String a()
  {
    return "App";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      b();
      c();
      label16:
      d();
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.PackageScanner
 * JD-Core Version:    0.7.0.1
 */
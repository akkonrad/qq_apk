package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import yrt;

public class CmGameScreenRotate
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ApolloSurfaceView jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  
  public CmGameScreenRotate(ApolloSurfaceView paramApolloSurfaceView, CmGameInitParams paramCmGameInitParams, Activity paramActivity)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = paramApolloSurfaceView;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {}
    do
    {
      return 1;
      if (paramInt == 3) {
        return 0;
      }
    } while (paramInt != 2);
    return 8;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new yrt(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.token.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.ah;
import com.tencent.token.global.RqdApplication;

final class abe
  implements DialogInterface.OnClickListener
{
  abe(StartPwdGestureDeleteActivity paramStartPwdGestureDeleteActivity, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ah.a().f();
    RqdApplication.f();
    this.b.setResult(35);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abe
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;

public abstract class RemoteResultCallback
  extends RemoteCallback.Stub
{
  public abstract void onCallback(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback
 * JD-Core Version:    0.7.0.1
 */
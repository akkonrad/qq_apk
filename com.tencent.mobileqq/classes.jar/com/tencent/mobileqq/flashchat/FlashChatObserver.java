package com.tencent.mobileqq.flashchat;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class FlashChatObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 967: 
      b(paramBoolean, paramBundle);
      return;
    case 968: 
      a(paramBoolean, paramBundle);
      return;
    case 969: 
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatObserver
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class EmojiJsPlugin$3
  implements DialogInterface.OnClickListener
{
  EmojiJsPlugin$3(EmojiJsPlugin paramEmojiJsPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", 2);
      paramDialogInterface.put("message", "btn2 press");
      this.this$0.onAppResponse(this.val$callbackid, paramDialogInterface.toString());
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
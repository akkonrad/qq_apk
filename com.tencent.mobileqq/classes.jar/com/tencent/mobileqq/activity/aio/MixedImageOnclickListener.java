package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.FileUtils;

public class MixedImageOnclickListener
  implements View.OnClickListener
{
  private long a;
  public SessionInfo a;
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    URLImageView localURLImageView;
    MessageForPic localMessageForPic;
    URLDrawable localURLDrawable;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Long = l;
          localURLImageView = (URLImageView)paramView;
          localMessageForPic = (MessageForPic)localURLImageView.getTag(2131361894);
          localURLDrawable = (URLDrawable)localURLImageView.getDrawable();
        } while (localURLDrawable == null);
        switch (localURLDrawable.getStatus())
        {
        default: 
          return;
        }
      } while (localURLDrawable.isDownloadStarted());
      localURLDrawable.startDownload();
      return;
    } while (!FileUtils.a(paramView.getContext()));
    localURLDrawable.restartDownload();
    return;
    if (!(paramView.getContext() instanceof MultiForwardActivity)) {}
    for (boolean bool = true;; bool = false)
    {
      PicItemBuilder.a(paramView.getContext(), localURLImageView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MixedImageOnclickListener
 * JD-Core Version:    0.7.0.1
 */
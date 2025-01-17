package com.tencent.component.media.photogif;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader.Options;
import java.util.ArrayList;

public class PhotoGifDrawable
  extends QzoneAnimationDrawable
{
  private static Drawable a = ImageManagerEnv.g().getPhotoGifDefaultDrawable();
  
  public PhotoGifDrawable(ImageKey paramImageKey)
  {
    super(paramImageKey);
    setDrawableForDefaultFrame(a);
  }
  
  public static boolean isPhotoGif(ImageKey paramImageKey)
  {
    return (paramImageKey != null) && (paramImageKey.options != null) && (paramImageKey.options.needShowPhotoGifAnimation) && (paramImageKey.options.photoList != null) && (paramImageKey.options.photoList.size() > 1);
  }
  
  public static void setDefaultFrame(Drawable paramDrawable)
  {
    a = paramDrawable;
  }
  
  public boolean canAnimate()
  {
    return ImageManagerEnv.g().shouldPlayPhotoGif();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.photogif.PhotoGifDrawable
 * JD-Core Version:    0.7.0.1
 */
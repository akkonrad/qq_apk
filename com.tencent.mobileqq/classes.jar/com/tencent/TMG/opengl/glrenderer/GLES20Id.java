package com.tencent.TMG.opengl.glrenderer;

import android.opengl.GLES20;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

public class GLES20Id
  implements GLId
{
  public int generateTexture()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20Canvas.checkError();
    return arrayOfInt[0];
  }
  
  public int[] generateTexture(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    GLES20.glGenTextures(paramInt, arrayOfInt, 0);
    GLES20Canvas.checkError();
    return arrayOfInt;
  }
  
  public void glDeleteBuffers(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glDeleteBuffers(paramInt1, paramArrayOfInt, paramInt2);
    GLES20Canvas.checkError();
  }
  
  public void glDeleteFramebuffers(GL11ExtensionPack paramGL11ExtensionPack, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glDeleteFramebuffers(paramInt1, paramArrayOfInt, paramInt2);
    GLES20Canvas.checkError();
  }
  
  public void glDeleteTextures(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glDeleteTextures(paramInt1, paramArrayOfInt, paramInt2);
    GLES20Canvas.checkError();
  }
  
  public void glGenBuffers(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glGenBuffers(paramInt1, paramArrayOfInt, paramInt2);
    GLES20Canvas.checkError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES20Id
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.kingkong;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public class CursorWrapper
  implements Cursor
{
  protected final Cursor mCursor;
  
  public CursorWrapper(Cursor paramCursor)
  {
    this.mCursor = paramCursor;
  }
  
  public void close()
  {
    this.mCursor.close();
  }
  
  public void copyStringToBuffer(int paramInt, android.database.CharArrayBuffer paramCharArrayBuffer) {}
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    this.mCursor.copyStringToBuffer(paramInt, paramCharArrayBuffer);
  }
  
  public void deactivate()
  {
    this.mCursor.deactivate();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.mCursor.getBlob(paramInt);
  }
  
  public int getColumnCount()
  {
    return this.mCursor.getColumnCount();
  }
  
  public int getColumnIndex(String paramString)
  {
    return this.mCursor.getColumnIndex(paramString);
  }
  
  public int getColumnIndexOrThrow(String paramString)
    throws IllegalArgumentException
  {
    return this.mCursor.getColumnIndexOrThrow(paramString);
  }
  
  public String getColumnName(int paramInt)
  {
    return this.mCursor.getColumnName(paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.mCursor.getColumnNames();
  }
  
  public int getCount()
  {
    return this.mCursor.getCount();
  }
  
  public double getDouble(int paramInt)
  {
    return this.mCursor.getDouble(paramInt);
  }
  
  public Bundle getExtras()
  {
    return this.mCursor.getExtras();
  }
  
  public float getFloat(int paramInt)
  {
    return this.mCursor.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.mCursor.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.mCursor.getLong(paramInt);
  }
  
  public int getPosition()
  {
    return this.mCursor.getPosition();
  }
  
  public short getShort(int paramInt)
  {
    return this.mCursor.getShort(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.mCursor.getString(paramInt);
  }
  
  public int getType(int paramInt)
  {
    return this.mCursor.getType(paramInt);
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return this.mCursor.getWantsAllOnMoveCalls();
  }
  
  public Cursor getWrappedCursor()
  {
    return this.mCursor;
  }
  
  public boolean isAfterLast()
  {
    return this.mCursor.isAfterLast();
  }
  
  public boolean isBeforeFirst()
  {
    return this.mCursor.isBeforeFirst();
  }
  
  public boolean isClosed()
  {
    return this.mCursor.isClosed();
  }
  
  public boolean isFirst()
  {
    return this.mCursor.isFirst();
  }
  
  public boolean isLast()
  {
    return this.mCursor.isLast();
  }
  
  public boolean isNull(int paramInt)
  {
    return this.mCursor.isNull(paramInt);
  }
  
  public boolean move(int paramInt)
  {
    return this.mCursor.move(paramInt);
  }
  
  public boolean moveToFirst()
  {
    return this.mCursor.moveToFirst();
  }
  
  public boolean moveToLast()
  {
    return this.mCursor.moveToLast();
  }
  
  public boolean moveToNext()
  {
    return this.mCursor.moveToNext();
  }
  
  public boolean moveToPosition(int paramInt)
  {
    return this.mCursor.moveToPosition(paramInt);
  }
  
  public boolean moveToPrevious()
  {
    return this.mCursor.moveToPrevious();
  }
  
  public void registerContentObserver(android.database.ContentObserver paramContentObserver) {}
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.mCursor.registerContentObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(android.database.DataSetObserver paramDataSetObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mCursor.registerDataSetObserver(paramDataSetObserver);
  }
  
  public boolean requery()
  {
    return this.mCursor.requery();
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return this.mCursor.respond(paramBundle);
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.mCursor.setNotificationUri(paramContentResolver, paramUri);
  }
  
  public void unregisterContentObserver(android.database.ContentObserver paramContentObserver) {}
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    this.mCursor.unregisterContentObserver(paramContentObserver);
  }
  
  public void unregisterDataSetObserver(android.database.DataSetObserver paramDataSetObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mCursor.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.CursorWrapper
 * JD-Core Version:    0.7.0.1
 */
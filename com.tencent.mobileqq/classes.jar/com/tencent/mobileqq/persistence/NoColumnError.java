package com.tencent.mobileqq.persistence;

public class NoColumnError
  extends Error
{
  public String mColumnName;
  public Class mColumnType;
  
  public NoColumnError() {}
  
  public NoColumnError(String paramString)
  {
    super(paramString);
  }
  
  public NoColumnError(String paramString, Class paramClass)
  {
    super("No_Such_Column_" + paramString);
    this.mColumnName = paramString;
    this.mColumnType = paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.NoColumnError
 * JD-Core Version:    0.7.0.1
 */
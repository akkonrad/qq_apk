package com.tencent.kingkong.database;

import android.os.ParcelFileDescriptor;
import com.tencent.kingkong.CursorWindow;
import com.tencent.kingkong.DatabaseUtils;
import com.tencent.kingkong.support.CancellationSignal;

public final class SQLiteSession
{
  public static final int TRANSACTION_MODE_DEFERRED = 0;
  public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
  public static final int TRANSACTION_MODE_IMMEDIATE = 1;
  private SQLiteConnection mConnection;
  private int mConnectionFlags;
  private final SQLiteConnectionPool mConnectionPool;
  private int mConnectionUseCount;
  private Transaction mTransactionPool;
  private Transaction mTransactionStack;
  
  static
  {
    if (!SQLiteSession.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SQLiteSession(SQLiteConnectionPool paramSQLiteConnectionPool)
  {
    if (paramSQLiteConnectionPool == null) {
      throw new IllegalArgumentException("connectionPool must not be null");
    }
    this.mConnectionPool = paramSQLiteConnectionPool;
  }
  
  private void acquireConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (this.mConnection == null)
    {
      assert (this.mConnectionUseCount == 0);
      this.mConnection = this.mConnectionPool.acquireConnection(paramString, paramInt, paramCancellationSignal);
      this.mConnectionFlags = paramInt;
    }
    this.mConnectionUseCount += 1;
  }
  
  /* Error */
  private void beginTransactionUnchecked(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +8 -> 10
    //   5: aload 4
    //   7: invokevirtual 76	com/tencent/kingkong/support/CancellationSignal:throwIfCanceled	()V
    //   10: aload_0
    //   11: getfield 78	com/tencent/kingkong/database/SQLiteSession:mTransactionStack	Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   14: ifnonnull +11 -> 25
    //   17: aload_0
    //   18: aconst_null
    //   19: iload_3
    //   20: aload 4
    //   22: invokespecial 80	com/tencent/kingkong/database/SQLiteSession:acquireConnection	(Ljava/lang/String;ILcom/tencent/kingkong/support/CancellationSignal;)V
    //   25: aload_0
    //   26: getfield 78	com/tencent/kingkong/database/SQLiteSession:mTransactionStack	Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   29: ifnonnull +39 -> 68
    //   32: iload_1
    //   33: tableswitch	default:+143 -> 176, 1:+77->110, 2:+106->139
    //   57: getfield 55	com/tencent/kingkong/database/SQLiteSession:mConnection	Lcom/tencent/kingkong/database/SQLiteConnection;
    //   60: ldc 82
    //   62: aconst_null
    //   63: aload 4
    //   65: invokevirtual 88	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   68: aload_2
    //   69: ifnull +9 -> 78
    //   72: aload_2
    //   73: invokeinterface 93 1 0
    //   78: aload_0
    //   79: iload_1
    //   80: aload_2
    //   81: invokespecial 97	com/tencent/kingkong/database/SQLiteSession:obtainTransaction	(ILcom/tencent/kingkong/database/SQLiteTransactionListener;)Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   84: astore_2
    //   85: aload_2
    //   86: aload_0
    //   87: getfield 78	com/tencent/kingkong/database/SQLiteSession:mTransactionStack	Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   90: putfield 100	com/tencent/kingkong/database/SQLiteSession$Transaction:mParent	Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   93: aload_0
    //   94: aload_2
    //   95: putfield 78	com/tencent/kingkong/database/SQLiteSession:mTransactionStack	Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   98: aload_0
    //   99: getfield 78	com/tencent/kingkong/database/SQLiteSession:mTransactionStack	Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   102: ifnonnull +7 -> 109
    //   105: aload_0
    //   106: invokespecial 103	com/tencent/kingkong/database/SQLiteSession:releaseConnection	()V
    //   109: return
    //   110: aload_0
    //   111: getfield 55	com/tencent/kingkong/database/SQLiteSession:mConnection	Lcom/tencent/kingkong/database/SQLiteConnection;
    //   114: ldc 105
    //   116: aconst_null
    //   117: aload 4
    //   119: invokevirtual 88	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   122: goto -54 -> 68
    //   125: astore_2
    //   126: aload_0
    //   127: getfield 78	com/tencent/kingkong/database/SQLiteSession:mTransactionStack	Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   130: ifnonnull +7 -> 137
    //   133: aload_0
    //   134: invokespecial 103	com/tencent/kingkong/database/SQLiteSession:releaseConnection	()V
    //   137: aload_2
    //   138: athrow
    //   139: aload_0
    //   140: getfield 55	com/tencent/kingkong/database/SQLiteSession:mConnection	Lcom/tencent/kingkong/database/SQLiteConnection;
    //   143: ldc 107
    //   145: aconst_null
    //   146: aload 4
    //   148: invokevirtual 88	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   151: goto -83 -> 68
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 78	com/tencent/kingkong/database/SQLiteSession:mTransactionStack	Lcom/tencent/kingkong/database/SQLiteSession$Transaction;
    //   159: ifnonnull +15 -> 174
    //   162: aload_0
    //   163: getfield 55	com/tencent/kingkong/database/SQLiteSession:mConnection	Lcom/tencent/kingkong/database/SQLiteConnection;
    //   166: ldc 109
    //   168: aconst_null
    //   169: aload 4
    //   171: invokevirtual 88	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   174: aload_2
    //   175: athrow
    //   176: goto -120 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	SQLiteSession
    //   0	179	1	paramInt1	int
    //   0	179	2	paramSQLiteTransactionListener	SQLiteTransactionListener
    //   0	179	3	paramInt2	int
    //   0	179	4	paramCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   25	32	125	finally
    //   56	68	125	finally
    //   72	78	125	finally
    //   78	98	125	finally
    //   110	122	125	finally
    //   139	151	125	finally
    //   155	174	125	finally
    //   174	176	125	finally
    //   72	78	154	java/lang/RuntimeException
  }
  
  private void endTransactionUnchecked(CancellationSignal paramCancellationSignal, boolean paramBoolean)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    Transaction localTransaction = this.mTransactionStack;
    int i;
    Object localObject2;
    SQLiteTransactionListener localSQLiteTransactionListener;
    Object localObject1;
    int j;
    if (((localTransaction.mMarkedSuccessful) || (paramBoolean)) && (!localTransaction.mChildFailed))
    {
      i = 1;
      localObject2 = null;
      localSQLiteTransactionListener = localTransaction.mListener;
      localObject1 = localObject2;
      j = i;
      if ((localSQLiteTransactionListener != null) && (i == 0)) {
        break label124;
      }
    }
    for (;;)
    {
      try
      {
        localSQLiteTransactionListener.onCommit();
        j = i;
        localObject1 = localObject2;
      }
      catch (RuntimeException localRuntimeException)
      {
        label124:
        j = 0;
        continue;
        if (j == 0) {
          continue;
        }
        try
        {
          this.mConnection.execute("COMMIT;", null, paramCancellationSignal);
          releaseConnection();
          continue;
        }
        finally
        {
          releaseConnection();
        }
        this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
        continue;
      }
      this.mTransactionStack = localTransaction.mParent;
      recycleTransaction(localTransaction);
      if (this.mTransactionStack == null) {
        continue;
      }
      if (j == 0) {
        this.mTransactionStack.mChildFailed = true;
      }
      if (localObject1 == null) {
        return;
      }
      throw localObject1;
      i = 0;
      break;
      localSQLiteTransactionListener.onRollback();
      localObject1 = localObject2;
      j = i;
    }
  }
  
  private boolean executeSpecial(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    switch (DatabaseUtils.getSqlStatementType(paramString))
    {
    default: 
      return false;
    case 4: 
      beginTransaction(2, null, paramInt, paramCancellationSignal);
      return true;
    case 5: 
      setTransactionSuccessful();
      endTransaction(paramCancellationSignal);
      return true;
    }
    endTransaction(paramCancellationSignal);
    return true;
  }
  
  private Transaction obtainTransaction(int paramInt, SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    Transaction localTransaction = this.mTransactionPool;
    if (localTransaction != null)
    {
      this.mTransactionPool = localTransaction.mParent;
      localTransaction.mParent = null;
      localTransaction.mMarkedSuccessful = false;
      localTransaction.mChildFailed = false;
    }
    for (;;)
    {
      localTransaction.mMode = paramInt;
      localTransaction.mListener = paramSQLiteTransactionListener;
      return localTransaction;
      localTransaction = new Transaction(null);
    }
  }
  
  private void recycleTransaction(Transaction paramTransaction)
  {
    paramTransaction.mParent = this.mTransactionPool;
    paramTransaction.mListener = null;
    this.mTransactionPool = paramTransaction;
  }
  
  private void releaseConnection()
  {
    assert (this.mConnection != null);
    assert (this.mConnectionUseCount > 0);
    int i = this.mConnectionUseCount - 1;
    this.mConnectionUseCount = i;
    if (i == 0) {}
    try
    {
      this.mConnectionPool.releaseConnection(this.mConnection);
      return;
    }
    finally
    {
      this.mConnection = null;
    }
  }
  
  private void throwIfNestedTransaction()
  {
    if (hasNestedTransaction()) {
      throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
    }
  }
  
  private void throwIfNoTransaction()
  {
    if (this.mTransactionStack == null) {
      throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
    }
  }
  
  private void throwIfTransactionMarkedSuccessful()
  {
    if ((this.mTransactionStack != null) && (this.mTransactionStack.mMarkedSuccessful)) {
      throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
    }
  }
  
  private boolean yieldTransactionUnchecked(long paramLong, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags)) {
      return false;
    }
    int i = this.mTransactionStack.mMode;
    SQLiteTransactionListener localSQLiteTransactionListener = this.mTransactionStack.mListener;
    int j = this.mConnectionFlags;
    endTransactionUnchecked(paramCancellationSignal, true);
    if (paramLong > 0L) {}
    try
    {
      Thread.sleep(paramLong);
      label68:
      beginTransactionUnchecked(i, localSQLiteTransactionListener, j, paramCancellationSignal);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label68;
    }
  }
  
  public void beginTransaction(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    throwIfTransactionMarkedSuccessful();
    beginTransactionUnchecked(paramInt1, paramSQLiteTransactionListener, paramInt2, paramCancellationSignal);
  }
  
  public void endTransaction(CancellationSignal paramCancellationSignal)
  {
    throwIfNoTransaction();
    assert (this.mConnection != null);
    endTransactionUnchecked(paramCancellationSignal, false);
  }
  
  public void execute(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      this.mConnection.execute(paramString, paramArrayOfObject, paramCancellationSignal);
      return;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public ParcelFileDescriptor executeForBlobFileDescriptor(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return null;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      paramString = this.mConnection.executeForBlobFileDescriptor(paramString, paramArrayOfObject, paramCancellationSignal);
      return paramString;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return 0;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      paramInt = this.mConnection.executeForChangedRowCount(paramString, paramArrayOfObject, paramCancellationSignal);
      return paramInt;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (paramCursorWindow == null) {
      throw new IllegalArgumentException("window must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt3, paramCancellationSignal))
    {
      paramCursorWindow.clear();
      return 0;
    }
    acquireConnection(paramString, paramInt3, paramCancellationSignal);
    try
    {
      paramInt1 = this.mConnection.executeForCursorWindow(paramString, paramArrayOfObject, paramCursorWindow, paramInt1, paramInt2, paramBoolean, paramCancellationSignal);
      return paramInt1;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return 0L;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLastInsertedRowId(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public long executeForLong(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return 0L;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLong(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public String executeForString(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
      return null;
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      paramString = this.mConnection.executeForString(paramString, paramArrayOfObject, paramCancellationSignal);
      return paramString;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public boolean hasConnection()
  {
    return this.mConnection != null;
  }
  
  public boolean hasNestedTransaction()
  {
    return (this.mTransactionStack != null) && (this.mTransactionStack.mParent != null);
  }
  
  public boolean hasTransaction()
  {
    return this.mTransactionStack != null;
  }
  
  public void prepare(String paramString, int paramInt, CancellationSignal paramCancellationSignal, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("sql must not be null.");
    }
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      this.mConnection.prepare(paramString, paramSQLiteStatementInfo);
      return;
    }
    finally
    {
      releaseConnection();
    }
  }
  
  public void setTransactionSuccessful()
  {
    throwIfNoTransaction();
    throwIfTransactionMarkedSuccessful();
    this.mTransactionStack.mMarkedSuccessful = true;
  }
  
  public boolean yieldTransaction(long paramLong, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    if (paramBoolean)
    {
      throwIfNoTransaction();
      throwIfTransactionMarkedSuccessful();
      throwIfNestedTransaction();
    }
    while ((this.mTransactionStack != null) && (!this.mTransactionStack.mMarkedSuccessful) && (this.mTransactionStack.mParent == null))
    {
      if (($assertionsDisabled) || (this.mConnection != null)) {
        break;
      }
      throw new AssertionError();
    }
    while (this.mTransactionStack.mChildFailed) {
      return false;
    }
    return yieldTransactionUnchecked(paramLong, paramCancellationSignal);
  }
  
  private static final class Transaction
  {
    public boolean mChildFailed;
    public SQLiteTransactionListener mListener;
    public boolean mMarkedSuccessful;
    public int mMode;
    public Transaction mParent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteSession
 * JD-Core Version:    0.7.0.1
 */
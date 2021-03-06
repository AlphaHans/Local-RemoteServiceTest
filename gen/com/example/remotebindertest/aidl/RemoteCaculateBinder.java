/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\Java\\WorkSpace\\RemoteBinderTest\\src\\com\\example\\remotebindertest\\aidl\\RemoteCaculateBinder.aidl
 */
package com.example.remotebindertest.aidl;
public interface RemoteCaculateBinder extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.remotebindertest.aidl.RemoteCaculateBinder
{
private static final java.lang.String DESCRIPTOR = "com.example.remotebindertest.aidl.RemoteCaculateBinder";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.remotebindertest.aidl.RemoteCaculateBinder interface,
 * generating a proxy if needed.
 */
public static com.example.remotebindertest.aidl.RemoteCaculateBinder asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.remotebindertest.aidl.RemoteCaculateBinder))) {
return ((com.example.remotebindertest.aidl.RemoteCaculateBinder)iin);
}
return new com.example.remotebindertest.aidl.RemoteCaculateBinder.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_add:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.add(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.remotebindertest.aidl.RemoteCaculateBinder
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void add(int arg0, int arg1) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(arg0);
_data.writeInt(arg1);
mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void add(int arg0, int arg1) throws android.os.RemoteException;
}

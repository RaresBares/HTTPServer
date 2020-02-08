package de.rares.protocol.server;

public abstract class Messanger {
   public Messanger(){
       ConnectionManager.messangers.add(this);
   }
    public abstract void onMessage(String msg);
    public abstract void onConnect();
}

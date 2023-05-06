package com.example.cheez.documentdispatch;

public class DocumentHolder {
    public Document document;
    private final static DocumentHolder INSTANCE = new DocumentHolder();

    private DocumentHolder() {}

    public static DocumentHolder getInstance(){
        return INSTANCE;
    }

    public void setDoc(Document d){
        this.document = d;
    }

    public Document getDoc(){
        return this.document;
    }

}

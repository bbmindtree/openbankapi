package com.mindtree;

public class Greeting {

    private final long id;
    private final String content;
    private final String mail;

    public Greeting(long id, String content,String mail) {
        this.id = id;
        this.content = content;
        this.mail=mail;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
    public String getMail(){
    	return mail;
    }
}

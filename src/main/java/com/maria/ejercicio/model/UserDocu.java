package com.maria.ejercicio.model;


public class UserDocu{
    private long userId;
    private String user;
    private String comment;
    private long docId;
    private String doc;
    
    public UserDocu(long userId, String user, String comment, long docId, String doc) {
        this.userId = userId;
        this.user = user;
        this.comment = comment;
        this.docId = docId;
        this.doc = doc;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public long getDocId() {
        return docId;
    }
    public void setDocId(long docId) {
        this.docId = docId;
    }
    public String getDoc() {
        return doc;
    }
    public void setDoc(String doc) {
        this.doc = doc;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((doc == null) ? 0 : doc.hashCode());
        result = prime * result + (int) (docId ^ (docId >>> 32));
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + (int) (userId ^ (userId >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserDocu other = (UserDocu) obj;
        if (comment == null) {
            if (other.comment != null)
                return false;
        } else if (!comment.equals(other.comment))
            return false;
        if (doc == null) {
            if (other.doc != null)
                return false;
        } else if (!doc.equals(other.doc))
            return false;
        if (docId != other.docId)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (userId != other.userId)
            return false;
        return true;
    }
    
}
package com.ps.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "changeInfo")
public class ChangeInfo
{
    @Id
    @GeneratedValue
    private int id;
    private String contactInfo;
    private String oldGame;
    private String newGame;

    @Override public int hashCode()
    {
        return Objects.hash(contactInfo, oldGame, newGame);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getContactInfo()
    {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    public String getOldGame()
    {
        return oldGame;
    }

    public void setOldGame(String oldGame)
    {
        this.oldGame = oldGame;
    }

    public String getNewGame()
    {
        return newGame;
    }

    public void setNewGame(String newGame)
    {
        this.newGame = newGame;
    }
    @Override public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        ChangeInfo that = (ChangeInfo) o;
        return Objects.equals(contactInfo, that.contactInfo) && Objects.equals(oldGame, that.oldGame) && Objects
                .equals(newGame, that.newGame);
    }

    @Override public String toString()
    {
        return "ChangeInfo{" + "contactInfo='" + contactInfo + '\'' + ", oldGame='" + oldGame + '\'' + ", newGame='"
                + newGame + '\'' + '}';
    }
}

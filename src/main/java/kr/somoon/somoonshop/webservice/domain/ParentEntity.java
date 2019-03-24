package kr.somoon.somoonshop.webservice.domain;

import lombok.Getter;
import org.dom4j.tree.AbstractEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class ParentEntity {

    @Id
    @Getter
    @GeneratedValue
    private long id;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public ParentEntity(){}

    public ParentEntity(long id){
        this.id = id;
    }

    public String getFormattedCreateDate(){
        return getFormattedDate(createDate, "yyyy.MM.dd HH:mm:ss");
    }

    public String getFormattedModifiedDate(){
        return getFormattedDate(modifiedDate, "yyyy.MM.dd HH:mm:ss");
    }

    private String getFormattedDate(LocalDateTime dateTime, String format){
        if(dateTime == null)
            return "";

        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        ParentEntity other = (ParentEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ParentEntity [id=" + id + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + "]";
    }
}

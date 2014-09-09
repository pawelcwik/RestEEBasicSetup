package org.foo.caffee.oracle.entity;

import org.foo.caffee.oracle.entity.Result;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name=Prediction.findAll,query="Select d from Prediction d")
public class Prediction {

    public final static String PREFIX = "org.foo.caffee.oracle.Prediction.";
    public final static String findAll = PREFIX+"findAll";
    
    @Id
    @GeneratedValue
    @XmlTransient
    private long id;
    
    @Column(name="prediction_result")
    @Enumerated(EnumType.STRING)
    private Result result;
    
    @Temporal(TemporalType.TIME)
    private Date predictionDate;
    
    private boolean success;
    
    public Prediction() {
        this.predictionDate = new Date();
    }
    
    public Prediction(Result result, boolean success) {
        this();
        this.result = result;
        this.success = success;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Date getPredictionDate() {
        return predictionDate;
    }

    public void setPredictionDate(Date predictionDate) {
        this.predictionDate = predictionDate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.result);
        hash = 71 * hash + Objects.hashCode(this.predictionDate);
        hash = 71 * hash + (this.success ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prediction other = (Prediction) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.result != other.result) {
            return false;
        }
        if (!Objects.equals(this.predictionDate, other.predictionDate)) {
            return false;
        }
        if (this.success != other.success) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}

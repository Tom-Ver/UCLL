package be.ucll.electroman.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Workorder implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public long userId;

    public String city;

    public String device;

    public String problemCode;

    public String customerName;

    public Boolean processed;

    public String detailedProblemDescription;

    public String repairInformation;

    public Workorder (){}


    //CONSTRUCTOR ONLY FOR TEST PURPOSES (THE USER CREATED IN THIS ASSIGNMENT) SEE ElectroManDatabase.CLASS.fillDbWithTestData()
    @Ignore
    public Workorder(long userId, String city, String device, String problemCode, String customerName, Boolean processed, String detailedProblemDescription, String repairInformation) {
        this.userId = userId;
        this.city = city;
        this.device = device;
        this.problemCode = problemCode;
        this.customerName = customerName;
        this.processed = processed;
        this.detailedProblemDescription = detailedProblemDescription;
        this.repairInformation = repairInformation;
    }


    //GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getProblemCode() {
        return problemCode;
    }

    public void setProblemCode(String problemCode) {
        this.problemCode = problemCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public String getDetailedProblemDescription() {
        return detailedProblemDescription;
    }

    public void setDetailedProblemDescription(String detailedProblemDescription) {
        this.detailedProblemDescription = detailedProblemDescription;
    }

    public String getRepairInformation() {
        return repairInformation;
    }

    public void setRepairInformation(String repairInformation) {
        this.repairInformation = repairInformation;
    }
}

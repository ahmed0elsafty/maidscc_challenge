package com.elsafty.maidscc;

import jakarta.persistence.*;

@Entity
@Table(name = "test_data")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "battery_power")
    private Integer batteryPower;

    @Column(name = "blue")
    private Integer blue;

    @Column(name = "clock_speed")
    private Float clockSpeed;

    @Column(name = "dual_sim")
    private Integer dualSim;

    @Column(name = "fc")
    private Float fc;

    @Column(name = "four_g")
    private Integer fourG;

    @Column(name = "int_memory")
    private Float intMemory;

    @Column(name = "m_dep")
    private Float mDep;

    @Column(name = "mobile_wt")
    private Float mobileWt;

    @Column(name = "n_cores")
    private Float nCores;

    @Column(name = "pc")
    private Float pc;

    @Column(name = "px_height")
    private Float pxHeight;

    @Column(name = "px_width")
    private Float pxWidth;

    @Column(name = "ram")
    private Float ram;

    @Column(name = "sc_h")
    private Float scH;

    @Column(name = "sc_w")
    private Float scW;

    @Column(name = "talk_time")
    private Integer talkTime;

    @Column(name = "three_g")
    private Integer threeG;

    @Column(name = "touch_screen")
    private Integer touchScreen;

    @Column(name = "wifi")
    private Integer wifi;



    // Getters and setters
        // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for batteryPower
    public Integer getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Integer batteryPower) {
        this.batteryPower = batteryPower;
    }

    // Getter and Setter for blue
    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    // Getter and Setter for clockSpeed
    public Float getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(Float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    // Getter and Setter for dualSim
    public Integer getDualSim() {
        return dualSim;
    }

    public void setDualSim(Integer dualSim) {
        this.dualSim = dualSim;
    }

    // Getter and Setter for fc
    public Float getFc() {
        return fc;
    }

    public void setFc(Float fc) {
        this.fc = fc;
    }

    // Getter and Setter for fourG
    public Integer getFourG() {
        return fourG;
    }

    public void setFourG(Integer fourG) {
        this.fourG = fourG;
    }

    // Getter and Setter for intMemory
    public Float getIntMemory() {
        return intMemory;
    }

    public void setIntMemory(Float intMemory) {
        this.intMemory = intMemory;
    }

    // Getter and Setter for mDep
    public Float getMDep() {
        return mDep;
    }

    public void setMDep(Float mDep) {
        this.mDep = mDep;
    }

    // Getter and Setter for mobileWt
    public Float getMobileWt() {
        return mobileWt;
    }

    public void setMobileWt(Float mobileWt) {
        this.mobileWt = mobileWt;
    }

    // Getter and Setter for nCores
    public Float getNCores() {
        return nCores;
    }

    public void setNCores(Float nCores) {
        this.nCores = nCores;
    }

    // Getter and Setter for pc
    public Float getPc() {
        return pc;
    }

    public void setPc(Float pc) {
        this.pc = pc;
    }

    // Getter and Setter for pxHeight
    public Float getPxHeight() {
        return pxHeight;
    }

    public void setPxHeight(Float pxHeight) {
        this.pxHeight = pxHeight;
    }

    // Getter and Setter for pxWidth
    public Float getPxWidth() {
        return pxWidth;
    }

    public void setPxWidth(Float pxWidth) {
        this.pxWidth = pxWidth;
    }

    // Getter and Setter for ram
    public Float getRam() {
        return ram;
    }

    public void setRam(Float ram) {
        this.ram = ram;
    }

    // Getter and Setter for scH
    public Float getScH() {
        return scH;
    }

    public void setScH(Float scH) {
        this.scH = scH;
    }

    // Getter and Setter for scW
    public Float getScW() {
        return scW;
    }

    public void setScW(Float scW) {
        this.scW = scW;
    }

    // Getter and Setter for talkTime
    public Integer getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(Integer talkTime) {
        this.talkTime = talkTime;
    }

    // Getter and Setter for threeG
    public Integer getThreeG() {
        return threeG;
    }

    public void setThreeG(Integer threeG) {
        this.threeG = threeG;
    }

    // Getter and Setter for touchScreen
    public Integer getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Integer touchScreen) {
        this.touchScreen = touchScreen;
    }

    // Getter and Setter for wifi
    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }



    
}


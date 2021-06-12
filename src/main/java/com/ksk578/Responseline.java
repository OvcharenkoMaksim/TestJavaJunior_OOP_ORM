package com.ksk578;

public class Responseline {
    // цель класса - создание объекта, в котором будет храниться строка запроса и связывание полей объекта с
    // полями результирующего запроса
    String creationDate;
    String systName;
    String document;
    String globStatus;
    String systNameGlobStatus;
    String svr;
    String organization;
    String globStat;
    String lokStat;
    String globVersion;
    String lockVersion;
    String databaseID;
    String globalID;
    String orgID;
    String docID;
    public Responseline (String creationDate, String systName, String document, String globStatus, String systNameGlobStatus,
            String svr, String organization, String globStat, String lokStat, String globVersion, String lockVersion,
            String databaseID, String globalID, String orgID, String docID) {
        this.creationDate = creationDate;
        this.systName = systName;
        this.document = document;
        this.globStatus = globStatus;
        this.systNameGlobStatus = systNameGlobStatus;
        this.svr = svr;
        this.organization = organization;
        this.globStat = globStat;
        this.lokStat = lokStat;
        this.globVersion = globVersion;
        this.lockVersion = lockVersion;
        this.databaseID = databaseID;
        this.globalID = globalID;
        this.orgID = orgID;
        this.docID = docID;
    }
}

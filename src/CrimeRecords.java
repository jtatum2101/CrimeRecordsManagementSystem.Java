public class CrimeRecords {
    String reportTitle = "";
    String reportDate = "";
    String numOfReport = "" ;
    String nameOfVictim = "";
    String hasSuspect = "";
    String nameOfSuspect = "";
    String hasWarrant = "";
    String reportDescription = "";

    public CrimeRecords(String title, String date, String reportNumber, String victimName, String isSuspect, String suspectName, String warrant, String description) {
        reportTitle = title;
        reportDate = date;
        numOfReport = reportNumber;
        nameOfVictim = victimName;
        hasSuspect = isSuspect;
        nameOfSuspect = suspectName;
        hasWarrant = warrant;
        reportDescription = description;
    }
    public void updateRecord(String rDa, String nV, String hS, String nS, String hW, String rD) {
        reportDate = rDa;
        nameOfVictim = nV;
        if(hS.equalsIgnoreCase("n")){
            nameOfSuspect = null;
            hasWarrant = null;
            reportDescription = rD;
        }else{
            nameOfSuspect = nS;
        }
        if(hW.equalsIgnoreCase("n")){
            hasWarrant = hW;
            reportDescription = rD;
        }



    }
}


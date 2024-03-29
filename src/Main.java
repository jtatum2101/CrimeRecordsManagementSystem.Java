import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<CrimeRecords> records = new ArrayList<>();
    static String titleOfReport;
    static String dateOfReport;
    static int numOfReport;
    static String victimName;
    static String isSuspect;
    static String suspectName;
    static String hasWarrant;
    static String descriptionOfReport;

    public static void main(String[] args) {
        System.out.println("Welcome to Crime Records Management!");
        while (true) {
            scan.nextLine();
            System.out.println("[c]reate a new record, [v]iew all reports, view by [da]te, view by [r]eport [n]umber, [u]pdate, [d]elete, or [q]uit? ");
            System.out.print("> ");
            String option = scan.nextLine();
            if (option.equalsIgnoreCase("c")) {
                System.out.print("Title: ");
                titleOfReport = scan.nextLine();
                System.out.print("Date: ");
                dateOfReport = scan.nextLine();
                System.out.print("Report Number: ");
                numOfReport = scan.nextInt();
                scan.nextLine();
                System.out.print("Victim's name: ");
                victimName = scan.nextLine();
                while (true) {
                    System.out.print("Suspect? ");
                    isSuspect = scan.nextLine();
                    if (isSuspect.equalsIgnoreCase("y") || isSuspect.equalsIgnoreCase("yes")) {
                        System.out.print("Suspect's Name: ");
                        suspectName = scan.nextLine();

                        System.out.println("Warrant? ");
                        hasWarrant = scan.nextLine();
                        if (hasWarrant.equalsIgnoreCase("y") || hasWarrant.equalsIgnoreCase("yes")) {
                            System.out.println("Description: ");
                            descriptionOfReport = scan.nextLine();
                            break;
                        } else if (hasWarrant.equalsIgnoreCase("n") || hasWarrant.equalsIgnoreCase("no")) {
                            hasWarrant = null;
                            System.out.println("Description: ");
                            descriptionOfReport = scan.nextLine();
                            break;
                        } else {
                            System.out.println("Please answer the question... ");

                        }

                    } else if (isSuspect.equalsIgnoreCase("n") || isSuspect.equalsIgnoreCase("no")) {
                        suspectName = "unknown";
                        hasWarrant = "unknown";
                        System.out.println("Description");
                        descriptionOfReport = scan.nextLine();
                        break;
                    } else {
                        System.out.println("Please answer the question...");
                    }
                }
                CrimeRecords newRecord = new CrimeRecords(titleOfReport, dateOfReport, numOfReport, victimName, isSuspect, suspectName, hasWarrant, descriptionOfReport);
                records.add(newRecord);
            } else if (option.equalsIgnoreCase("v")) {
                if (records.size() == 0) {
                    System.out.println("You have no records!");

                } else {
                    for (CrimeRecords i : records) {
                        System.out.println(i.reportTitle + " - " + i.reportDate + " - " + i.numOfReport + " - " + i.nameOfVictim + " - " + i.hasSuspect + " - " + i.nameOfSuspect + " - " + i.hasWarrant + " - " + i.reportDescription);
                    }
                }
            } else if (option.equalsIgnoreCase("da")) {
                if (records.size() == 0) {
                    System.out.println("You have no records!");
                } else {
                    boolean found = false;
                    System.out.println("Date: ");
                    String searchByDate = scan.nextLine();
                    for (CrimeRecords i : records) {
                        if (searchByDate.equals(i.reportDate)) {
                            System.out.println(i.reportTitle + " - " + i.reportDate + " - " + i.numOfReport + " - " + i.nameOfVictim + " - " + i.hasSuspect + " - " + i.nameOfSuspect + " - " + i.hasWarrant + " - " + i.reportDescription);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Record was not found!");

                    }
                }
            } else if (option.equalsIgnoreCase("rn")) {
                if (records.size() == 0) {
                    System.out.println("You have no records!");
                } else {
                    boolean found = false;
                    System.out.print("Report Number: ");
                    int searchedByNum = scan.nextInt();
                    for (CrimeRecords i : records) {
                        if (searchedByNum == i.numOfReport) {
                            System.out.println(i.reportTitle + " - " + i.reportDate + " - " + i.numOfReport + " - " + i.nameOfVictim + " - " + i.hasSuspect + " - " + i.nameOfSuspect + " - " + i.hasWarrant + " - " + i.reportDescription);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No records were found with this report number!");
                    }
                }
            } else if (option.equalsIgnoreCase("u")) {
                if (records.size() == 0) {
                    System.out.println("You have no records!");
                } else {
                    System.out.print("Title: ");
                    String titleUpdated = scan.nextLine();
                    boolean madeUpdate = false;

                    for (CrimeRecords updatedRecord : records) {
                        if (titleUpdated.equalsIgnoreCase(updatedRecord.reportTitle)) {
                            System.out.print("Date: ");
                            String dateUpdated = scan.nextLine();
                            updatedRecord.reportDate = dateUpdated;
                            System.out.print("Victim's Name: ");
                            String victimNameUpdated = scan.nextLine();
                            updatedRecord.nameOfVictim = victimNameUpdated;
                            System.out.println("Is there a suspect? ");
                            String updatedHasSuspect = scan.nextLine();
                            updatedRecord.hasSuspect = updatedHasSuspect;
                            if (updatedHasSuspect.equalsIgnoreCase("n") || updatedHasSuspect.equalsIgnoreCase("no")) {
                                String updatedSuspectName = "unknown";
                                String updatedWarrant = "unknown";
                                updatedRecord.nameOfSuspect = updatedSuspectName;
                                updatedRecord.hasWarrant = updatedWarrant;
                                System.out.println("Description: ");
                                String updatedDescription = scan.nextLine();
                                updatedRecord.reportDescription = updatedDescription;
                                updatedRecord.updateRecord(dateUpdated, victimNameUpdated, updatedHasSuspect, updatedSuspectName, updatedWarrant, updatedDescription);
                                madeUpdate = true;
                                break;
                            } else {
                                System.out.print("Suspect's Name: ");
                                String updatedSuspectName = scan.nextLine();
                                updatedRecord.nameOfSuspect = updatedSuspectName;
                                System.out.println("Does the suspect have the warrant? ");
                                String updatedWarrant = scan.nextLine();
                                updatedRecord.hasWarrant = updatedWarrant;
                                System.out.println("Description: ");
                                String updatedDescription = scan.nextLine();
                                updatedRecord.reportDescription = updatedDescription;
                                updatedRecord.updateRecord(dateUpdated, victimNameUpdated, updatedHasSuspect, updatedSuspectName, updatedWarrant, updatedDescription);
                                madeUpdate = true;
                                break;
                            }
                        }
                    }
                    if (!madeUpdate) {
                        System.out.println("Name not found!");
                    }
                }
            } else if (option.equalsIgnoreCase("d")) {
                if (records.size() == 0) {
                    System.out.println("You have no records! ");
                } else {
                    System.out.print("Title: ");
                    String deletedTitle = scan.nextLine();
                    for (CrimeRecords i : records) {
                        if (deletedTitle.equals(i.reportTitle)) {
                            records.remove(i);
                            break;
                        }
                    }
                }
            } else if (option.equalsIgnoreCase("q")) {
                System.out.println("Thank you for filing a report! Have a good day!");
                break;
            } else {
                System.out.println("Please select a valid option!");
            }
        }
    }
}
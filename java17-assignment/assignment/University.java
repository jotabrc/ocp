package assignment;

public class University {

    public static void main(String[] args) {
//        LecturerRecord lecturerRecord = new LecturerRecord("", 23, null, null);
//        LecturerRecord lecturerRecord = new LecturerRecord("Joe", -23, null, null);
        Faculty engineeringFaculty = new EngineeringFaculty();
        Department softwareEngineeringDpt = new SoftwareEngineeringDpt();
        LecturerRecord lecturerRecord = new LecturerRecord("Jane Bloggs", 24, engineeringFaculty, softwareEngineeringDpt);
        System.out.println(lecturerRecord.name());
        System.out.println(lecturerRecord.age());
        System.out.println(lecturerRecord.faculty());
        System.out.println(lecturerRecord.dept());
        lecturerRecord.whichFaculty();
        System.out.println(lecturerRecord.hasPhd());

        Faculty businessFaculty = new BusinessFaculty();
        Department accountingDept = new AccountingDpt();

        lecturerRecord = new LecturerRecord("Dr. Anne Bloggs", 35, businessFaculty, accountingDept);
        System.out.println(lecturerRecord.hasPhd());

        Faculty humanitiesFaculty = new HumanitiesFaculty();
        Department socialCareDpt = new SocialCareDpt();

        lecturerRecord = new LecturerRecord("Joe Bloggs PhD", 54, humanitiesFaculty, socialCareDpt);
        System.out.println(lecturerRecord.hasPhd());
    }
}

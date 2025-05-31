import assignment.*;

import java.util.*;

void main() {
//        LecturerRecord lecturerRecord = new LecturerRecord("", 23, null, null);
//        LecturerRecord lecturerRecord = new LecturerRecord("Joe", -23, null, null);
//    Faculty engineeringFaculty = new EngineeringFaculty();
//    Department softwareEngineeringDpt = new SoftwareEngineeringDpt();
//    LecturerRecord lecturerRecord = new LecturerRecord("Jane Bloggs", 24, engineeringFaculty, softwareEngineeringDpt);
//    System.out.println(lecturerRecord.name());
//    System.out.println(lecturerRecord.age());
//    System.out.println(lecturerRecord.faculty());
//    System.out.println(lecturerRecord.dept());
//    lecturerRecord.whichFaculty();
//    System.out.println(lecturerRecord.hasPhd());

//    Faculty businessFaculty = new BusinessFaculty();
//    Department accountingDept = new AccountingDpt();
//
//    lecturerRecord = new LecturerRecord("Dr. Anne Bloggs", 35, businessFaculty, accountingDept);
//    System.out.println(lecturerRecord.hasPhd());
//
//    Faculty humanitiesFaculty = new HumanitiesFaculty();
//    Department socialCareDpt = new SocialCareDpt();
//
//    lecturerRecord = new LecturerRecord("Joe Bloggs PhD", 54, humanitiesFaculty, socialCareDpt);
//    System.out.println(lecturerRecord.hasPhd());

    Faculty engineering = new EngineeringFaculty();
    Faculty business = new BusinessFaculty();
    Faculty humanities = new HumanitiesFaculty();

    Department accounting = new AccountingDpt();
    Department software = new SoftwareEngineeringDpt();
    Department social = new SocialCareDpt();

    LecturerRecord mike = new LecturerRecord("Mike Bloggs", 44, engineering, software);
    LecturerRecord alan = new LecturerRecord("Alan Austin", 64, business, accounting);
    LecturerRecord lisa = new LecturerRecord("Lisa Bloggs", 65, humanities, social);

    recordPatterns(mike);
    recordPatterns(alan);
    recordPatterns(lisa);

    seqColl();
    seqSet();
    seqMap();
}

public static void seqColl() {
    SequencedCollection<LecturerRecord> seqColl = new ArrayList<>();

    Faculty engineering = new EngineeringFaculty();
    Department software = new SoftwareEngineeringDpt();

    LecturerRecord jane = new LecturerRecord("Jane Bloggs", 24, engineering, software);
    LecturerRecord anne = new LecturerRecord("Dr. Anne Bloggs", 34, engineering, software);
    LecturerRecord joe = new LecturerRecord("Joe Bloggs PhD", 54, engineering, software);

    seqColl.addFirst(jane);
    seqColl.addFirst(anne);
    seqColl.addLast(joe);

    seqColl.forEach(System.out::println);
    System.out.println(seqColl);

    System.out.println("first: " + seqColl.getFirst());
    System.out.println("last: " + seqColl.getLast());
    System.out.println("remove last: " + seqColl.removeLast());
    System.out.println(seqColl);

    for (LecturerRecord l : seqColl) {
        System.out.println(l);
    }

    for (LecturerRecord l : seqColl.reversed()) {
        System.out.println(l);
    }
}

public static void seqSet() {
    SequencedSet<LecturerRecord> seqSet = new LinkedHashSet<>();

    Faculty business = new BusinessFaculty();
    Department accounting = new AccountingDpt();

    LecturerRecord jane = new LecturerRecord("Jane Austin", 24, business, accounting);
    LecturerRecord charlotte = new LecturerRecord("Charlotte Bronte", 35, business, accounting);
    LecturerRecord anne = new LecturerRecord("Anne Bronte PhD", 54, business, accounting);

    seqSet.add(jane);
    seqSet.add(jane);
    seqSet.add(jane);
    seqSet.addFirst(charlotte);
    seqSet.addLast(jane);
    seqSet.addLast(anne);
    System.out.println(seqSet);
    System.out.println(seqSet.getFirst());
    System.out.println(seqSet.getLast());
    System.out.println(seqSet.removeFirst());
    System.out.println(seqSet);

    for (LecturerRecord l : seqSet) {
        System.out.println(l);
    }

    for (var l : seqSet.reversed()) {
        System.out.println(l);
    }
}

public static void seqMap() {
    SequencedMap<LecturerRecord, String> seqMap = new LinkedHashMap<>();

    Faculty business = new BusinessFaculty();
    Department accounting = new AccountingDpt();

    LecturerRecord lear = new LecturerRecord("King Lear", 88, business, accounting);
    LecturerRecord goneril = new LecturerRecord("Goneril", 55, business, accounting);
    LecturerRecord regan = new LecturerRecord("Regan", 50, business, accounting);
    LecturerRecord cordelia = new LecturerRecord("Cordelia", 45, business, accounting);

    seqMap.putFirst(goneril, "Eldest");
    seqMap.putFirst(regan, "Middle");
    seqMap.putLast(cordelia, "Youngest");
    seqMap.putLast(lear, "Father");

    System.out.println(seqMap);
    System.out.println(seqMap.firstEntry());
    System.out.println(seqMap.lastEntry());
    System.out.println(seqMap.pollLastEntry());
    System.out.println(seqMap);

    for (var l : seqMap.sequencedEntrySet()) {
        System.out.println(l);
    }

    for (var l : seqMap.sequencedEntrySet().reversed()) {
        System.out.println(l);
    }
}

public static void recordPatterns(Object obj) {

    String value = switch (obj) {
        case LecturerRecord l -> l.age() >= 64 ? """
                %s
                %d
                %s
                %s
                """.formatted(l.name(), l.age(), l.faculty(), l.dept())
                : "";
        case null, default -> "";
    };

    System.out.println(value);
}
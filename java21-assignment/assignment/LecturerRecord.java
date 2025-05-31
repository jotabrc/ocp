package assignment;

// redundant final
public final record LecturerRecord(String name, Integer age, Faculty faculty, Department dept) {

    public LecturerRecord {
        if (name.isBlank() || age < 0) {
            String errorMessage = """
                    Illegal argument passed:
                        "name": %s,
                        "age": %d
                    """.formatted(name, age);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public boolean hasPhd() {
//        return name.startsWith("Dr.") || name.endsWith("PhD");
        String prefix = name.substring(0, Math.min(3, name.length()));
        String suffix = name.substring(Math.max(0, name.length() - 3));
        return switch (prefix) {
            case "Dr." -> true;
            default -> switch (suffix) {
                case "PhD" -> true;
                default -> false;
            };
        };
    }

    public void whichFaculty() {
//        if (this.faculty instanceof EngineeringFaculty f) {
//            System.out.println("Faculty of: " + f.toString());
//            f.engineering();
//        } else if (this.faculty instanceof HumanitiesFaculty f) {
//            System.out.println("Faculty of: " + f.toString());
//            f.humanities();
//        } else if (this.faculty instanceof BusinessFaculty f) {
//            System.out.println("Faculty of: " + f.toString());
//            f.business();
//        } else {
//            throw new IllegalArgumentException("Illegal argument passed:\n\tFaculty %s not supported"
//                    .formatted(this
//                            .faculty
//                            .getClass()
//                            .getSimpleName()));
//        }

        switch (this.faculty) {
            case EngineeringFaculty f -> {
                System.out.println("Faculty of: " + f.toString());
                f.engineering();
            }
            case HumanitiesFaculty f -> {
                System.out.println("Faculty of: " + f.toString());
                f.humanities();
            }
            case BusinessFaculty f -> {
                System.out.println("Faculty of: " + f.toString());
                f.business();
            }
            case null -> throw new IllegalArgumentException("Illegal argument passed:\n\tFaculty cannot be null");
            default -> throw new IllegalArgumentException("Illegal argument passed:\n\tFaculty %s not supported"
                    .formatted(this
                            .faculty
                            .getClass()
                            .getSimpleName()));
        }
    }

    public void whichDept() {
        switch (this.dept) {
            case ComputerEngineeringDpt e -> {
                System.out.println("Dept of: " + e.toString());
                e.compEng();
            }
            case SoftwareEngineeringDpt e -> {
                System.out.println("Dept of: " + e.toString());
                e.swEng();
            }
            case SocialCareDpt e -> {
                System.out.println("Dept of: " + e.toString());
                e.socialCare();
            }
            case AccountingDpt e -> {
                System.out.println("Dept of: " + e.toString());
                e.accounting();
            }
            case null -> throw new IllegalArgumentException("Illegal argument passed:\n\tDepartment cannot be null");
            default -> throw new IllegalArgumentException("Illegal argument passed:\n\tDepartment %s not supported"
                    .formatted(this
                            .faculty
                            .getClass()
                            .getSimpleName()));
        }
    }
}

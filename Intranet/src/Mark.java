import java.io.Serializable;
import java.util.Objects;

/**
 * @generated
 */
public class Mark implements Serializable {

    /**
     * @generated
     */
    private double points;
    private double firstAttestation = 0;
    private double secondAttestation = 0;
    private double finalExam = 0;
    private double total;
    private double gpa = 0;
    private double digit_mark;
    /**
     * @generated
     */
    private String literalMark;

    /**
     * @generated
     */
    private Student student;

    public Mark() {}

    public Mark(double points, TypeOfMark typeOfMark) {
        this.points = points;
        switch (typeOfMark) {
            case FIRST_ATTESTATION -> this.setFirstAttestation(points);
            case SECOND_ATTESTATION -> this.setSecondAttestation(points);
            case FINAL -> this.setFinal(points);
        }
    }

    /**
     * @generated
     */
    private double getPoints() {
        return this.points;
    }

    /**
     * @generated
     */
    private void setPoints(double points) {
        this.points = points;
    }

    /**
     * @generated
     */
    public String getLiteralMark() {
        return this.literalMark;
    }

    public double getDigitMark() {
        return this.digit_mark;
    }

    /**
     * @generated
     */
    private void setLiteralMark(String literalMark) {
        this.literalMark = literalMark;
    }


    /**
     * @generated
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * @generated
     */
    public void setStudent(Student student) {
        this.student = student;
    }


    //                          Operations

    /**
     * @generated
     */
    public double getFirstAttestation() {
        return this.firstAttestation;
    }
    /**
     * @generated
     */
    public void setFirstAttestation(double first_attestation) {
        this.firstAttestation = first_attestation;
    }
    /**
     * @generated
     */
    public double getSecondAttestation() {
        return this.secondAttestation;
    }
    /**
     * @generated
     */
    public void setSecondAttestation(double second_attestation) {
        this.secondAttestation = second_attestation;
    }
    /**
     * @generated
     */
    public double getFinal() {
        return this.finalExam;
    }
    /**
     * @generated
     */
    public void setFinal(double final_exam) {
        this.finalExam = final_exam;
    }
    /**
     * @generated
     */
    public double getTotal() {
        this.total = getFirstAttestation() + getSecondAttestation() + getFinal();
        return this.total;
    }
    /**
     * @generated
     */
    public void setTotal(double total) {
        this.total = total;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        if (Double.compare(mark.points, points) != 0) return false;
        if (Double.compare(mark.firstAttestation, firstAttestation) != 0) return false;
        if (Double.compare(mark.secondAttestation, secondAttestation) != 0) return false;
        if (Double.compare(mark.finalExam, finalExam) != 0) return false;
        if (Double.compare(mark.total, total) != 0) return false;
        if (!literalMark.equals(mark.literalMark)) return false;
        return Objects.equals(student, mark.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, firstAttestation, secondAttestation, finalExam);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "points=" + points +
                ", firstAttestation=" + firstAttestation +
                ", secondAttestation=" + secondAttestation +
                ", finalExam=" + finalExam +
                ", total=" + total +
                ", literalMark=" + literalMark +
                ", student=" + student +
                '}';
    }
    public void transformMark(double total) {
        if(total>=94.5 && total<=100) {
            literalMark = "A";
            digit_mark = 4.0;
        }
        else if(total>=89.5 && total<94.5) {
            literalMark = "A-";
            digit_mark = 3.67;
        }
        else if(total>=84.5 && total<89.5) {
            literalMark = "B+";
            digit_mark = 3.33;
        }
        else if(total>=79.5 && total<84.5) {
            literalMark = "B";
            digit_mark = 3.0;
        }
        else if(total>=74.5 && total<79.5) {
            literalMark = "B-";
            digit_mark = 2.67;
        }
        else if(total>=69.5 && total<74.5) {
            literalMark = "C+";
            digit_mark = 2.33;
        }
        else if(total>=64.5 && total<69.5) {
            literalMark = "C";
            digit_mark = 2.0;
        }
        else if(total>=59.5 && total<64.5) {
            literalMark = "C-";
            digit_mark = 1.67;
        }
        else if(total>=54.5 && total<59.5) {
            literalMark = "D+";
            digit_mark = 1.33;
        }
        else if(total>=50 && total<54.5) {
            literalMark = "D";
            digit_mark = 1.0;
        }
        else {
            literalMark = "F";
            digit_mark = 0;
        }
    }

    public void putMark(TypeOfMark typeOfMark, double points) {
        if (typeOfMark == TypeOfMark.FIRST_ATTESTATION) {
            this.setFirstAttestation(points);
        }
        else if (typeOfMark == TypeOfMark.SECOND_ATTESTATION) {
            this.setSecondAttestation(points);
        }
        else if (typeOfMark == TypeOfMark.FINAL) {
            this.setFinal(points);
            this.transformMark(this.getTotal());
        }
    }
}

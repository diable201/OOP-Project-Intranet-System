import java.io.Serializable;
import java.util.Objects;

/**
 * @generated
 */
/**
 * Represents Mark's information and methods
 *
 * @implements Serializable to save and load marks
 * 
 */
public class Mark implements Serializable {

	/**
     * point of mark
     */
    private double points;
    /**
     * point for 1 attestation 
     */
    private double firstAttestation = 0;
    /**
     * point for 2 attestation 
     */
    private double secondAttestation = 0;
    /**
     * point for final Exam
     */
    private double finalExam = 0;
    /**
     * point for total
     */
    private double total;
    /**
     * gpa mark
     */
    private double gpa = 0;
    /**
     * the main gpa
     */
    private double digit_mark;
    /**
     * literal mark of point
     */
    private String literalMark;

    /**
     * the Student
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
    /**
     * Get points
     *
     * @return Points
     * 
     */
    private double getPoints() {
        return this.points;
    }

    /**
     * @generated
     */
    /**
     * Set points
     *
     * @param Points from user
     * 
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
    
    /**
     * Set literal mark
     *
     * @param Literal mark from user
     * 
     */
    private void setLiteralMark(String literalMark) {
        this.literalMark = literalMark;
    }


    /**
     * @generated
     */
    /**
     * Get student
     *
     * @return student's all information
     * 
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * @generated
     */
    /**
     * Setting student
     *
     * @param student's all information from user
     * 
     */
    public void setStudent(Student student) {
        this.student = student;
    }


    //                          Operations

    /**
     * @generated
     */
    /**
     * Get points from 1 attestation
     *
     * @return 1st attestation point
     * 
     */
    public double getFirstAttestation() {
        return this.firstAttestation;
    }
    /**
     * @generated
     */
    /**
     * Set points to 1 attestation
     *
     * @param 1st attestation point
     * 
     */
    public void setFirstAttestation(double first_attestation) {
        this.firstAttestation = first_attestation;
    }
    /**
     * @generated
     */
    /**
     * Get points from 2 attestation
     *
     * @return 2 attestation point
     * 
     */
    public double getSecondAttestation() {
        return this.secondAttestation;
    }
    /**
     * @generated
     */
    /**
     * Set points to 2 attestation
     *
     * @param 2 attestation point
     * 
     */
    public void setSecondAttestation(double second_attestation) {
        this.secondAttestation = second_attestation;
    }
    /**
     * @generated
     */
    /**
     * Get Final
     *
     * @return final point
     * 
     */
    public double getFinal() {
        return this.finalExam;
    }
    /**
     * @generated
     */
    /**
     * Set points to final
     *
     * @param  final point
     * 
     */
    public void setFinal(double final_exam) {
        this.finalExam = final_exam;
    }
    /**
     * @generated
     */
    /**
     * Get points to total, by calculating all points
     *
     * @return total point
     * 
     */
    public double getTotal() {
        this.total = getFirstAttestation() + getSecondAttestation() + getFinal();
        return this.total;
    }
    /**
     * @generated
     */
    /**
     * Set points to total
     *
     * @param total from user
     * 
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * Get Gpa
     *
     * @return gpa
     * 
     */
    public Double getGpa() {
        return gpa;
    }
    /**
     * Set gpa
     *
     * @param gpa from user
     * 
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    /**
     * Equals method
     *
     * @param object Mark
     * @return boolean expression for equals
     * 
     */
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

    /**
     * get Hash Code
     *
     * 
     * @return code of current mark
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(points, firstAttestation, secondAttestation, finalExam);
    }

    /**
     * ToString
     *
     * 
     * @return All information about Mark
     * 
     */
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
    /**
     * Transform Mark from total to literal mark
     *
     * 
     * @param total from user
     * 
     */
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
    /**
     * method for putting Mark 
     *
     * 
     * @param type of mark and point
     * 
     */
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

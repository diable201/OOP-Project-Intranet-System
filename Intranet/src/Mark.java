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
    private double first_attestation;
    private double second_attestation;
    private double final_exam;
    private double total;
    /**
    * @generated
    */
    private LiteralMark literalMark;

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
    private LiteralMark getLiteralMark() {
        return this.literalMark;
    }
    
    /**
    * @generated
    */
    private void setLiteralMark(LiteralMark literalMark) {
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
        return this.first_attestation;
    }
    /**
    * @generated
    */
    public void setFirstAttestation(double first_attestation) {
        this.first_attestation = first_attestation;
    }
    /**
    * @generated
    */
    public double getSecondAttestation() {
        return this.second_attestation;
    }
    /**
    * @generated
    */
    public void setSecondAttestation(double second_attestation) {
        this.second_attestation = second_attestation;
    }
    /**
    * @generated
    */
    public double getFinal() {
        return this.final_exam;
    }
    /**
    * @generated
    */
    public void setFinal(double final_exam) {
        this.final_exam = final_exam;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        if (Double.compare(mark.points, points) != 0) return false;
        if (Double.compare(mark.first_attestation, first_attestation) != 0) return false;
        if (Double.compare(mark.second_attestation, second_attestation) != 0) return false;
        if (Double.compare(mark.final_exam, final_exam) != 0) return false;
        if (Double.compare(mark.total, total) != 0) return false;
        if (literalMark != mark.literalMark) return false;
        return Objects.equals(student, mark.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, first_attestation, second_attestation, final_exam);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "points=" + points +
                ", first_attestation=" + first_attestation +
                ", second_attestation=" + second_attestation +
                ", final_exam=" + final_exam +
                ", total=" + total +
                ", literalMark=" + literalMark +
                ", student=" + student +
                '}';
    }
}

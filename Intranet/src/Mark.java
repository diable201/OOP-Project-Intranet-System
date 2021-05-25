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
    private String getLiteralMark() {
        return this.literalMark;
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
    public void transformMark(double total) {
    	if(total>=94.5 && total<=100) {
    		literalMark = "A";
    	}
    	else if(total>=89.5 && total<94.5) {
    		literalMark = "A-";
    	}
    	else if(total>=84.5 && total<89.5) {
    		literalMark = "B+";
    	}
    	else if(total>=79.5 && total<84.5) {
    		literalMark = "B";
    	}
    	else if(total>=74.5 && total<79.5) {
    		literalMark = "B-";
    	}
    	else if(total>=69.5 && total<74.5) {
    		literalMark = "C+";
    	}
    	else if(total>=64.5 && total<69.5) {
    		literalMark = "C";
    	}
    	else if(total>=59.5 && total<64.5) {
    		literalMark = "C-";
    	}
    	else if(total>=54.5 && total<59.5) {
    		literalMark = "D";
    	}
    	else if(total>=50 && total<54.5) {
    		literalMark = "D-";
    	}
    	else {
    		literalMark = "F";
    	}
    }
    public void putMark(TypeOfMark typeOfMark, double points) {
    	switch (typeOfMark) {
        case FIRST_ATTESTATION -> this.setFirstAttestation(points);
        case SECOND_ATTESTATION -> this.setSecondAttestation(points);
        case FINAL -> this.setFinal(points);
    	}
    }
}

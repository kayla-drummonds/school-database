package school.database.entity;

// import java.util.List;
// import java.util.Objects;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class CourseTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "name")
    protected String name;

    /*
     * @ManyToOne(fetch = FetchType.EAGER, optional = false)
     * 
     * @JoinColumn(name = "department_id", nullable = false) protected Department
     * department;
     */

    @Column(name="department_id")
    protected Integer department;

    /*
     * @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade =
     * CascadeType.ALL) protected List<StudentCourse> studentCourses;
     */

}

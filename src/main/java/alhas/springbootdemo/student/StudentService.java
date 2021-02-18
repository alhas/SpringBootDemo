package alhas.springbootdemo.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Long studentId, Student student) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with Id" + studentId + " does not exist");
        }
        studentRepository.findById(studentId)
                .map(oldStudent -> {
                    oldStudent.setName(student.getName());
                    oldStudent.setEmail(student.getEmail());
                    oldStudent.setDob(student.getDob());
                    return studentRepository.save(oldStudent);
                }).orElseGet((() -> {
            student.setId(studentId);
            return studentRepository.save(student);
        }));

    }
}

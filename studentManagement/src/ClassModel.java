import java.util.List;
import java.util.Map;
public class ClassModel {
    private static final Map<Integer, List<String>> books=Map.ofEntries(
            Map.entry(1, List.of("English", "Rhymes", "Hindi", "Basic Mathematics", "Environmental Studies")),
            Map.entry(2, List.of("English Grammar", "Hindi Literature", "Mathematics Fundamentals", "Moral Science", "General Knowledge")),
            Map.entry(3, List.of("English Literature", "Hindi Reader", "Mathematics", "Environmental Studies", "Intro to Computers")),
            Map.entry(4, List.of("English", "Regional Language", "Mathematics Fractions", "General Science", "Social Studies")),
            Map.entry(5, List.of("Advanced English", "Hindi Grammar", "Mathematics Arithmetic", "General Science", "Social Sciences")),
            Map.entry(6, List.of("English Prose", "Hindi", "Mathematics Algebra", "Physics & Chemistry Intro", "History & Civics", "Geography")),
            Map.entry(7, List.of("English Literature", "Hindi", "Mathematics Geometry", "Integrated Science", "History", "Geography", "Computer Literacy")),
            Map.entry(8, List.of("English", "Hindi Literature", "Mathematics", "Science & Technology", "Social Sciences", "Intro to Coding")),
            Map.entry(9, List.of("English Communicative", "Hindi Course A", "Mathematics", "Science (Physics, Chemistry, Biology)", "Social Science", "Information Technology")),
            Map.entry(10, List.of("English Language & Lit", "Hindi", "Mathematics (Core)", "Science Portfolio", "Social Science History & Economics")),
            Map.entry(11, List.of("English Core", "Advanced Physics", "Organic & Inorganic Chemistry", "Calculus Basics", "Computer Science with Python")),
            Map.entry(12, List.of("English Core", "Modern Physics", "Physical Chemistry", "Advanced Calculus & Vectors", "Data Structures & Java"))
    );
public List<String > getBooks(int class_no){
    return books.get(class_no);
}
}

package Step_1;

import java.text.SimpleDateFormat;
import java.util.Date;


// MODEL
public class Project implements Comparable<Project> {

    private String title;
    private Date starting, ending;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Project(String title, Date starting, Date ending) {
        this.title = title;
        this.starting = starting;
        this.ending = ending;
    }

    @Override
    public String toString() {
        String format = "%-30s %-15s %-15s";
        return String.format(format, this.title, dateFormat.format(starting), dateFormat.format(ending));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }
}

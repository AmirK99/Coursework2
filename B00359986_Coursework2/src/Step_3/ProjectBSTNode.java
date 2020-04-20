package Step_3;

public class ProjectBSTNode {
    private Project project;
    private ProjectBSTNode left, right;

    @Override
    public String toString() {
        String s = "";
        if (left != null) s += left.toString();
        s += project.toString() + "\n";
        if (right != null) s += right.toString();
        return s;
    }

    public ProjectBSTNode(Project project, ProjectBSTNode left, ProjectBSTNode right) {
        this.project = project;
        this.left = left;
        this.right = right;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ProjectBSTNode getLeft() {
        return left;
    }

    public void setLeft(ProjectBSTNode left) {
        this.left = left;
    }

    public ProjectBSTNode getRight() {
        return right;
    }

    public void setRight(ProjectBSTNode right) {
        this.right = right;
    }

    public void insert(Project project) {
        if (this.project.getTitle().toLowerCase().compareTo(project.getTitle().toLowerCase()) > 0) {
            if (this.left == null) {
                this.left = new ProjectBSTNode(project, null, null);
            } else {
                this.left.insert(project);
            }
        } else if (this.project.getTitle().toLowerCase().compareTo(project.getTitle().toLowerCase()) < 0) {
            if (this.right == null) {
                this.right = new ProjectBSTNode(project, null, null);
            } else {
                this.right.insert(project);
            }
        }
    }

    public Project findByName(String name) {
        if (this.project.getTitle().toLowerCase().equals(name.toLowerCase())) return this.project;
        if (this.left != null && this.project.getTitle().toLowerCase().compareTo(name.toLowerCase()) > 0) {
            return this.left.findByName(name);
        } else if (this.right != null && this.project.getTitle().toLowerCase().compareTo(name.toLowerCase()) < 0) {
            return this.right.findByName(name);
        }
        return null;
    }

    public void printTeamMemberNumberRecursively() {
        if (left != null) {
            left.printTeamMemberNumberRecursively();
        }
        this.project.printMembersNumber();
        if (right != null) {
            right.printTeamMemberNumberRecursively();
        }
    }

    public boolean remove(Project remove, ProjectBSTNode root) {
        if (this.project.getTitle().compareTo(remove.getTitle()) > 0) {
            if (left == null) return false;
            return left.remove(remove, this);
        } else if (this.project.getTitle().compareTo(remove.getTitle()) < 0) {
            if (right == null) return false;
            else return right.remove(remove, this);
        } else {
            if (left != null && right != null) {
                this.takeDataFrom(smallestOnLeft(right));
                right.remove(this.project, this);
            } else if (root.left == this) {
                if (left != null) root.left = left;
                else root.left = right;
            } else if (root.right == this) {
                if (left != null) root.right = left;
                else root.right = right;
            }
            return true;
        }
    }

    private void takeDataFrom(ProjectBSTNode smallestOnLeft) {
        this.project = smallestOnLeft.project;
    }

    public static ProjectBSTNode smallestOnLeft(ProjectBSTNode p) {
        if (p.left == null) {
            return p;
        } else {
            return smallestOnLeft(p.left);
        }
    }
}

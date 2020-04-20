package Step_3;

import java.util.Date;

public class ProjectBST {
    private ProjectBSTNode root;



	@Override
    public String toString() {
        return root.toString();
    }

    public void displayAllTeamSizes(){
        root.printTeamMemberNumberRecursively();
    }

    public void insert(Project project) {
        if(root == null) {
            root = new ProjectBSTNode(project, null, null);
        } else {
            root.insert(project);
        }
    }

    public Project findByName(String name) {
        if(root == null){
            return null;
        } else {
            return root.findByName(name);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean remove(Project project) {
        return root.remove(project, root);
    }
}

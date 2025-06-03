package model;

import java.util.ArrayList;
import java.util.List;

public class Participant extends EventUser {
    private List<Idea> submittedIdeas;

    public Participant(String username, String password) {
        super(username, password);
        this.submittedIdeas = new ArrayList<>();
    }

    public void submitIdea(String title, String description) {
        submittedIdeas.add(new Idea(title, description, this));
    }

    public List<Idea> getSubmittedIdeas() {
        return submittedIdeas;
    }

    @Override
    public String getRole() {
        return "Participant";
    }
}

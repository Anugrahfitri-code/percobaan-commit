package model;

import java.util.ArrayList;
import java.util.List;

public class IdeaRepository {
    private static List<Idea> ideas = new ArrayList<>();

    public static void addIdea(Idea idea) {
        ideas.add(idea);
    }
}

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PathCandidate {

    // Path of visited CityId's. Each city is represented by an integer
    private LinkedList<Integer> path;
    // Visited cities within this path
    private Set<Integer> visitedCities;
    // Greedy Algorithm score for the path
    private int score = 0;

    public Set<Integer> getVisitedCities() {
	return visitedCities;
    }

    public int getScore() {
	return score;
    }

    public boolean isAlreadyVisited(int cityId) {
	return visitedCities.contains(cityId);
    }

    // Create a path from an existing path and adding a city to the path
    public static PathCandidate newPathCandidate(
	    PathCandidate oldPathCandidate, int cityId, int newCityScore) {
	PathCandidate newPath = new PathCandidate();
	newPath.visitedCities.addAll(oldPathCandidate.getVisitedCities());
	newPath.visitedCities.add(cityId);
	newPath.path.addAll(oldPathCandidate.path);
	newPath.path.add(cityId);
	newPath.score = (oldPathCandidate.score + newCityScore);
	return newPath;
    }

    private PathCandidate() {
	this.visitedCities = new HashSet<Integer>();
	this.path = new LinkedList<Integer>();
	// No city provided so score = 0
	this.score = 0;
    }

    // Create a new path (from scratch) with a cityId as the origin of the path
    public PathCandidate(int cityId) {
	path = new LinkedList<Integer>();
	path.add(cityId);
	visitedCities = new HashSet<Integer>();
	visitedCities.add(cityId);
	// The first city of a path is always a new city and scores 1 point
	score = 1;
    }

    public int getLastCityVisitedInPath() {
	return path.getLast();
    }
}

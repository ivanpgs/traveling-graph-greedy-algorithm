import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PathCandidatesQueue {

    // Queue of locally feasible city paths ([A -> B, A -> B -> C, A -> B -> D])
    private Queue<PathCandidate> candidatesQueue = new LinkedList<PathCandidate>();

    public void setAlreadyVisitedCandidateCityIds(
	    Set<Integer> alreadyVisitedCandidateCityIds) {
	this.alreadyVisitedCandidateCityIds = alreadyVisitedCandidateCityIds;
    }

    private PathCandidate currentPathBeingEvaluated;
    private Set<Integer> alreadyVisitedCandidateCityIds = null;

    // The optimal solution (according to the greedy algorithm) path
    private PathCandidate optimalPath = null;

    public void setOptimalPath(PathCandidate optimalPath) {
	this.optimalPath = optimalPath;
    }

    public PathCandidate getOptimalPath() {
	return optimalPath;
    }

    public PathCandidate getCurrentPathBeingEvaluated() {
	return currentPathBeingEvaluated;
    }

    public void setCurrentlyBeingEvaluated(
	    PathCandidate currentPathBeingEvaluated) {
	this.currentPathBeingEvaluated = currentPathBeingEvaluated;
    }

    public void addNewCandidateCityToCandidatesQueue(int cityId) {
	PathCandidate path = new PathCandidate(cityId);
	candidatesQueue.add(path);
    }

    public PathCandidate getNextCandidate() {
	currentPathBeingEvaluated = candidatesQueue.remove();
	return currentPathBeingEvaluated;
    }

    public boolean isEmpty() {
	return candidatesQueue.isEmpty();
    }

    public void addNewPathCandidatesFromNewVisitableCityCandidatesAndUpdateScore(
	    Set<Integer> newVisitableCityCandidates) {
	for (int nextCityId : newVisitableCityCandidates) {
	    // Add as much as new paths as visitableCities
	    // Every new path comprises the currentlyBeingEvaluated path plus
	    // the new visitableCity on the iteration
	    if (!currentPathBeingEvaluated.isAlreadyVisited(nextCityId)) {
		// Adding a new path comprising the old path plus a new city
		int newCityScore = getScore(nextCityId);
		PathCandidate newPath = PathCandidate.newPathCandidate(
			currentPathBeingEvaluated, nextCityId, newCityScore);
		candidatesQueue.add(newPath);
	    }
	}
    }

    public int getScore(int newCityId) {
	if (alreadyVisitedCandidateCityIds.contains(newCityId)) {
	    return 0;
	} else {
	    return 1;
	}

    }
}

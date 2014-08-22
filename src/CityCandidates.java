import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CityCandidates {

    // A candidate set, from which a solution is created
    private Map<Integer, HashSet<Integer>> originCityIdToDestinyCityIdsCandidates = null;
    private Set<Integer> alreadyVisitedCandidateCityIds = new HashSet<Integer>();

    /**
     * A candidate set, from which a solution is created
     * 
     * @param destinyCities
     * @return
     */
    public void setInitialCandidates(int[] destinyCities) {
	// http://javarevisited.blogspot.jp/2011/09/difference-hashmap-vs-hashset-java.html
	initializeCandidatesLength(destinyCities.length);
	int originCityId = 0;
	for (Integer destinyCityId : destinyCities) {

	    // Add the destinyCityId city to the originCityId
	    addDestinyCityIdToOriginalCityIdVisitableCandidates(originCityId,
		    destinyCityId);

	    // Add the originCityId to the destinyCityId (commutative)
	    addDestinyCityIdToOriginalCityIdVisitableCandidates(destinyCityId,
		    originCityId);
	    originCityId++;
	}
    }

    public Set<Integer> getAlreadyVisitedCandidateCityIds() {
	return alreadyVisitedCandidateCityIds;
    }

    private void initializeCandidatesLength(int numberOfCandidatesCities) {
	originCityIdToDestinyCityIdsCandidates = new HashMap<Integer, HashSet<Integer>>(
		numberOfCandidatesCities);
    }

    @SuppressWarnings("unchecked")
    private void addDestinyCityIdToOriginalCityIdVisitableCandidates(
	    int originCityId, Integer destinyCityId) {
	HashSet<Integer> visitableCitiesFromOriginCityId = originCityIdToDestinyCityIdsCandidates
		.get(originCityId);
	if (visitableCitiesFromOriginCityId == null) {
	    visitableCitiesFromOriginCityId = new HashSet<Integer>();
	}
	visitableCitiesFromOriginCityId.add(destinyCityId);
	originCityIdToDestinyCityIdsCandidates.put(originCityId,
		visitableCitiesFromOriginCityId);
    }

    public void addVisitedCityId(int visitedCityId) {
	alreadyVisitedCandidateCityIds.add(visitedCityId);
    }

    public void addVisitedCitiesId(Set<Integer> visitedCitiesId) {
	alreadyVisitedCandidateCityIds.addAll(visitedCitiesId);
    }

    public Set<Integer> getVisitableCityCandidatesFromCityId(int originCityId) {
	return originCityIdToDestinyCityIdsCandidates.get(originCityId);
    }

    public int getCityCandidatesSize() {
	return (originCityIdToDestinyCityIdsCandidates == null) ? 0
		: originCityIdToDestinyCityIdsCandidates.size();
    }

}

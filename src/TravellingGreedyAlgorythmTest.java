import java.util.List;

public class TravellingGreedyAlgorythmTest {

    public static void main(String[] args) {
	TravelingGreedyAlgorythm travelingGreedyAlgorithm = new TravelingGreedyAlgorythm();
	// T[0] = 1
	// T[1] = 2
	// T[2] = 3
	// T[3] = 3
	// T[4] = 2
	// T[5] = 1
	// T[6] = 4
	// 0[1], 1[0,2,5],2[1,3,4],3[2],4[2,6],5[1],6[4]
	final int ORIGIN_CITY_ID = 2;

	int[] cityCandidates = { 1, 2, 3, 3, 2, 1, 4 };
	List<Integer> solutionPathCandidates = travelingGreedyAlgorithm
		.getSolution(ORIGIN_CITY_ID, cityCandidates);
	for (Integer cityId : solutionPathCandidates) {
	    System.out.println("cityId [" + cityId + "]");
	}

    }
}

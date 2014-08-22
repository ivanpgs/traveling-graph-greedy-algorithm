traveling-graph-greedy-algorithm
================================

What is it
----------

A country network consisting of N cities and N − 1 roads connecting them is given. Cities are labeled with distinct integers within the range [0..(N − 1)]. Roads connect cities in such a way that each distinct pair of cities is connected either by a direct road or through a path consisting of direct roads. There is exactly one way to reach any city from any other city.

Starting out from city K, you have to plan a series of daily trips. Each day you want to visit a previously unvisited city in such a way that, on a route to that city, you will also pass through a maximal number of other unvisited cities (which will then be considered to have been visited). We say that the destination city is our daily travel target.

In the case of a tie, you should choose the city with the minimal label. The trips cease when every city has been visited at least once.

For example, consider K = 2 and the following network consisting of seven cities and six roads:

You start in city 2. From here you make the following trips:
day 1 − from city 2 to city 0 (cities 1 and 0 become visited), day 2 − from city 0 to city 6 (cities 4 and 6 become visited), day 3 − from city 6 to city 3 (city 3 becomes visited), day 4 − from city 3 to city 5 (city 5 becomes visited).

The goal is to find the sequence of travel targets. In the above example we have the following travel targets: (2, 0, 6, 3, 5).
struct Results { int * D; int X; };

Write a function:
struct Results solution(int K, int T[], int N);

that, given a non-empty zero-indexed array T consisting of N integers describing a network of N cities and N − 1 roads, returns the sequence of travel targets.

Array T describes a network of cities as follows:
if T[P] = Q and P ≠ Q, then there is a direct road between cities P and Q.

For example, given the following array T consisting of seven elements (this array describes the network shown above) and K = 2:
T[0] = 1 T[1] = 2 T[2] = 3 T[3] = 3 T[4] = 2 T[5] = 1 T[6] = 4

the function should return a sequence [2, 0, 6, 3, 5], as explained above.

Assume that:
N is an integer within the range [1..90,000]; each element of array T is an integer within the range [0..(N−1)]; there is exactly one (possibly indirect) connection between any two distinct roads.

Complexity:
expected worst-case time complexity is O(N); expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments). 

Problem Solving Algorithm
-------------------------

The algorithm I used to solve this problem is the "Greedy Algorithm". 

To approach a good solution the first thing I did was split the "Greed Algorith" logic into Java methods following the structure shown below:

<pre><code>
<ol>
<li>A candidate set, from which a solution is created</li>
<li>A selection function, which chooses the best candidate to be added to the solution</li>
<li>A feasibility function, that is used to determine if a candidate can be used to contribute to a solution</li>
<li>An objective function, which assigns a value to a solution, or a partial solution</li>
<li>A solution function, which will indicate when we have discovered a complete solution</li>
</ol>
</code></pre>

This approaching was taken after reading the next Wikipedia link about "Greedy Algorithms":

<pre><code>
http://en.wikipedia.org/wiki/Greedy_algorithm
</code></pre>

In my code this functions described above are coded in the class "TravelingGreedyAlgorythm.java" with the following names:

<pre><code>
<ol>
<li>public void setInitialCandidates(int[] destinyCities)</li>
<li>private PathCandidate selectNextPathDestinyCity(int originCityId)</li>
<li>private PathCandidate selectNextPathDestinyCity(int originCityId)</li>
<li>private void storeNextPathSolutionIfScoreIsMaximum(PathCandidate currentPath)</li>
<li>private boolean isCompleteSolution()</li>
</ol>
</code></pre>

Also, as it is an algorithm that requires several data structures I decided to split the classes as:

<pre><code>
<ul>
<li><b>TravelingGreedyAlgorythm:</b> The main class containing the algorithm logic.</li>
<li><b>CityCandidates:</b> The set of candidate cities (contains the city graph structure) </li>
<li><b>PathCandidatesQueue:</b> Wraps a queue of available paths of type <i>PathCandidate</i> for every iteration</li>
<li><b>PathCandidate:</b> Path of cities such as [0, 1, 2, ..., N] </li>
</ul>
</code></pre>

And now all you have to do is to have a look at the implementation. I also added a test class named:

<pre><code>
TestTravelingGreedyAlgorythm.java
</code></pre>

In this class I added the above given example:

<pre><code>
<b>Graph:</b> T[0] = 1 T[1] = 2 T[2] = 3 T[3] = 3 T[4] = 2 T[5] = 1 T[6] = 4
<b>Output sequence:</b> [2, 0, 6, 3, 5], as explained above.
</code></pre>

Contacts
--------

If there is any bug of just want to contact me:

You can contact me at: ivanpgs@gmail.com
I am also available at Linked-in: https://www.linkedin.com/profile/view?id=153419800

I have also a blog (written in Spanish) about Japan called http://japabanchel.com

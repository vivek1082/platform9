# platform9
coding solution for platform9
Repo For Solution for Coding Challenge by Platform9.
To run code use maven tool to build the project or create docker image by using docker tool.
Alternatively you can download jar file from build folder and run command "java -jar diwalibulbs-0.0.1-SNAPSHOT.jar"

Question --
##-----
A series of light bulbs is kept on display by the shopkeeper, where random bulbs are either switched ON or switched OFF.
Each bulb has its own switch to either turn it ON or turn it OFF.

Given the random state of N bulbs in the series and some constant K, the problem is to find out longest consecutive series of bulbs that appear ON, when K bulbs are switched from OFF state to ON state. 
Any K bulbs from the series can be picked up.

The program should take input as :

T
N 
K 
arr[]

Where, T is the number of test cases that need to be run, followed by tuple (N, K, arr[]) for each test.
Where tuple for each test is, 
N = Total number of bulbs in the series
K = Number of bulbs in OFF state that can be switched ON
arr[] = states of bulbs in the series, where 1 represents that the bulb is ON and 0 represents that the bulb is OFF.

Output: 
<consecutive number of bulbs that appear ON> 
<position/s of bulb>

Example:

Input:

1
11 
2 
10011010100

Output:
6 
5 7

Constraints:

1 <= T <= 500
1 <= K <= 1000
1 <= N <= 10000 

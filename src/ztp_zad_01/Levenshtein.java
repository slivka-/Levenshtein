package ztp_zad_01;

/**
 * @author Michał Śliwa
 */
public class Levenshtein 
{
    public static int calculateDistance(String firstInput, String secondInput)
    {
        int fiLen = firstInput.length();
        int siLen = secondInput.length();
        
        int[][] distance = new int[fiLen][siLen];
        
        for(int i=0;i<fiLen;i++)
            distance[i][0] = i;
        for(int j=0;j<siLen;j++)
            distance[0][j] = j;
        
        for(int i=1;i<fiLen;i++)
        {
            for(int j=1;j<siLen;j++)
            {
                int cost = (firstInput.charAt(i)==secondInput.charAt(j))? 0 : 1 ;
                int delDist = distance[i-1][j]+1;
                int insDist = distance[i][j-1]+1;
                int repDist = distance[i-1][j-1]+cost;
                distance[i][j] = Math.min(delDist, Math.min(insDist, repDist));
            }
        }
        return distance[fiLen-1][siLen-1];
    }
}

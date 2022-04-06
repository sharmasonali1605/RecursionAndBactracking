// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int dx[]= {1,-1,0,0,};
        int dy[]= {0,0,1,-1};
        int vis[][]=  new int[n][n];
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        /*for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(m[i][j]==1){
                dfs(i,j,n,vis,dx,dy,ans,m,path);
                }
            }
        }*/
        if(m[0][0]==1){
            dfs(0,0,n,vis,dx,dy,ans,m,path);
            return ans;
        }
        ans.add("-1");
        return ans;

    }


    public static void dfs(int r,int c,int n , int vis[][], int dx[], int dy[],ArrayList<String> ans, int [][]m
            ,StringBuilder path){
        if(r==n-1 && c==n-1){
            ans.add(path.toString());
            return;
        }
        vis[r][c]=1;
        for(int i=0;i<dx.length;i++){
            int x = r+dx[i];
            int y = c+dy[i];
            if(isValid(x,y,n) && vis[x][y]!=1 && m[x][y]!=0){
                if((dx[i]==1 && dy[i]==0)){
                    path.append("D");
                }
                if((dx[i]==-1 && dy[i]==0)){
                    path.append("U");
                }
                if((dx[i]==0 && dy[i]==-1)){
                    path.append("L");
                }
                if((dx[i]==0 && dy[i]==1)){
                    path.append("R");
                }
                dfs(x,y,n,vis,dx,dy,ans,m,path);
                path.deleteCharAt(path.length()-1);
                vis[x][y]=0;
            }
        }
    }

    public static boolean isValid(int x , int y , int n ){
        if((x>=0 && x<n) && (y>=0 && y<n)){
            return true;
        }
        return false;
    }
}
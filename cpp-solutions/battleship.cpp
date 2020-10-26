#include<bits/stdc++.h>
#define MAX_N 5
using namespace std;

int shipSizes[MAX_N];
int n;
int k;

template <size_t rows, size_t cols>
int countPossibilities(char (&grid)[rows][cols], int i){
    int possib = 0;
    if(i<k) {
        for (int j = 0; j < n-shipSizes[i]+1; j++) {
            for (int m = 0; m < n; m++) {
                char grid1[MAX_N][MAX_N]; for(int a=0;a<n;a++){for(int b=0;b<n;b++){grid1[a][b]=grid[a][b];}}
                bool possible1 = true;
                for (int k = 0; k < shipSizes[i] && possible1; k++) {
                    int row = j+k;
                    if(grid1[row][m]=='O' || grid1[row][m]=='.') {
                        grid1[row][m] = 'X';
                        //grid1[row][m] = (i+"").charAt(0);
                    }else {
                        possible1 = false;
                    }
                }
                //for(int a=0;a<n;a++){for(int b=0;b<n;b++){cout << grid1[a][b] << "\t";}cout << endl;}
                if(possible1) {
                    //cout << "is possible ..." << endl;
                    //bw.write(i+" vertical possible "+shipSizes[i]+"\n");
                    //bw.write(Arrays.deepToString(grid)+"\n");
                    //bw.write(Arrays.deepToString(grid1)+"\n");
                    possib += countPossibilities(grid1,i+1);
                }
            }
        }
        
        if(shipSizes[i]>1) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < n-shipSizes[i]+1; m++) {
                    char grid2[MAX_N][MAX_N]; for(int a=0;a<n;a++){for(int b=0;b<n;b++){grid2[a][b]=grid[a][b];}}
                    bool possible2 = true;
                    for (int k = 0; k < shipSizes[i] && possible2; k++) {
                        int col = m+k;
                        if(grid2[j][col]=='O' || grid2[j][col]=='.') {
                            grid2[j][col] = 'X';
                            //grid2[j][col] = (i+"").charAt(0);
                        }else {
                            possible2 = false;
                        }
                    }
                    //for(int a=0;a<n;a++){for(int b=0;b<n;b++){cout << grid2[a][b] << "\t";}cout << endl;}
                    if(possible2) {
                        //cout << "is possible ..." << endl;
                        //bw.write(i+" horizontal possible "+shipSizes[i]+"\n");
                        //bw.write(Arrays.deepToString(grid)+"\n");
                        //bw.write(Arrays.deepToString(grid2)+"\n");
                        possib += countPossibilities(grid2,i+1);
                    }
                }
            }
        }
    }else {
        bool remainingO = false;
        for (int j = 0; j < n; j++) {
            for (int m = 0; m < n; m++) {
                if(grid[j][m]=='O') {
                    remainingO = true;
                }
            }
        }
        if(!remainingO) {
            possib = 1;
        }
    }
    return possib;
}

int main(){
    cin >> n;
    cin >> k;

    //cout << "n is "<< n << endl;
    //cout << "k is "<< k << endl;
    
    char grid[MAX_N][MAX_N];

    int poss = 0;
    for (int i = 0; i < n; i++) {
        string line; cin >> line;
        for (int j = 0; j < n; j++) {
            grid[i][j] = line[j];
            if(grid[i][j]=='O'||grid[i][j]=='.') {
                poss++;
            }
        }
    }

    //for(int a=0;a<n;a++){for(int b=0;b<n;b++){cout << grid[a][b] << "\t";}cout << endl;}

    int posShips = 0;
    for (int i = 0; i < k; i++) {
        cin >> shipSizes[i];
        posShips+=shipSizes[i];
    }

    //for(int a=0;a<k;a++){cout << shipSizes[a] << ",";}cout << endl;
    //cout << "poss is " << poss << endl;
    //cout << "posShips is " << posShips << endl;

    if(poss<posShips) {
        cout << "0\n";
    }else {
        //cout << "calculating possibilities ..." << endl;
        cout << countPossibilities(grid,0) << endl;
    }

    return 0;
}
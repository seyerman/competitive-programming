#include<bits/stdc++.h>

using namespace std;

template <size_t rows, size_t cols>
void process_2d_array_template(int (&array)[rows][cols])
{
    std::cout << __func__ << std::endl;
    for (size_t i = 0; i < rows; ++i)
    {
        std::cout << i << ": ";
        for (size_t j = 0; j < cols; ++j)
            std::cout << array[i][j] << '\t';
        std::cout << std::endl;
    }
}

int main(){
    //int n;cin>>n;
    //int matrix[n][n]{};
    int matrix[5][3]{};
    process_2d_array_template(matrix);
}
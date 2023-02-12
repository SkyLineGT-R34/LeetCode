package org.example.medium;
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:
P   A   H   N
A P L S I I G
Y   I   R

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */


import java.util.ArrayList;
import java.util.List;

public class Zigzag_Conversion_6 {
    public static void main(String[] args) {
        System.out.println(convert("ABC",3));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++){
            rows[i]=new StringBuilder();
        }
        int blockLength = numRows*2-2;
        int blocksQuantity = s.length() / blockLength;
        for (int blockNow = 0; blockNow < blocksQuantity; blockNow++){
            int offset = blockNow*blockLength;
            rows[0].append(s.charAt(offset));
            for (int rowInBlock=1; rowInBlock<numRows-1; rowInBlock++){
                rows[rowInBlock].append(s.charAt(offset+rowInBlock)).append(s.charAt(offset+blockLength-rowInBlock));
            }
            rows[numRows-1].append(s.charAt(offset+numRows-1));
        }
        int offset = blocksQuantity*blockLength;
        if (offset < s.length()) {
            rows[0].append(s.charAt(offset));
        }
        for (int rowInBlock=1; rowInBlock<numRows-1; rowInBlock++){
            if (offset+rowInBlock < s.length()) {
                rows[rowInBlock].append(s.charAt(offset+rowInBlock));
            }
            if (offset+blockLength-rowInBlock < s.length()) {
                rows[rowInBlock].append(s.charAt(offset + blockLength - rowInBlock));
            }
        }
        if (offset+numRows-1 < s.length()) {
            rows[numRows-1].append(s.charAt(offset+numRows-1));
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row:rows) {
            result.append(row);
        }
        return result.toString();
    }
}

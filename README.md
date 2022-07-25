# Huffman Encoding
Programming assignment for CSCI0302: Algorithms and Comlpexity at Middlebury College

An implementation of Huffman's binary encoding algorithm that takes in a String as an input and outputs a new String containing only 0's and 1's that is the encoding of the original String along with a dictionary that can be used to translate between binary and English.

## Description
Through a greedy technique, this program can take any inputted String including lower case letters, upper case letters, and the following punctuation: commas, periods, exclamation points, question marks, and apostraphes. I implemented the algorithm using a priority queue and a hashmap to reduce the overall runtime O(nlogn) where n is the number of unique characters. 

## Executing the Program
1. To run from the command line, open a terminal/shell in the directory where Huffman.java is located.
2. To compile:
    ```
    javac Huffman.java
    ```
3. To run:
    ```
    java -cp . Huffman
    ```
    *(-cp allows you to tell java where to look for the compiled code, and . tells it to look in the        current directory)*

## Authors
Nusrat Atiya

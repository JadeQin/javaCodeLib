package topCoder.srm476;

/**
 * Problem Statement      A string X is an anagram of string Y if X can be
 * obtained by arranging all characters of Y in some order, without removing any
 * characters and without adding new characters. For example, each of the
 * strings "baba", "abab", "aabb" and "abba" is an anagram of "aabb", and
 * strings "aaab", "aab" and "aabc" are not anagrams of "aabb". A string X is a
 * subsequence of string Y if X can be obtained by removing some characters
 * (possibly none) from Y and preserving the order of the remaining characters.
 * For example, each of the strings "ac", "abd", "abcd" is a subsequence of
 * "abcd", and strings "ca", "abb" and "abcde" are not subsequences of "abcd". A
 * string X is called a subanagram of Y if there exists a string Z such that X
 * is an anagram of Z and Z is a subsequence of Y. Manao is a big fan of
 * subanagrams and he tries to find them everywhere. This time, he works on
 * splitting strings into several parts in such a way that each of the parts
 * (except the last one) is a subanagram of the following part. Formally, for a
 * given string X, Manao wants to split it into several non-empty strings S1,
 * S2, ..., Sn such that their concatenation S1 + S2 + ... + Sn equals X and
 * each string Si (0 < i < n) is a subanagram of string Si+1. You're given a
 * String[] suppliedWord. Concatenate all its elements in the order they are
 * given to obtain a single string X. Return the maximum number of parts into
 * which Manao can split X so that the condition from the previous paragraph is
 * satisfied. Definition      Class: SubAnagrams Method: maximumParts
 * Parameters: String[] Returns: int Method signature: int maximumParts(String[]
 * suppliedWord) (be sure your method is public)     
 * 
 * Constraints - suppliedWord will contain between 1 and 10 elements, inclusive.
 * - Each element of suppliedWord will contain between 1 and 50 characters,
 * inclusive. - suppliedWord will consist of uppercase letters ('A'-'Z') only.
 * Examples 0)
 * 
 *      {"ABABAB"} Returns: 3 Manao can split the given string in three "AB"-s.
 * 1)
 * 
 *      {"AAXAAAABX"} Returns: 4 One of the possible ways to split "AAXAAAABX"
 * into 4 parts is "A"+"A"+"XA"+"AAABX". "XA" is the anagram of "AX", a
 * subsequence of "AAABX". 2)
 * 
 *      {"ABCDEFGHIJKL"} Returns: 1 This word is not splittable. 3)
 * 
 *      {"ABBAB","B","BBX","Z"} Returns: 2 Don't forget to concatenate the given
 * strings.
 * 
 * @author AAA
 * 
 */

public class SubAnagrams {

	public int maximumParts(String[] suppliedWord) {
		return 0;
	}
}

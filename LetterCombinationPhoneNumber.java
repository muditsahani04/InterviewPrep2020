class Solution {
    public List<String> letterCombinations(String digits) {

        String[] checker = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String[] input = new String[digits.length()];
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0)
            return res;
        char[] charArray = new char[digits.length()];
        for (int i=0; i<digits.length(); i++)
        {
            input[i] = checker[Integer.parseInt(String.valueOf(digits.charAt(i)))];
        }
        helper(0, input, res, charArray);
        return res;
    }

    private void helper(int level, String[] input, List<String> res, char[] charArray)
    {
        if (level == input.length)
        {
            res.add(String.valueOf(charArray));
            return;
        }

        for (int i=0; i<input[level].length(); i++)
        {
            charArray[level] = input[level].charAt(i);
            helper(level+1, input, res, charArray);
        }

    }
}

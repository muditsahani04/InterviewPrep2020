class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalidIndices = new HashSet<Integer>();
        if (s=="" || s==" ")
            return s;

        StringBuilder res = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int start = 0;
        while (start< s.length() && s.charAt(start) == ')')
        {
            invalidIndices.add(start);
            start++;
        }

        for (int i=start; i<s.length(); i++)
        {
            switch(s.charAt(i))
            {
                case '(' : stack.push(i);break;
                case ')' :
                    if (stack.isEmpty())
                        invalidIndices.add(i);
                    else
                        stack.pop();break;
                default : break;
            }

        }

        while (!stack.isEmpty())
        {
            invalidIndices.add(stack.pop());
        }

        for (int i=0; i<s.length(); i++)
        {
            if (!invalidIndices.contains(i))
               res.append(s.charAt(i));
        }

    return res.toString();
    }
}

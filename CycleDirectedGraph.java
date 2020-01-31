class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean res = false;
        if (prerequisites.length == 0)
            return true;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i=0; i<prerequisites.length; i++)
        {
            List<Integer> temp = map.getOrDefault(prerequisites[i][0], new ArrayList<Integer>());

            for (int j=1; j<prerequisites[0].length; j++)
            {
                temp.add(prerequisites[i][j]);
            }
            map.put(prerequisites[i][0], new ArrayList<Integer>(temp));
        }


        Set<Integer> visiting = new HashSet<Integer>();

        for (int key : map.keySet())
        {
            if (cyclicHelper(visiting,map, key))
                return false;
        }



     return true;

    }

    private boolean cyclicHelper(Set<Integer> visiting,Map<Integer, List<Integer>> map, int curr)
    {
        if (visiting.contains(curr))
            return true;

        visiting.add(curr);

        if (map.containsKey(curr))
        {
            for (int key : map.get(curr))
            {
                if (cyclicHelper(visiting,map, key))
                    return true;
            }
        }

        visiting.remove(curr);
        return false;
    }

}

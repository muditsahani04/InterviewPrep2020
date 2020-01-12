import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerListPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		output = permuteDuplicate(new int[] {1,1,2});
	}
	
	public static List<List<Integer>> permute(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Integer[] temp = new Integer[nums.length];
		boolean[] isUsed = new boolean[nums.length];
		permuteHelper(nums, temp, 0, res, isUsed);
		return res;
	}
	
	private static void permuteHelper(int[] nums, Integer[] temp, int depth, List<List<Integer>> res, boolean[] isUsed)
	{
		if (depth == nums.length)
		{
			List<Integer> arrToList = Arrays.asList(temp);
			res.add(new ArrayList<Integer>(arrToList));
			return;
		}
		
		for (int i=0; i<nums.length; i++ )
		{
			if (!isUsed[i])
			{
				temp[depth] = nums[i];
				isUsed[i] = true;
				permuteHelper(nums, temp, depth+1, res, isUsed);
				isUsed[i] = false;
			}
				
		}
		
	}
	
	public static List<List<Integer>> permuteDuplicate(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Integer[] temp = new Integer[nums.length];
		int[] countArr = new int[nums.length];
		int[] numArr = new int[nums.length];
		
		Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
		
		for (int num : nums)
		{
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		
		int i=0;
		for (Integer key : countMap.keySet())
		{
			numArr[i] = key;
			countArr[i] = countMap.get(key);
			i++;
		}
		
		permuteDuplicateHelper(numArr, countArr, temp, 0, res);
		return res;
	}
	
	private static void permuteDuplicateHelper(int[] numArr, int[] countArr, Integer[] temp, int depth, List<List<Integer>> res)
	{
		if (depth == temp.length)
		{
			List<Integer> copy =  Arrays.asList(temp);
			res.add(new ArrayList<Integer>(copy));
			return;
		}
		
		for (int i=0; i<numArr.length; i++)
		{
			if (countArr[i] > 0)
			{
				temp[depth] = numArr[i];
				countArr[i]--;
				permuteDuplicateHelper(numArr, countArr, temp, depth+1, res);
				countArr[i]++;
			}
		}
		
	}
	

}

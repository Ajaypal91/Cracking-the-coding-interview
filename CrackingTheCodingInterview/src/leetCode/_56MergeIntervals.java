package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution

public class _56MergeIntervals {

	static class Interval{
		int start;
		int end;
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	
	public static void main(String[] args) {
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(3, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		
		List<Interval> result = merge(intervals);
		
		for(Interval i :  result){
			System.out.println(i.start + " " + i.end);
		}
		
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        
        if(intervals.size() == 0)
        	return result;
        
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        
        for(Interval i : intervals){
        	starts.add(i.start);
        	ends.add(i.end);
        }
        
        Collections.sort(starts);
        Collections.sort(ends);
        
        int first = 1;
        int second = 0;
        int n = intervals.size();
        int index = 0;
        boolean isMerging = false;
        
        while(first != n && second != n){
        	
        	if(starts.get(first) <= ends.get(second)){
        		
        		if(!isMerging){
        			isMerging = true;
        			index = second;
        		}
        		
        		first++; second++;
        		
        	}
        	else{
        		
        		if(isMerging){
        			isMerging = false;
        			Interval temp = new Interval(starts.get(index), ends.get(second));
        			result.add(temp);
        		}
        		else{
        			Interval temp = new Interval(starts.get(second),ends.get(second));
        			result.add(temp);
        		}
        		first++;second++;
        	}
        	
        }
        
        if(isMerging){
			isMerging = false;
			Interval temp = new Interval(starts.get(index), ends.get(second));
			result.add(temp);
			first++;second++;
		}
        if(second!=n){
        	Interval temp = new Interval(starts.get(second),ends.get(second));
			result.add(temp);
        }
        
        return result;         
    }

}

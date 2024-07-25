package com.test;

import com.cat.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author _qiu
 */
@Component
public class test {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(test.class);
    //</editor-fold>
    //@Autowired
//    private RedisService redisService;
//
//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
//    @AllArgsConstructor
//    @Data
//    static class P{
//        String name;
//    }
    @Log(title = "test")
    public String test1(P p) {
//        P p=new P("zhangsan");
//        redisService.setCacheObject("zhangsan",p);
//        Object zhangsan = redisService.getCacheObject("zhangsan");
        //System.out.println("zhangsan");
        //throw new RuntimeException("456");
        return "zhangsan ";
        //System.out.println(myService.addSuffix("789"));
    }

    public static void main(String[] args) {
        lengthOfLongestSubsequence(Arrays.asList(1,1,5,4,5),3);
    }
    public static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//        nums.sort((Comparator.comparingInt(o -> o)));
//        int[] arr=new int[nums.size()];
//        arr[0]=nums.get(0);
//        for (int i = 1; i < nums.size(); i++) {
//            arr[i]=arr[i-1]+nums.get(i);
//            if(arr[i]==target){
//                return i+1;
//            } else if(arr[i]>target&&nums.contains(arr[i]-target)){
//                return i;
//            }
//        }
        int[] arr=new int[target+1];
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i)>target){
                continue;
            }
            for (int j = target; j > nums.get(i); j--) {
                if(arr[j- nums.get(i)]>0){
                    arr[j]=Math.max(arr[j- nums.get(i)]+1,arr[j]);
                }
            }
            if(arr[nums.get(i)]==0){
                arr[nums.get(i)]++;
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}
